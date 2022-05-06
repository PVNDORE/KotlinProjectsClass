package fr.eni.mmoisan.movieapp.retrofit

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import fr.eni.mmoisan.movieapp.entities.ImdbResult
import fr.eni.mmoisan.movieapp.entities.Movie
import fr.eni.mmoisan.movieapp.retrofit.MovieService.Companion.retrofit
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

interface MovieService {
    companion object {
        val BASE_URL = "https://imdb-api.com/en/API/SearchMovie/k_vv0nvqrq/"
        val client = OkHttpClient.Builder()
            .addInterceptor { chain -> return@addInterceptor addApiKeyToRequests(chain) }
            .build()
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()

        private fun addApiKeyToRequests(chain: Interceptor.Chain): Response {
            val request = chain.request().newBuilder()
            val originalHttpUrl = chain.request().url()
            val newUrl = originalHttpUrl.newBuilder()
                .addQueryParameter("api_key", "k_vv0nvqrq").build()
            request.url(newUrl)
            return chain.proceed(request.build())
        }
    }

    @GET("inception")
    suspend fun getMovie(): ImdbResult
}


object MovieApi {
    val retrofitService: MovieService by lazy { retrofit.create(MovieService::class.java) }
}
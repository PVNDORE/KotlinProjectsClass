package fr.wololo.demoretrofit.retrofit

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import fr.wololo.demoretrofit.entities.Global
import fr.wololo.demoretrofit.retrofit.ProducteursService.Companion.retrofit
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


interface ProducteursService {
    companion object {
        val BASE_URL = "https://opendata.agencebio.org/"
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val retrofit = Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .baseUrl(BASE_URL)
            .build()
    }

    @GET("api/gouv/operateurs?departements=35")
    suspend fun getProducteurs(): Global
}


object ProducteursApi {
    val retrofitService: ProducteursService by lazy { retrofit.create(ProducteursService::class.java) }
}
package fr.eni.mmoisan.movieapp.ui.api

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.eni.mmoisan.movieapp.entities.ImdbResult
import fr.eni.mmoisan.movieapp.retrofit.MovieApi
import kotlinx.coroutines.launch

class ApiViewModel: ViewModel() {
    val imdbResult = MutableLiveData<ImdbResult>()
    val status = MutableLiveData<String>()

    fun getMovie() {
        viewModelScope.launch {
            try {
                var result = MovieApi.retrofitService.getMovie()
                status.value = "OK"
                imdbResult.value = result
                Log.i("PVN","OK")
            } catch (e: Exception) {
                status.value = "KO : ${e.message}"
                Log.i("PVN","KO : ${e.message}")
            }
        }
    }
}
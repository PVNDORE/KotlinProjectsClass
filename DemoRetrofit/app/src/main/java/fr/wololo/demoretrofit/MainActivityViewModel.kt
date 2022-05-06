package fr.wololo.demoretrofit

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.wololo.demoretrofit.entities.Global
import fr.wololo.demoretrofit.retrofit.ProducteursApi
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    val global = MutableLiveData<Global>()
    val status = MutableLiveData<String>()

    fun getProducteurs() {
        viewModelScope.launch {
            try {
                var result = ProducteursApi.retrofitService.getProducteurs()
                status.value = "OK"
                global.value = result
                Log.i("ACOS","OK")
            } catch (e: Exception) {
                status.value = "KO : ${e.message}"
                Log.i("ACOS","KO : ${e.message}")
            }
        }
    }
}
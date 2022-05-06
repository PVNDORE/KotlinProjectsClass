package fr.eni.mmoisan.myappwithroom.dao

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.eni.mmoisan.myappwithroom.MainActivityViewModel

class DependencyInjection(val ctxt: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainActivityViewModel::class.java))
        {
            val dao = MyDataBase.getInstance(ctxt).MovieDao()
            return MainActivityViewModel(dao) as T
        }
        throw Exception()
    }
}
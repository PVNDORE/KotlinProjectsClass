package fr.eni.mmoisan.movieapp.dao

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.eni.mmoisan.movieapp.ui.add.AddMovieViewModel
import fr.eni.mmoisan.movieapp.ui.list.ListMovieViewModel

class DependencyInjection(val ctxt: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AddMovieViewModel::class.java))
        {
            val dao = MyDataBase.getInstance(ctxt).MovieDao()
            return AddMovieViewModel(dao) as T
        }
        if (modelClass.isAssignableFrom(ListMovieViewModel::class.java))
        {
            val dao = MyDataBase.getInstance(ctxt).MovieDao()
            return ListMovieViewModel(dao) as T
        }
        throw Exception()
    }
}
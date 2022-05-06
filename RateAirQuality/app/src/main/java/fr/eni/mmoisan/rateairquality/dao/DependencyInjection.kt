package fr.eni.mmoisan.rateairquality.dao

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import fr.eni.mmoisan.rateairquality.ui.gallery.GalleryViewModel
import fr.eni.mmoisan.rateairquality.ui.home.HomeViewModel

class DependencyInjection(val ctxt: Context) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java))
        {
            val dao = MyDataBase.getInstance(ctxt).AirQualityDao()
            return HomeViewModel(dao) as T
        }
        if (modelClass.isAssignableFrom(GalleryViewModel::class.java))
        {
            val dao = MyDataBase.getInstance(ctxt).AirQualityDao()
            return GalleryViewModel(dao) as T
        }
        throw Exception()
    }
}
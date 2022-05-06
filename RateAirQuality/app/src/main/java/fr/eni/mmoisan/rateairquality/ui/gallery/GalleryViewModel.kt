package fr.eni.mmoisan.rateairquality.ui.gallery

import android.util.Log
import androidx.lifecycle.ViewModel
import fr.eni.mmoisan.rateairquality.dao.AirQualityDao

class GalleryViewModel(val dao: AirQualityDao) : ViewModel() {

    fun showInLog() {
        for (item in dao.getAll())
        {
            Log.i("PVN", "Air Quality : $item")
        }
    }
}
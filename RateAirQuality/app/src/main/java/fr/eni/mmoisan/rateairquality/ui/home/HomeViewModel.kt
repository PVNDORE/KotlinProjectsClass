package fr.eni.mmoisan.rateairquality.ui.home

import android.util.Log
import androidx.lifecycle.ViewModel
import fr.eni.mmoisan.rateairquality.dao.AirQualityDao
import fr.eni.mmoisan.rateairquality.entities.AirQuality

class HomeViewModel(val dao: AirQualityDao) : ViewModel() {

    var myAirQuality = AirQuality()

    fun save() {

        dao.insert(myAirQuality)

        Log.i("PVN", "SUCCESS")
    }
}
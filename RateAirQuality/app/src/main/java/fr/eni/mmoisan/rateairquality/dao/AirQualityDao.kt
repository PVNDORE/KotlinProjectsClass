package fr.eni.mmoisan.rateairquality.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import fr.eni.mmoisan.rateairquality.entities.AirQuality

@Dao
interface AirQualityDao {

    @Insert
    fun insert(airQuality: AirQuality)

    @Query("SELECT * FROM AirQuality ORDER BY place")
    fun getAll():List<AirQuality>

}
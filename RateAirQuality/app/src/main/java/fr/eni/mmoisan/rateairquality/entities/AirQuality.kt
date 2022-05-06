package fr.eni.mmoisan.rateairquality.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AirQuality(@PrimaryKey(autoGenerate = true) var id:Int=0, var place:String="", var rating:Float=0f)

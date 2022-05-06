package fr.eni.mmoisan.movieapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Movie(@PrimaryKey(autoGenerate = true) var id:Int?=0, var title:String?="", var duration:Int?=0, var nationality:String?="") {}
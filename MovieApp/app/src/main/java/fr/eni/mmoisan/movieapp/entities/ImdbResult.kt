package fr.eni.mmoisan.movieapp.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ImdbResult(@PrimaryKey(autoGenerate = true) var id:Int?=0, var searchType: String?="", var expression: String?="", var results: List<Movie> )

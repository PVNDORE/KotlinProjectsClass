package fr.eni.mmoisan.movieapp.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import fr.eni.mmoisan.movieapp.entities.Movie

@Dao
interface MovieDao
{
    @Insert
    fun insert(movie: Movie)

    @Query("SELECT * FROM Movie ORDER BY title")
    fun getAll():LiveData<List<Movie>>

    @Query("SELECT * FROM Movie WHERE id = :id")
    fun getById(id:Int):Movie
}
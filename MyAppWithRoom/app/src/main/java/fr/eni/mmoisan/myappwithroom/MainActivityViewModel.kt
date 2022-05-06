package fr.eni.mmoisan.myappwithroom

import android.util.Log
import androidx.lifecycle.ViewModel
import fr.eni.mmoisan.myappwithroom.dao.MovieDao
import fr.eni.mmoisan.myappwithroom.entities.Movie

class MainActivityViewModel(val dao: MovieDao): ViewModel() {

    var myMovie: Movie = Movie()

    var duration: String = ""

    var ListMovie = dao.getAll()

    fun save()
    {
        myMovie.duration = this.duration.toInt()

        dao.insert(myMovie)

        Log.i("PVN", "Movie saved")
    }
}
package fr.eni.mmoisan.movieapp.ui.add

import androidx.lifecycle.ViewModel
import fr.eni.mmoisan.movieapp.dao.MovieDao
import fr.eni.mmoisan.movieapp.entities.Movie

class AddMovieViewModel(val dao: MovieDao): ViewModel() {

    var myMovie: Movie = Movie()

    var duration: String = ""

    fun save() {
        myMovie.duration = this.duration.toInt()

        dao.insert(myMovie)
    }
}
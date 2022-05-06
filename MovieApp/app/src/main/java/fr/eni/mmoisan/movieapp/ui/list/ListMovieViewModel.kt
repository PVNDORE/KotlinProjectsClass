package fr.eni.mmoisan.movieapp.ui.list

import androidx.lifecycle.ViewModel
import fr.eni.mmoisan.movieapp.dao.MovieDao

class ListMovieViewModel(val dao: MovieDao): ViewModel() {

    var ListMovies = dao.getAll()

}
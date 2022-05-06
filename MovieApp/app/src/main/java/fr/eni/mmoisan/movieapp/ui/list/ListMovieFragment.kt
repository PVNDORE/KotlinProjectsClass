package fr.eni.mmoisan.movieapp.ui.list

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import fr.eni.mmoisan.movieapp.R
import fr.eni.mmoisan.movieapp.dao.DependencyInjection
import fr.eni.mmoisan.movieapp.databinding.FragmentAddMovieBinding
import fr.eni.mmoisan.movieapp.databinding.FragmentListMovieBinding
import fr.eni.mmoisan.movieapp.ui.add.AddMovieViewModel

class ListMovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vm = ViewModelProvider(this, DependencyInjection(this.requireContext()))[ListMovieViewModel::class.java]
        var binding = FragmentListMovieBinding.inflate(inflater, container, false)

        var adapter = AdapterMovie()
        binding.rvMovie.adapter = adapter

        vm.ListMovies.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        return binding.root
    }
}
package fr.eni.mmoisan.movieapp.ui.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import fr.eni.mmoisan.movieapp.dao.DependencyInjection
import fr.eni.mmoisan.movieapp.databinding.FragmentAddMovieBinding

class AddMovieFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val vm = ViewModelProvider(this, DependencyInjection(this.requireContext()))[AddMovieViewModel::class.java]
        var binding = FragmentAddMovieBinding.inflate(inflater, container, false)

        binding.model = vm

        return binding.root
    }
}
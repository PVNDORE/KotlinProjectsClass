package fr.eni.mmoisan.movieapp.ui.api

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import fr.eni.mmoisan.movieapp.R
import fr.eni.mmoisan.movieapp.databinding.FragmentApiBinding

class ApiFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var vm = ViewModelProvider(this)[ApiViewModel::class.java]
        var binding = FragmentApiBinding.inflate(inflater, container, false)

        vm.imdbResult.observe(viewLifecycleOwner, Observer {
            Log.i("PVN", "Info : " + it?.expression)
            for (movie in it.results)
            {
                Log.i("ACOS", "producteur : $movie")
            }
        })

        binding.btnGetMovie.setOnClickListener {
            Log.i("PVN","Hello there !")
            vm.getMovie()
        }

        return binding.root
    }
}
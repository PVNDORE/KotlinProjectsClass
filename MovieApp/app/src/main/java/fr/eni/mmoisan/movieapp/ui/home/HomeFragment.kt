package fr.eni.mmoisan.movieapp.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import fr.eni.mmoisan.movieapp.R
import fr.eni.mmoisan.movieapp.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val homeViewModel =
            ViewModelProvider(this)[HomeViewModel::class.java]

        var binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        binding.btnApi.setOnClickListener {
            Navigation.findNavController(it).navigate(R.id.action_nav_home_to_apiFragment)
        }

        return root
    }
}
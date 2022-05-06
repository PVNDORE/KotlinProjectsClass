package fr.eni.mmoisan.colorme

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import fr.eni.mmoisan.colorme.databinding.FragmentHomeBinding

class Home : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val vb = FragmentHomeBinding.inflate(layoutInflater)

        vb.btnOk.setOnClickListener {
            // useless for now
            var value = vb.etFirstname.text.hashCode()/1_000_000

            Navigation.findNavController(it).navigate(R.id.action_home2_to_randomWord)
        }

        return vb.root
    }
}
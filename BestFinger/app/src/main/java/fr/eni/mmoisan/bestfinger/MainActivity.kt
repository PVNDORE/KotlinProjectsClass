package fr.eni.mmoisan.bestfinger

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import fr.eni.mmoisan.bestfinger.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var bd: ActivityMainBinding
    var myDiceViewModel: DiceViewModel = DiceViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bd = ActivityMainBinding.inflate(layoutInflater)

        myDiceViewModel = ViewModelProvider(this).get(DiceViewModel::class.java)

        myDiceViewModel.totalLaunch.observe(this, Observer {
            bd.model = myDiceViewModel
        })

        setContentView(bd.root)
    }
}
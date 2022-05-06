package fr.eni.mmoisan.myappwithroom

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import fr.eni.mmoisan.myappwithroom.dao.DependencyInjection
import fr.eni.mmoisan.myappwithroom.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var dataB = ActivityMainBinding.inflate(layoutInflater)
        var vm = ViewModelProvider(this, DependencyInjection(this)).get(MainActivityViewModel::class.java)

        dataB.model = vm

        vm.ListMovie.observe(this, Observer {
            for (item in it)
            {
                Log.i("PVN", "Movie : $item")
            }
        })

        setContentView(dataB.root)
    }
}
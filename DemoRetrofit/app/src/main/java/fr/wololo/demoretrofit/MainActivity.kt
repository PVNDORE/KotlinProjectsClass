package fr.wololo.demoretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import fr.wololo.demoretrofit.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        var vb = ActivityMainBinding.inflate(layoutInflater)

        var vm = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        vm.global.observe(this, Observer {
            Log.i("ACOS", "Info : " + it?.nbTotal)
            for (producteur in it.items)
            {
                Log.i("ACOS", "producteur : $producteur")
            }

        })

        vb.btnSearch.setOnClickListener {
            Log.i("ACOS","Yaaaaaa")
            vm.getProducteurs()
        }


        setContentView(vb.root)




    }




}
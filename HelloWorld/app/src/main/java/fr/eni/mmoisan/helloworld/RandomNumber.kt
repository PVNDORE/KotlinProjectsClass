package fr.eni.mmoisan.helloworld

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import fr.eni.mmoisan.helloworld.databinding.ActivityMainBinding
import fr.eni.mmoisan.helloworld.databinding.ActivityRandomNumberBinding

class RandomNumber: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val vb = ActivityRandomNumberBinding.inflate(layoutInflater)
        setContentView(vb.root)

        vb.btnSubmit.setOnClickListener {

            val min = vb.etMin.text.toString().toInt()
            val max = vb.etMax.text.toString().toInt()

            val random = (min..max).random()

            vb.tvResult.text= random.toString()
        }
    }
}
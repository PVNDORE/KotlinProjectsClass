package fr.eni.mmoisan.demofirebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.eni.mmoisan.demofirebase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vb = ActivityMainBinding.inflate(layoutInflater)

        vb.btnAuth.setOnClickListener {
            startActivity(Intent(this, DemoAuthentificationActivity::class.java))
        }

        vb.btnFirestore.setOnClickListener {
            startActivity(Intent(this, DemoFirestoreActivity::class.java))
        }

        vb.btnRealtimedb.setOnClickListener {
            startActivity(Intent(this, DemoRealtimeDatabaseActivity::class.java))
        }

        vb.btnStorage.setOnClickListener {
            startActivity(Intent(this, DemoStorageActivity::class.java))
        }

        setContentView(vb.root)
    }
}
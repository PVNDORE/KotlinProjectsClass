package fr.eni.mmoisan.demofirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.ktx.database
import com.google.firebase.database.ktx.getValue
import com.google.firebase.ktx.Firebase
import fr.eni.mmoisan.demofirebase.databinding.ActivityDemoRealtimeDatabaseBinding

class DemoRealtimeDatabaseActivity : AppCompatActivity() {

    val database = Firebase.database
    val myRef = database.getReference("song")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vb = ActivityDemoRealtimeDatabaseBinding.inflate(layoutInflater)

        vb.btnSave.setOnClickListener {
            myRef.setValue(vb.etValue.text.toString())
        }

        // Read from the database
        myRef.addValueEventListener(object: ValueEventListener {

            override fun onDataChange(snapshot: DataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                val value = snapshot.getValue<String>()

                vb.tvValue.text = value

            }

            override fun onCancelled(error: DatabaseError) {
                Log.w("PVN", "Failed to read value.", error.toException())
            }

        })


        setContentView(vb.root)
    }
}
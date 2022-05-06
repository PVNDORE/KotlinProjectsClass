package fr.eni.mmoisan.demofirebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import fr.eni.mmoisan.demofirebase.databinding.ActivityDemoFirestoreBinding
import java.util.*

class DemoFirestoreActivity : AppCompatActivity() {

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val vb = ActivityDemoFirestoreBinding.inflate(layoutInflater)

        vb.btnSave.setOnClickListener {
            // Create a new user with a first and last name
            val music = hashMapOf(
                "id" to UUID.randomUUID(),
                "artist" to vb.etArtist.text.toString(),
                "song" to vb.etSong.text.toString()
            )

            // Add a new document with a generated ID
            db.collection("musics")
                .add(music)
                .addOnSuccessListener { documentReference ->
                    Log.d("PVN", "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w("PVN", "Error adding document", e)
                }
        }



        vb.btnDisplay.setOnClickListener {
            db.collection("musics")
                .get()
                .addOnSuccessListener { result ->
                    var resultat = ""
                    for (document in result) {
                        Log.d("PVN", "${document.id} => ${document.data}")
                        resultat += document.data.get("artist")
                        resultat += " - "
                        resultat += document.data.get("song")
                        resultat += "\n"
                    }
                    vb.tvSongs.text = resultat
                }
                .addOnFailureListener { exception ->
                    Log.w("PVN", "Error getting documents.", exception)
                }
        }

        setContentView(vb.root)
    }
}
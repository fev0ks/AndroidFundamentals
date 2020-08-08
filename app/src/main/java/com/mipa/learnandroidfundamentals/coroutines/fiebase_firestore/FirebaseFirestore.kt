package com.mipa.learnandroidfundamentals.coroutines.fiebase_firestore

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.mipa.learnandroidfundamentals.R
import kotlinx.android.synthetic.main.activity_firebase_firestore.*
import kotlinx.coroutines.*
import kotlinx.coroutines.tasks.await

const val TAG = "FirebaseFirestore"

class FirebaseFirestore : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase_firestore)

        val tutorialDocument = Firebase.firestore.collection("coroutines")
            .document("tutorial")
        val peter = Person("Peter", 25)
        GlobalScope.launch(Dispatchers.IO) {
            delay(3000L)
            tutorialDocument.set(peter).await()
            val person = tutorialDocument.get().await().toObject(Person::class.java)
            withContext(Dispatchers.Main){
                ff_data.text = person.toString()
            }
        }

    }
}

data class Person(
    val name: String = "",
    val age: Int = -1
)
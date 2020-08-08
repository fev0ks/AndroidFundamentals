package com.mipa.learnandroidfundamentals

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
//        val name = intent.getStringExtra("EXTRA_NAME")
//        val age = intent.getIntExtra("EXTRA_NAME", 0)
//        val country = intent.getStringExtra("EXTRA_COUNTRY")
        val person = intent.getSerializableExtra("EXTRA_PERSON") as Person
        tvPerson.text = "${person.name} is ${person.age} years old and leav in ${person.country}"
    }
}
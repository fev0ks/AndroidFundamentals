package com.mipa.learnandroidfundamentals.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.mipa.learnandroidfundamentals.R
import kotlinx.android.synthetic.main.activity_fragments.*
import kotlinx.android.synthetic.main.fragment_second.*

class Fragments : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragments)

        val firstFragment = FirstFragment()
        val secondFragment = SecondFragment()
        replaceFragment(firstFragment)

        btnFragment1.setOnClickListener {
            replaceFragment(firstFragment)
        }
        btnFragment2.setOnClickListener {
            replaceFragment(secondFragment)
        }
    }

    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flFragment, fragment)
            addToBackStack(null)
            commit()
        }
    }
}
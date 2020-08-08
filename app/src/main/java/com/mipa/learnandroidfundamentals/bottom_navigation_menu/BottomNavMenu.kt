package com.mipa.learnandroidfundamentals.bottom_navigation_menu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.mipa.learnandroidfundamentals.R
import kotlinx.android.synthetic.main.activity_bottom_nav_menu.*

class BottomNavMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bottom_nav_menu)

        val homeFragment = HomeFragment()
        val messageFragment = MessageFragment()
        val profileFragment = ProfileFragment()

        setCurrentFragment(homeFragment)

        bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.miHome -> setCurrentFragment(homeFragment)
                R.id.miProfile -> setCurrentFragment(profileFragment)
                R.id.miMessages -> setCurrentFragment(messageFragment)
                else -> Toast.makeText(this, "What are you doing?", Toast.LENGTH_SHORT).show()
            }
            true
        }

        bottomNavigationView.getOrCreateBadge(R.id.miMessages).apply {
            number = 10
            isVisible = true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.flNmFragment, fragment)
            commit()
        }
}
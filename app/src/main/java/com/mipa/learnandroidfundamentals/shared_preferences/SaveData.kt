package com.mipa.learnandroidfundamentals.shared_preferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mipa.learnandroidfundamentals.R
import kotlinx.android.synthetic.main.activity_save_data.*

class SaveData : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_save_data)

        val sharedPref = getSharedPreferences("mtPref", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()

        sd_save_BTN.setOnClickListener {
            val name = sd_nameET.text.toString()
            val age = sd_ageET.text.toString().toInt()
            val isAdult = sd_adultCB.isChecked

            editor.apply {
                putString("name", name)
                putInt("age", age)
                putBoolean("isAdult", isAdult)
                apply()
            }
        }

        sd_load_BTN.setOnClickListener {
            sd_nameET.setText(sharedPref.getString("name", null))
            sd_ageET.setText(sharedPref.getInt("age", 0).toString())
            sd_adultCB.isChecked = sharedPref.getBoolean("isAdult", false)
        }
    }
}
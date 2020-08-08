package com.mipa.learnandroidfundamentals.services.intent_service

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mipa.learnandroidfundamentals.R
import kotlinx.android.synthetic.main.activity_intent_service.*

class LrnIntentService : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent_service)

        int_startBTN.setOnClickListener {
            Intent(this, MyIntentService::class.java).also {
                startService(it)
                int_serviceInfoTW.text = "Service run"
            }
        }

        int_stopBTN.setOnClickListener {
            MyIntentService.stopService()
            int_serviceInfoTW.text = "Service stopped"
        }
    }
}
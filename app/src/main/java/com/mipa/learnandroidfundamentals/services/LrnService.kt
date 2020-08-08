package com.mipa.learnandroidfundamentals.services

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mipa.learnandroidfundamentals.R
import kotlinx.android.synthetic.main.activity_lrn_service.*

class LrnService : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lrn_service)

        ser_start_btn.setOnClickListener {
            Intent(this, MyService::class.java).also{
                startService(it)
                ser_info.text = "Service run..."
            }
        }

        ser_stop_btn.setOnClickListener {
            Intent(this, MyService::class.java).also{
                stopService(it)
                ser_info.text = "Service stopped..."
            }
        }

        ser_send_data_btn.setOnClickListener {
            Intent(this, MyService::class.java).also{
                val dataString = ser_data.text.toString()
                it.putExtra("EXTRA_DATA", dataString)
                startService(it)
            }
        }


    }
}
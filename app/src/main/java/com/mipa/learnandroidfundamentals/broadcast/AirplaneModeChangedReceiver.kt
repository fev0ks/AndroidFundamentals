package com.mipa.learnandroidfundamentals.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class AirplaneModeChangedReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        val isAirplaneModeEnabled = intent?.getBooleanExtra("state", false) ?: return
        if (isAirplaneModeEnabled) {
            Toast.makeText(context, "Airplane mode enabled", Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(context, "Airplane mode disable", Toast.LENGTH_SHORT).show()
        }
    }
}
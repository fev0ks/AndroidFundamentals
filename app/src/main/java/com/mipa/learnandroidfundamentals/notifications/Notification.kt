package com.mipa.learnandroidfundamentals.notifications

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.TaskStackBuilder
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.mipa.learnandroidfundamentals.R
import kotlinx.android.synthetic.main.activity_notification.*

const val CHANNEL_ID = "channel_id"
const val CHANNEL_NAME = "channel_name"


class Notification : AppCompatActivity() {
    private var count = 1;
    private var notificationId = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)
        createNotificationChannel()

        val intent = Intent(this, Notification::class.java)
        val pendingIntent = TaskStackBuilder.create(this).run {
            addNextIntentWithParentStack(intent)
            getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT)
        }

        val notificationManager = NotificationManagerCompat.from(this)

        notifyBTN.setOnClickListener {
            notificationManager.notify(notificationId++, getNotification(pendingIntent))
        }
    }

    fun getNotification(pendingIntent: PendingIntent) = NotificationCompat.Builder(this, CHANNEL_ID)
        .setContentTitle("My Notification ${count++}")
        .setContentText("Some text")
        .setSmallIcon(R.drawable.ic_home)
        .setPriority(NotificationCompat.PRIORITY_HIGH)
        .setContentIntent(pendingIntent)
        .build()

    fun createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                CHANNEL_ID,
                CHANNEL_NAME,
                NotificationManager.IMPORTANCE_DEFAULT
            ).apply {
                lightColor = Color.GREEN
                enableLights(true)
            }
            val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            manager.createNotificationChannel(channel)
        }
    }
}
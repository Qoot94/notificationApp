package com.example.notificationapp

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btShow = findViewById<Button>(R.id.btNotify)
        val etMsg = findViewById<EditText>(R.id.etMsg)
        btShow.setOnClickListener {
        //track notifications
            val channelId = "myapp.notifications"
            val description = "notification"
            var builder = Notification.Builder(this)
            val notificationManager = getSystemService(NOTIFICATION_SERVICE) as NotificationManager
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                var notificationChannel =
                    NotificationChannel(channelId, description, NotificationManager.IMPORTANCE_HIGH)
                notificationManager.createNotificationChannel(notificationChannel)
                builder = Notification.Builder(this, channelId)
                    .setSmallIcon(R.drawable.ic_baseline_message_24)
                    .setContentTitle("New message!!")
                    .setContentText(etMsg.text.toString())
            } else {
                builder = Notification.Builder(this)
                    .setSmallIcon(R.drawable.ic_baseline_message_24)
                    .setContentTitle("New message!!")
                    .setContentText(etMsg.text.toString())
            }
            notificationManager.notify(362933, builder.build())

        }

    }
}
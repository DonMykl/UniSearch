package com.donmykl.unisearch

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.os.Build
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.donmykl.unisearch.views.MainActivity
import java.util.Timer
import java.util.TimerTask

class UpdateService: Service() {
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
    //logic to update the service
    private val timer = Timer()
    override fun onCreate() {
        super.onCreate()

        timer.scheduleAtFixedRate(object : TimerTask() {
            override fun run() {
            }
        }, 0, 10000)
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val input = intent?.getStringExtra("inputExtra")
        createNotificationChannel()
        val notificationIntent = Intent(this,MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0,notificationIntent,
            PendingIntent.FLAG_IMMUTABLE)
        val notification = NotificationCompat.Builder(this, "update_channel")
            .setSmallIcon(R.drawable.ic_launcher_foreground)
            .setContentTitle("Updating Universities")
            .setContentText(input)
            .setContentIntent(pendingIntent)
            .build()

        startForeground(1,notification)
        return  START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        timer.cancel()
    }

    private fun createNotificationChannel(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(
                "update_channel",
                "Update Notifications",
                NotificationManager.IMPORTANCE_HIGH
            )
            val notificationManager = getSystemService(NotificationManager::class.java)
            notificationManager.createNotificationChannel(channel)
        }
    }
}
package com.kserno.bp.receiver

import android.os.Build
import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import android.speech.tts.TextToSpeech
import android.util.Log

/**
 *  Created by filipsollar on 2019-02-18
 */
class NotificationInterceptor : NotificationListenerService() {

    companion object {
        const val TAG = "NotificationInterceptor"
    }


    lateinit var textToSpeech: TextToSpeech

    override fun onCreate() {
        super.onCreate()
        textToSpeech = TextToSpeech(applicationContext, TextToSpeech.OnInitListener {
            Log.d(TAG, it.toString())
        })
    }

    override fun onNotificationPosted(sbn: StatusBarNotification) {
        super.onNotificationPosted(sbn)
        Log.d(TAG, "onNotificationPosted")
        val title = sbn.notification.extras.getString("android.title")
        val text = sbn.notification.extras.getString("android.text")
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            textToSpeech.speak("$title $text", TextToSpeech.QUEUE_ADD, null, "")
        } else {
            textToSpeech.speak("$title $text", TextToSpeech.QUEUE_ADD, null)
        }
    }


    override fun onNotificationRemoved(sbn: StatusBarNotification?) {
        super.onNotificationRemoved(sbn)
        Log.d(TAG, "onNotificationRemove")
    }

    override fun onListenerConnected() {
        super.onListenerConnected()
        Log.d(TAG, "onListenerConnected")
    }

    override fun onListenerDisconnected() {
        super.onListenerDisconnected()
        Log.d(TAG, "onListenerDisconnect")

    }
}
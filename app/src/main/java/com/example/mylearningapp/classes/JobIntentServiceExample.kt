package com.example.mylearningapp.classes

import android.content.Context
import android.content.Intent
import android.util.Log
import androidx.core.app.JobIntentService

class JobIntentServiceExample : JobIntentService() {

    override fun onHandleWork(intent: Intent) {
        Log.d("Service", "JobIntent Service started")
        Log.d("Service Thread", Thread.currentThread().name)
    }

    /**
     * use of the companion object is to create a means of accessing a function as a static method using
     * the class name*/
    companion object {
        fun myBackgroundService(context: Context, intent: Intent) {
            enqueueWork(context, JobIntentServiceExample::class.java, 1, intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("Service", "JobIntent Service stopped")
    }
}
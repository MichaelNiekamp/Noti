package com.example.notif

import android.app.Application

class NotiApplication: Application() {
    private val database by lazy { NotiDatabase.getDatabase(this) }
    val repository by lazy { NotificationRepository(database.notiDao()) }
}
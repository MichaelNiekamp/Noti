package com.example.notif

import androidx.annotation.WorkerThread

class NotificationRepository(private val notificationDAO: NotificationDAO) {
    val allNotis: List<Notification> = notificationDAO.getAllNotis()
//    val rankedNotis: Flow<List<Notification>> = notificationDAO.getRankedNotis()

    @WorkerThread
    suspend fun insertNotification(notification: Notification){
        notificationDAO.upsertNotification(notification)
    }

    @WorkerThread
    suspend fun deleteNotification(notification: Notification){
        notificationDAO.deleteNotification(notification)
    }
}
package com.example.notif

import androidx.annotation.WorkerThread
import kotlinx.coroutines.flow.Flow

class NotificationRepository(private val notificationDAO: NotificationDAO) {
    val allNotis: Flow<List<Notification>> = notificationDAO.getAllNotis()
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
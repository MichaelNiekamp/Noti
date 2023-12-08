package com.example.notif

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface NotificationDAO {

    @Upsert
    fun upsertNotification(notification: Notification)

    @Delete
    fun deleteNotification(notification: Notification)

    @Query("SELECT * FROM noti_table ORDER BY notiDate DESC")
    fun getAllNotis(): List<Notification>

//    @Query("SELECT * FROM noti_table ORDER BY notiRank")
//    fun getRankedNotis(): Flow<List<Notification>>
}
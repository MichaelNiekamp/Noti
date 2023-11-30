package com.example.notif

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity(tableName = "noti_table")
data class Notification(
    @ColumnInfo
    val notiTitle: String,
    @ColumnInfo
    val notiDesc: String,
    @ColumnInfo
    val notiDate: String,
    @ColumnInfo
    val notiTime: String,
    @ColumnInfo
    val notiRank: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null
)

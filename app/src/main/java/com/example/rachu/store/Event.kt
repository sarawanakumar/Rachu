package com.example.rachu.store

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "event")
data class Event(
    @ColumnInfo(name = "event_id") @PrimaryKey(autoGenerate = true) var id: Long = 0,
    @ColumnInfo(name = "event_name") var eventName: String,
    @ColumnInfo(name = "event_date") var eventDate: String,
    @ColumnInfo(name = "event_desc") var eventDescription: String,
    @ColumnInfo(name = "media") var media: String
)
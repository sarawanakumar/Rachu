package com.example.rachu.store

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface EventDao {

    @Query("SELECT * FROM event")
    fun getAll(): List<Event>

    @Insert
    fun insertAll(vararg event: Event)
}
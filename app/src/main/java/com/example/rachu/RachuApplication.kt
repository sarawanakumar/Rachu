package com.example.rachu

import android.app.Application
import androidx.room.Room

class RachuApplication: Application() {

    companion object{
        var database: AppDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(this, AppDatabase::class.java, "rachu-master-db").build()
    }
}
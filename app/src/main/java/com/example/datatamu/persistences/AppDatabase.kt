package com.example.datatamu.persistences

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.datatamu.model.InputDataTamuHotel

@Database(entities = [InputDataTamuHotel::class], version = 1)
abstract class AppDatabase : RoomDatabase(){
    abstract fun inputDataTamuHotelDao(): InputDataTamuHotelDao
}
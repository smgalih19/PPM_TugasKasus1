package com.example.datatamu.persistences

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.datatamu.model.InputDataTamuHotel

@Dao
interface InputDataTamuHotelDao {
    @Query("SELECT * FROM InputDataTamuHotel")
    fun loadAll(): LiveData<List<InputDataTamuHotel>>

    @Query("SELECT * FROM InputDataTamuHotel WHERE id = :id")
    fun find(id: String): InputDataTamuHotel?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(vararg items: InputDataTamuHotel)

    @Delete
    fun delete(item: InputDataTamuHotel)
}
package com.example.datatamu.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class InputDataTamuHotel(
    @PrimaryKey val id: String,
    val nama: String,
    val tipe_kamar: String,
    val tgl_masuk: String,
    val tgl_keluar: String,
    val no_telepon: String,
)

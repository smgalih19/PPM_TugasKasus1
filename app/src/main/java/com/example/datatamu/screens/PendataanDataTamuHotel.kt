package com.example.datatamu.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.room.Room
import com.example.datatamu.model.InputDataTamuHotel
import com.example.datatamu.persistences.AppDatabase
import com.example.datatamu.persistences.InputDataTamuHotelDao
import kotlinx.coroutines.flow.MutableStateFlow

@Composable
fun PendataanDataTamuHotel() {

    // Inisiasi kelas db lalu ambil dao, mengubah list jadi livedata
    val context = LocalContext.current

    val db = Room.databaseBuilder(
        context,
        AppDatabase::class.java, "pendataan-datatamu-hotel"
    ).build()

    val inputDataTamuHotelDao = db.inputDataTamuHotelDao()

    val list : LiveData<List<InputDataTamuHotel>> = inputDataTamuHotelDao.loadAll()
    val items : List<InputDataTamuHotel> by list.observeAsState(initial = listOf())

    Column(modifier = Modifier.fillMaxWidth()) {
//        FormDataTamuHotel { item ->
//            val newList = ArrayList(list)
//            newList.add(item)
//            list.value = newList }

        LazyColumn(modifier = Modifier.fillMaxWidth() ) {
            items(items = items, itemContent = { item ->
                Row(
                    modifier = Modifier
                        .padding(15.dp)
                        .fillMaxWidth()
                ) {
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Nama", fontSize = 14.sp)
                        Text(
                            text = item.nama, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Tipe Kamar", fontSize = 14.sp)
                        Text(
                            text = item.tipe_kamar, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Tanggal Masuk", fontSize = 14.sp)
                        Text(
                            text = item.tgl_masuk, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "Tanggal Keluar", fontSize = 14.sp)
                        Text(
                            text = item.tgl_keluar, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                    Column(modifier = Modifier.weight(3f)) {
                        Text(text = "No Telepon", fontSize = 14.sp)
                        Text(
                            text = item.no_telepon, fontSize = 16.sp,
                            fontWeight = FontWeight.Bold
                        )
                    }
                }
                Divider(modifier = Modifier.fillMaxWidth())
            })
        }
    }
}
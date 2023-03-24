package com.example.datatamu.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.benasher44.uuid.uuid4
import com.example.datatamu.model.InputDataTamuHotel
import com.example.datatamu.persistences.InputDataTamuHotelDao
import com.example.datatamu.ui.theme.Purple700
import com.example.datatamu.ui.theme.Teal200
import kotlinx.coroutines.launch

@Composable
fun FormDataTamuHotel(inputDataTamuHotelDao: InputDataTamuHotelDao) {
    val nama = remember { mutableStateOf(TextFieldValue("")) }
    val tipe_kamar = remember { mutableStateOf(TextFieldValue("")) }
    val tgl_masuk = remember { mutableStateOf(TextFieldValue("")) }
    val tgl_keluar = remember { mutableStateOf(TextFieldValue("")) }
    val no_telepon = remember { mutableStateOf(TextFieldValue("")) }

    val scope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
    ) {

        OutlinedTextField(
            label = { Text(text = "nama") },
            value = nama.value,
            onValueChange = {
                nama.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "Masukan Nama Anda") }
        )

        OutlinedTextField(
            label = { Text(text = "tipe_kamar") },
            value = tipe_kamar.value,
            onValueChange = {
                tipe_kamar.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "Tipe Kamar") }
        )

        OutlinedTextField(
            label = { Text(text = "tgl_masuk") },
            value = tgl_masuk.value,
            onValueChange = {
                tgl_masuk.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "yyyy-mm-dd") }
        )

        OutlinedTextField(
            label = { Text(text = "tgl_keluar") },
            value = tgl_keluar.value,
            onValueChange = {
                tgl_keluar.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            placeholder = { Text(text = "yyyy-mm-dd") }
        )

        OutlinedTextField(
            label = { Text(text = "no_telepon") },
            value = no_telepon.value,
            onValueChange = {
                no_telepon.value = it
            },
            modifier = Modifier
                .padding(4.dp)
                .fillMaxWidth(),
            keyboardOptions = KeyboardOptions(
                keyboardType =
                KeyboardType.Decimal
            ),
            placeholder = { Text(text = "12") }
        )

        val loginButtonColor = ButtonDefaults.buttonColors(
            backgroundColor = Purple700,
            contentColor = Teal200
        )

        val resetButtonColors = ButtonDefaults.buttonColors(
            backgroundColor = Teal200,
            contentColor = Purple700
        )

        Row(modifier = Modifier
            .padding(4.dp)
            .fillMaxWidth()) {
            Button(modifier = Modifier.weight(5f), onClick = {
                val id = uuid4().toString()
                val item = InputDataTamuHotel(
                    id, nama.value.text, tipe_kamar.value.text,
                    tgl_masuk.value.text, tgl_keluar.value.text, no_telepon.value.text)

                scope.launch{
                    inputDataTamuHotelDao.insertAll(item)
                }

                nama.value = TextFieldValue("")
                tipe_kamar.value = TextFieldValue("")
                tgl_masuk.value = TextFieldValue("")
                tgl_keluar.value = TextFieldValue("")
                no_telepon.value = TextFieldValue("")
            }, colors = loginButtonColor) {
                Text(
                    text = "Simpan",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }

            Button(modifier = Modifier.weight(5f), onClick = {
                nama.value = TextFieldValue("")
                tipe_kamar.value = TextFieldValue("")
                tgl_masuk.value = TextFieldValue("")
                tgl_keluar.value = TextFieldValue("")
                no_telepon.value = TextFieldValue("")
            }, colors = resetButtonColors) {
                Text(
                    text = "Reset",
                    style = TextStyle(
                        color = Color.White,
                        fontSize = 18.sp
                    ), modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}
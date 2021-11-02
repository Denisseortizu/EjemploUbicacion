package com.example.ejemploubicacion

import android.location.Address
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import android.location.Geocoder
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import java.util.*


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCiu = findViewById<Button>(R.id.btnLL)
        val editCiudad  =  findViewById<EditText>(R.id.etCiudad)
        val logText = findViewById<TextView>(R.id.txtLong)
        val latText = findViewById<TextView>(R.id.txtLati)
        val ciuText = findViewById<TextView>(R.id.txtCiudad)

        btnCiu.setOnClickListener(){
            val ciudad = editCiudad.text
            Toast.makeText(this@MainActivity, "La ciudad es $ciudad", Toast.LENGTH_SHORT).show()
            val geocoder = Geocoder(this, Locale.getDefault())
            val addresses = (geocoder.getFromLocationName("$ciudad", 1)).get(0)
            val longitud = addresses.longitude
            val latitude = addresses.latitude

            ciuText.text = "$ciudad"

            logText.text = "$longitud"

            latText.text = "$latitude"

        }

    }
}
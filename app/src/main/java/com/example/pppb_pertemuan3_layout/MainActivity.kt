package com.example.pppb_pertemuan3_layout

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnSettings: Button = findViewById(R.id.btnSettings)
        val btnShare: Button = findViewById(R.id.btnShare)

        btnSettings.setOnClickListener {
            Toast.makeText(this, "Open Settings...", Toast.LENGTH_SHORT).show()
        }

        btnShare.setOnClickListener {
            Toast.makeText(this, "Shared Profile...", Toast.LENGTH_SHORT).show()
        }
    }
}
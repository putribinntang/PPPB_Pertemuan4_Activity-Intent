package com.example.pppb_pertemuan3_layout

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ProfilePhotoActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_USERNAME = "extra_username"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_photo)

        val tvUsernamePhoto: TextView = findViewById(R.id.tvUsernamePhoto)
        val btnBack: Button = findViewById(R.id.btnBackToProfile)

        val username = intent.getStringExtra(EXTRA_USERNAME)
        tvUsernamePhoto.text = username

        btnBack.setOnClickListener {
            finish()
        }
    }
}
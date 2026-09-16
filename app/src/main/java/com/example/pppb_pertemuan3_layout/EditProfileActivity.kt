package com.example.pppb_pertemuan3_layout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class EditProfileActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_NAME = "extra_name"
        const val EXTRA_BIO = "extra_bio"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        val edtName: EditText = findViewById(R.id.edtName)
        val edtBio: EditText = findViewById(R.id.edtBio)
        val btnSubmit: Button = findViewById(R.id.btnSubmit)

        // Ambil nama & bio yang dikirim dari MainActivity, lalu tampilkan di EditText
        val currentName = intent.getStringExtra(EXTRA_NAME)
        val currentBio = intent.getStringExtra(EXTRA_BIO)
        edtName.setText(currentName)
        edtBio.setText(currentBio)

        btnSubmit.setOnClickListener {
            // Siapkan Intent buat kirim balik data ke MainActivity
            val resultIntent = Intent()
            resultIntent.putExtra(EXTRA_NAME, edtName.text.toString())
            resultIntent.putExtra(EXTRA_BIO, edtBio.text.toString())
            setResult(Activity.RESULT_OK, resultIntent)
            finish() // menutup halaman ini, balik ke MainActivity
        }
    }
}
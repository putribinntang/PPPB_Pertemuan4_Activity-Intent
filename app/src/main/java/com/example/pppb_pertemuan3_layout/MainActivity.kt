package com.example.pppb_pertemuan3_layout

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var tvUsername: TextView
    private lateinit var tvBio: TextView

    private val editProfileLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                val data = result.data
                val newName = data?.getStringExtra(EditProfileActivity.EXTRA_NAME)
                val newBio = data?.getStringExtra(EditProfileActivity.EXTRA_BIO)

                if (!newName.isNullOrEmpty()) {
                    tvUsername.text = newName
                }
                if (!newBio.isNullOrEmpty()) {
                    tvBio.text = newBio
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        tvUsername = findViewById(R.id.tvUsername)
        tvBio = findViewById(R.id.tvBio)
        val btnEditProfile: Button = findViewById(R.id.btnEditProfile)
        val btnShare: Button = findViewById(R.id.btnShare)
        val cardProfilePhoto: CardView = findViewById(R.id.cardProfilePhoto)

        btnEditProfile.setOnClickListener {
            val intent = Intent(this@MainActivity, EditProfileActivity::class.java)
            intent.putExtra(EditProfileActivity.EXTRA_NAME, tvUsername.text.toString())
            intent.putExtra(EditProfileActivity.EXTRA_BIO, tvBio.text.toString())
            editProfileLauncher.launch(intent)
        }

        btnShare.setOnClickListener {
            Toast.makeText(this, "Shared Profile...", Toast.LENGTH_SHORT).show()
        }

        cardProfilePhoto.setOnClickListener {
            val intent = Intent(this@MainActivity, ProfilePhotoActivity::class.java)
            intent.putExtra(ProfilePhotoActivity.EXTRA_USERNAME, tvUsername.text.toString())
            startActivity(intent)
        }
    }
}
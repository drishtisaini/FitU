package com.igdtuw.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.TextView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import de.hdodenhof.circleimageview.CircleImageView

class ProfileActivity : AppCompatActivity() {

    private lateinit var profileImage: CircleImageView
    private lateinit var editIcon: ImageView
    private val PICK_IMAGE_REQUEST = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        profileImage = findViewById(R.id.profileImage)
        editIcon = findViewById(R.id.editIcon)

        val startFitnessButton = findViewById<TextView>(R.id.btnfitness)
        val consultButton = findViewById<TextView>(R.id.btnconsult)
        val gameButton = findViewById<TextView>(R.id.btngame)
        val streaksButton = findViewById<TextView>(R.id.btnstreaks)

        val lottieBackground = findViewById<LottieAnimationView>(R.id.lottieBackground)

        editIcon.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        startFitnessButton.setOnClickListener {
            Toast.makeText(this, "Opening Fitness Page...", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, FitnessActivity::class.java))
        }

        consultButton.setOnClickListener {
            Toast.makeText(this, "Opening Consult...", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, ConsultActivity::class.java))
        }

        gameButton.setOnClickListener {
            Toast.makeText(this, "Opening Game...", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, GameActivity::class.java))
        }

        streaksButton.setOnClickListener {
            Toast.makeText(this, "Opening Streaks...", Toast.LENGTH_SHORT).show()
            // startActivity(Intent(this, StreaksActivity::class.java))
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK && data != null && data.data != null) {
            val imageUri: Uri? = data.data
            profileImage.setImageURI(imageUri)
        }
    }
}

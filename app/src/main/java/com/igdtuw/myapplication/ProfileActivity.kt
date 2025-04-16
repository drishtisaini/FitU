package com.igdtuw.myapplication

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.airbnb.lottie.LottieAnimationView
import com.google.android.material.navigation.NavigationView
import de.hdodenhof.circleimageview.CircleImageView
import com.igdtuw.myapplication.MyAccountActivity




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

        // ✅ New: Sidebar Components
        val drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val menuIcon = findViewById<ImageView>(R.id.menuIcon)
        val navigationView = findViewById<NavigationView>(R.id.navigation_view)

        menuIcon.setOnClickListener {
            drawerLayout.openDrawer(GravityCompat.START)
        }

        navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_my_account -> {
                    val intent = Intent(this, MyAccountActivity::class.java)
                    startActivity(intent)
                }

                R.id.nav_edit_profile -> {
                    Toast.makeText(this, "Edit Profile", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_health_data -> {
                    Toast.makeText(this, "My Health Data ", Toast.LENGTH_SHORT).show()
                }
                R.id.nav_logout -> {
                    Toast.makeText(this, "Logout", Toast.LENGTH_SHORT).show()
                }

            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true

        }


        editIcon.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
            startActivityForResult(intent, PICK_IMAGE_REQUEST)
        }

        // 🔘 Button Click Actions
        startFitnessButton.setOnClickListener {
            Toast.makeText(this, "Opening Fitness Page...", Toast.LENGTH_SHORT).show()
        }

        consultButton.setOnClickListener {
            Toast.makeText(this, "Opening Consult...", Toast.LENGTH_SHORT).show()
        }

        gameButton.setOnClickListener {
            Toast.makeText(this, "Opening Game...", Toast.LENGTH_SHORT).show()
        }

        streaksButton.setOnClickListener {
            Toast.makeText(this, "Opening Streaks...", Toast.LENGTH_SHORT).show()
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



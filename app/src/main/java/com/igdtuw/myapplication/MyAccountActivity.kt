package com.igdtuw.myapplication

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import de.hdodenhof.circleimageview.CircleImageView

class MyAccountActivity : AppCompatActivity() {

    private lateinit var profileImage: CircleImageView
    private lateinit var editUsername: EditText
    private lateinit var editName: EditText
    private lateinit var editMobile: EditText
    private lateinit var editEmail: EditText
    private lateinit var editPassword: EditText
    private lateinit var editWeight: EditText
    private lateinit var editHeight: EditText
    private lateinit var editAge: EditText
    private lateinit var editGender: EditText
    private lateinit var btnSave: Button
    private lateinit var editIcon: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_account)

        // Initialize views
        profileImage = findViewById(R.id.profileImage)
        editUsername = findViewById(R.id.editUsername)
        editName = findViewById(R.id.editName)
        editMobile = findViewById(R.id.editMobile)
        editEmail = findViewById(R.id.editEmail)
        editPassword = findViewById(R.id.editPassword)
        editWeight = findViewById(R.id.editWeight)
        editHeight = findViewById(R.id.editHeight)
        editAge = findViewById(R.id.editAge)
        editGender = findViewById(R.id.editGender)
        btnSave = findViewById(R.id.btnSave)
        editIcon = findViewById(R.id.editIcon)

        // Set default values
        editUsername.setText("JohnDoe")
        editName.setText("John Doe")
        editEmail.setText("john@example.com")
        editPassword.setText("password123")
        editWeight.setText("70")
        editHeight.setText("175")
        editAge.setText("25")
        editGender.setText("Male")

        // Disable fields initially
        disableFields()

        // Hide Save button initially
        btnSave.visibility = android.view.View.GONE

        // Handle Edit Icon click to enable fields
        editIcon.setOnClickListener {
            enableFields()
            // Show Save button when user starts editing
            btnSave.visibility = android.view.View.VISIBLE
        }

        // Handle Save Changes Button click
        btnSave.setOnClickListener {
            // Save changes (could be to SharedPreferences or a Database)
            Toast.makeText(this, "Details Saved ✅", Toast.LENGTH_SHORT).show()

            // Disable fields after saving
            disableFields()

            // Hide Save button after saving
            btnSave.visibility = android.view.View.GONE
        }
    }

    // Function to disable fields
    private fun disableFields() {
        editUsername.isEnabled = false
        editName.isEnabled = false
        editMobile.isEnabled = false
        editEmail.isEnabled = false
        editPassword.isEnabled = false
        editWeight.isEnabled = false
        editHeight.isEnabled = false
        editAge.isEnabled = false
        editGender.isEnabled = false
    }

    // Function to enable fields
    private fun enableFields() {
        editUsername.isEnabled = true
        editName.isEnabled = true
        editMobile.isEnabled = true
        editEmail.isEnabled = true
        editPassword.isEnabled = true
        editWeight.isEnabled = true
        editHeight.isEnabled = true
        editAge.isEnabled = true
        editGender.isEnabled = true
    }
}

package com.igdtuw.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val emailInput = findViewById<EditText>(R.id.emailLogin)
        val passwordInput = findViewById<EditText>(R.id.passwordLogin)
        val loginButton = findViewById<Button>(R.id.loginButton)

        // Get stored user data
        val sharedPref = getSharedPreferences("FitU", MODE_PRIVATE)
        val savedEmail = sharedPref.getString("user_email", null)
        val savedPassword = sharedPref.getString("user_password", null)

        loginButton.setOnClickListener {
            val email = emailInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            // Validate Email
            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                Toast.makeText(this, "❌ Please enter a valid email", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Validate Password Format
            if (!isValidPassword(password)) {
                Toast.makeText(
                    this,
                    "❌ Password must have:\n• Min 7 characters\n• 1 capital letter\n• 1 number",
                    Toast.LENGTH_LONG
                ).show()
                return@setOnClickListener
            }

            // Check if user exists
            if (email == savedEmail && password == savedPassword) {
                Toast.makeText(this, "✅ Login successful!", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, ProfileActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "❌ Invalid credentials or not signed up!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isValidPassword(password: String): Boolean {
        val hasUppercase = password.any { it.isUpperCase() }
        val hasDigit = password.any { it.isDigit() }
        return password.length >= 7 && hasUppercase && hasDigit
    }
}

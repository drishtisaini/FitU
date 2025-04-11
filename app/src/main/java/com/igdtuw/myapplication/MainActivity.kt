package com.igdtuw.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvLogin = findViewById<TextView>(R.id.tvLogin)
        val signUpButton = findViewById<Button>(R.id.signUpButton)
        val emailEditText = findViewById<EditText>(R.id.emailEditText)
        val passwordEditText = findViewById<EditText>(R.id.passwordEditText)

        tvLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

        signUpButton.setOnClickListener {
            val email = emailEditText.text.toString().trim()
            val password = passwordEditText.text.toString().trim()

            when {
                !Patterns.EMAIL_ADDRESS.matcher(email).matches() -> {
                    Toast.makeText(this, "❌ Invalid Email ", Toast.LENGTH_SHORT).show()
                }
                !isValidPassword(password) -> {
                    Toast.makeText(
                        this,
                        "❌ Password must be at least 7 characters,\ncontain 1 capital letter & 1 number",
                        Toast.LENGTH_LONG
                    ).show()
                }
                else -> {
                    // ✅ Save credentials in SharedPreferences
                    val sharedPref = getSharedPreferences("FitU", MODE_PRIVATE)
                    val editor = sharedPref.edit()
                    editor.putString("user_email", email)
                    editor.putString("user_password", password)
                    editor.apply()

                    Toast.makeText(this, "✅ Sign Up Successful!", Toast.LENGTH_SHORT).show()

                    // Go to Profile Page
                    val intent = Intent(this, ProfileActivity::class.java)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

    private fun isValidPassword(password: String): Boolean {
        val hasUppercase = password.any { it.isUpperCase() }
        val hasDigit = password.any { it.isDigit() }
        return password.length >= 7 && hasUppercase && hasDigit
    }
}

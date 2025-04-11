package com.igdtuw.myapplication

import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class StreaksActivity : AppCompatActivity() {

    data class Streak(val friendName: String, val days: Int)

    private val streakData = listOf(
        Streak("Ananya 💛", 21),
        Streak("Aryan 🔥", 15),
        Streak("Drishti 💬", 7),
        Streak("Rohan 🎮", 30),
        Streak("Tanya ✨", 9)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_streaks)

        val streaksLayout = findViewById<LinearLayout>(R.id.streaksList)

        for (streak in streakData) {
            val textView = TextView(this)
            textView.text = "${streak.friendName}  —  🔥 ${streak.days} days"
            textView.setTextColor(resources.getColor(android.R.color.white))
            textView.textSize = 18f
            textView.setPadding(16, 24, 16, 24)
            textView.setBackgroundResource(android.R.drawable.dialog_holo_light_frame)

            val params = LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
            )
            params.setMargins(0, 10, 0, 10)
            textView.layoutParams = params

            streaksLayout.addView(textView)
        }
    }
}

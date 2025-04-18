
package com.igdtuw.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AlertDialog



class FitnessActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fitness_activity)

        val meditation = findViewById<Button>(R.id.btnMeditation)
        val yoga = findViewById<Button>(R.id.btnYoga)
        val weightLoss = findViewById<Button>(R.id.btnWeightLoss)
        val weightGain = findViewById<Button>(R.id.btnWeightGain)
        val manageShape = findViewById<Button>(R.id.btnManageShape)


        meditation.setOnClickListener { showDifficultyDialog("Meditation") }
        yoga.setOnClickListener { showDifficultyDialog("Yoga") }
        weightLoss.setOnClickListener { showDifficultyDialog("Weight Loss") }
        weightGain.setOnClickListener { showDifficultyDialog("Weight Gain") }
        manageShape.setOnClickListener { showDifficultyDialog("Manage Shape") }

    }

    private fun toast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
    private fun showDifficultyDialog(title: String) {
        val options = arrayOf("Easy", "Medium", "Hard")

        val builder = AlertDialog.Builder(this)
        builder.setTitle("$title - Choose Difficulty")
        builder.setItems(options) { dialog, which ->
            val selected = options[which]
            Toast.makeText(this, "$title - $selected selected", Toast.LENGTH_SHORT).show()
        }

        val dialog = builder.create()
        dialog.show()
    }
}

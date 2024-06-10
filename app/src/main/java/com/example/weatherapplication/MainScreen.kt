package com.example.weatherapplication

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainScreen : AppCompatActivity() {


    private val weeklyTemperatures = arrayOf(12, 25, 15, 29, 10, 18, 10, 16)

    @SuppressLint("SetTextI18n", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val averageTemperature = weeklyTemperatures.average()


        val avgTempTextView: TextView = findViewById(R.id.avg_temp_text_view)
        avgTempTextView.text = "Average Temperature: $averageTemperature°C"


        val detailButton: Button = findViewById(R.id.detail_button)
        detailButton.setOnClickListener {
            val intent = Intent(this,DetailActivity::class.java)
            intent.putExtra("weeklyTemperatures", weeklyTemperatures)
            startActivity(intent)
        }


        val exitButton: Button = findViewById(R.id.exit_button)
        exitButton.setOnClickListener {
            finishAffinity()
        }
    }

    class DetailActivity{

    }
}

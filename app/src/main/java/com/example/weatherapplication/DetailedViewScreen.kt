package com.example.weatherapplication


import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {


    private val daysOfWeek = arrayOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
    private val temperatures = intArrayOf(12, 25, 15, 29, 10, 18, 10, 16)

    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val averageTemperature = temperatures.average()


        val avgTempTextView: TextView = findViewById(R.id.avg_temp_text_view)
        avgTempTextView.text = "Average Temperature: $averageTemperature°C"


        val detailButton: Button = findViewById(R.id.detail_button)
        detailButton.setOnClickListener {
            val intent = Intent(this, MainScreen.DetailActivity::class.java)
            intent.putExtra("daysOfWeek", daysOfWeek)
            intent.putExtra("temperatures", temperatures)
            startActivity(intent)
        }

        //
        val exitButton: Button = findViewById(R.id.exit_button)
        exitButton.setOnClickListener {
            finishAffinity()
        }
    }
}

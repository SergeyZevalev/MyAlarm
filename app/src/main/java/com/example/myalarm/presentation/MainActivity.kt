package com.example.myalarm.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import com.example.myalarm.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val alarmAddButton = findViewById<ImageButton>(R.id.addAlarmButton)
//        alarmAddButton.setOnClickListener {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, AddItemFragment())
            .commit()
//        }
    }
}
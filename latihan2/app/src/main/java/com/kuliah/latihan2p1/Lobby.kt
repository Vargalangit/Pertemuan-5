package com.kuliah.latihan2p1

import android.os.Bundle
import android.widget.ProgressBar // ← Tambahkan ini
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.progressindicator.CircularProgressIndicator

class Lobby : AppCompatActivity() {

    private lateinit var circularProgress: CircularProgressIndicator
    private lateinit var candleProgress: ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_lobby)

        // Circular Progress Bar
        circularProgress = findViewById(R.id.circularProgress)
        circularProgress.setProgressCompat(100, true)

        val bottomNav = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> { /* Aksi Home */ true }
                R.id.nav_dashboard -> { /* Aksi Dashboard */ true }
                R.id.nav_profile -> { /* Aksi Profile */ true }
                else -> false
            }
        }

        // Handle padding dengan WindowInsets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}

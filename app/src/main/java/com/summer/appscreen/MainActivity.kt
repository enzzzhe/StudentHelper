package com.summer.appscreen

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.ProgressDialog.show
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controller = (supportFragmentManager.findFragmentById(R.id.container) as NavHostFragment).navController

        val bottomView = findViewById<BottomNavigationView>(R.id.bottom_view)
        bottomView.setupWithNavController(controller)
    }
}
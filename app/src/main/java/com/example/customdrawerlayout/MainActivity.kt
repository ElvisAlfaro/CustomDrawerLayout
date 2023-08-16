package com.example.customdrawerlayout

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customdrawerlayout.databinding.ActivityMainBinding
import com.example.customdrawerlayout.with_menu_xml.WithMenuXmlActivity
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initListener()
    }

    private fun initListener() {
        binding.apply {
            btnDrawer1.setOnClickListener {
                startActivity(
                    Intent(this@MainActivity, WithMenuXmlActivity::class.java)
                )
            }
            btnDrawer2.setOnClickListener {
                Snackbar.make(binding.root, "Proximamente", Snackbar.LENGTH_SHORT).show()
            }
        }
    }
}
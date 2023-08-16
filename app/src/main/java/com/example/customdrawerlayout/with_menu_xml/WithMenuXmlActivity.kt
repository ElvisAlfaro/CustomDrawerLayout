package com.example.customdrawerlayout.with_menu_xml

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customdrawerlayout.R
import com.example.customdrawerlayout.databinding.ActivityWithMenuXmlBinding

class WithMenuXmlActivity : AppCompatActivity() {
    private val binding: ActivityWithMenuXmlBinding by lazy {
        ActivityWithMenuXmlBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
}
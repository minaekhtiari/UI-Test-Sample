package com.example.ui_test_sample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ui_test_sample.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {

    private lateinit var binging: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binging.root)

        binging.buttonBack.setOnClickListener {
            onBackPressed()
        }



    }
}
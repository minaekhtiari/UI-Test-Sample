package com.example.ui_test_sample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.afollestad.materialdialogs.MaterialDialog
import com.afollestad.materialdialogs.input.input
import com.example.ui_test_sample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonNext.setOnClickListener {
            showDialog()
        }


    }

    private fun showDialog() {
        MaterialDialog(this)
            .show {
                input (
                    waitForPositiveButton = true,  //we can't dismiss this
                    allowEmpty = false
                ){ dialog, text ->
                    binding.activityMainTitle.text=text
                    dialog.icon(R.drawable.ic_launcher_background)

                }
              title(R.string.text_enter_text)
                positiveButton(R.string.text_ok)
            }
    }



}
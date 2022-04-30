package com.example.ui_test_sample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import androidx.activity.result.contract.ActivityResultContracts
import com.bumptech.glide.Glide
import com.example.ui_test_sample.databinding.ActivityPickImageBinding

const val IMAGE_REQUEST_CODE = 1366

class PickImageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPickImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPickImageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOpenGallery.setOnClickListener {
            pickImageFromGallery()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            when (requestCode) {
                IMAGE_REQUEST_CODE -> {
                    data?.data?.let { uri ->
                        Glide.with(this)
                            .load(uri)
                            .into(binding.image)
                    }
                }
            }
        }
    }

    private fun pickImageFromGallery() {
        var intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

        startActivityForResult(intent, IMAGE_REQUEST_CODE)
    }
}
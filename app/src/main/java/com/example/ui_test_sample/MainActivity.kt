package com.example.ui_test_sample

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.bumptech.glide.Glide
import com.example.ui_test_sample.databinding.ActivityMainBinding

const val GALLERY_REQUEST_CODE=1366
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.buttonOpenGallery.setOnClickListener {
            val intent=Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)

            startActivityForResult(intent, GALLERY_REQUEST_CODE)

        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
               when(requestCode){
                GALLERY_REQUEST_CODE -> {
                     data?.data?.let { uri ->
                        Glide.with(this)
                            .load(uri)
                            .into(binding.image)
                    }
                }
            }
        }
    }




}
package com.example.ui_test_sample

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.example.ui_test_sample.databinding.ActivitySecondBinding

const val KEY_IMAGE_DATA = "data"
class SecondActivity : AppCompatActivity() {

    private lateinit var binging: ActivitySecondBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binging= ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binging.root)

        binging.buttonLaunchCamera.setOnClickListener {
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, 1234);
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode == Activity.RESULT_OK){
            when(requestCode){
                1234 -> {
                    data?.extras.let{ extras ->
                        if (extras == null || !extras.containsKey(KEY_IMAGE_DATA)) {
                            return
                        }
                        val imageBitmap = extras[KEY_IMAGE_DATA] as Bitmap?
                        binging.capturedImage
                            .setImageBitmap(imageBitmap)
                    }
                }
            }
        }
    }

}
package com.example.ui_test_sample.fragmentExample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.ui_test_sample.R
import com.example.ui_test_sample.databinding.ActivityHostBinding
import com.example.ui_test_sample.fragmentExample.fragments.CountryDetailFragment

class HostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHostBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityHostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        if(supportFragmentManager.fragments.size == 0){
            val countryId = 0
            val bundle = Bundle()
            bundle.putInt("country_id", countryId)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CountryDetailFragment::class.java, bundle)
                .commit()
        }
    }
}
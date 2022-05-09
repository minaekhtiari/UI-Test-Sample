package com.example.ui_test_sample.fragmentExample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.request.RequestOptions
import com.example.ui_test_sample.R
import com.example.ui_test_sample.databinding.ActivityHostBinding
import com.example.ui_test_sample.fragmentExample.data.CountryDatasource
import com.example.ui_test_sample.fragmentExample.data.CountryRemoteDataSource
import com.example.ui_test_sample.fragmentExample.fragments.CountryDetailFragment
import com.example.ui_test_sample.fragmentExample.fragments.CountryFragmentFactory

class HostActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHostBinding

    private lateinit var requestOptions: RequestOptions
    private lateinit var countryDatasource: CountryDatasource
    override fun onCreate(savedInstanceState: Bundle?) {
        requestOptions = RequestOptions
            .placeholderOf(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
        countryDatasource = CountryRemoteDataSource()
        supportFragmentManager.fragmentFactory = CountryFragmentFactory(
            requestOptions,
            countryDatasource
        )
        super.onCreate(savedInstanceState)
        binding = ActivityHostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init() {
        if (supportFragmentManager.fragments.size == 0) {
            val countryId = 0
            val bundle = Bundle()
            bundle.putInt("country_id", countryId)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CountryDetailFragment::class.java, bundle)
                .commit()
        }
    }
}
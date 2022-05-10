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
import com.example.ui_test_sample.fragmentExample.fragments.CountryListFragment

class HostActivity : AppCompatActivity() {

    lateinit var requestOptions: RequestOptions
    lateinit var countryDatasource: CountryDatasource

    private lateinit var binding: ActivityHostBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        initDependencies()
        supportFragmentManager.fragmentFactory = CountryFragmentFactory(
            requestOptions,
            countryDatasource
        )
        super.onCreate(savedInstanceState)
        binding= ActivityHostBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }

    private fun init(){
        if(supportFragmentManager.fragments.size == 0){
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, CountryListFragment::class.java, null)
                .commit()
        }
    }

    private fun initDependencies(){
        if(!::requestOptions.isInitialized){
            // glide
            requestOptions = RequestOptions
                .placeholderOf(R.drawable.ic_launcher_background)
                .error(R.drawable.ic_launcher_background)
        }
        if(!::countryDatasource.isInitialized){
            // Data Source
            countryDatasource = CountryRemoteDataSource()
        }

    }
}
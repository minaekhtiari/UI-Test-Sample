package com.example.ui_test_sample.fragmentExample.fragments


import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.request.RequestOptions
import com.example.ui_test_sample.fragmentExample.data.CountryDatasource

class CountryFragmentFactory(
    private val requestOptions: RequestOptions? = null,
    private val countryDataSource: CountryDatasource? = null
) : FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String) =
        when (className) {
            CountryListFragment::class.java.name -> {
                if (countryDataSource != null) {
                    CountryListFragment(countryDataSource)
                } else {
                    super.instantiate(classLoader, className)
                }
            }

            CountryDetailFragment::class.java.name -> {
                CountryDetailFragment()
            }

            BigCitiesFragment::class.java.name -> {
                BigCitiesFragment()
            }

            SmallCitiesFragment::class.java.name -> {
                SmallCitiesFragment()
            }

            else -> {
                super.instantiate(classLoader, className)
            }
        }
}
package com.example.ui_test_sample.fragmentExample.fragments


import androidx.fragment.app.FragmentFactory
import com.bumptech.glide.request.RequestOptions
import com.example.ui_test_sample.fragmentExample.data.CountryDatasource

class CountryFragmentFactory (
    private val requestOptions: RequestOptions? = null,
    private val countryDatasource: CountryDatasource? = null
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String) =
        when (className) {

            CountryDetailFragment::class.java.name -> {
                if (requestOptions != null
                    && countryDatasource != null
                ) {
                    CountryDetailFragment(
                        requestOptions,
                        countryDatasource
                    )
                } else {
                    super.instantiate(classLoader, className)
                }
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
package com.example.ui_test_sample.fragmetExample.fragments


import androidx.fragment.app.FragmentFactory

class CountryFragmentFactory: FragmentFactory() {
    override fun instantiate(classLoader: ClassLoader, className: String)=
        when(className){

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
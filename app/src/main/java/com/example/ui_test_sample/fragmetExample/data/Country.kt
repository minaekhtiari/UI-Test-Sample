package com.example.ui_test_sample.fragmetExample.data

data class Country(

        val id: Int,
        val name: String,
        val image: String,
        val description: String,
        val big_cities: ArrayList<String>?,
        val small_cities: ArrayList<String>?

)
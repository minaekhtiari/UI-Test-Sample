package com.example.ui_test_sample.fragmetExample.data

interface CountryDatasource {
    fun getCountry(countryId: Int): Country?
}

package com.example.ui_test_sample.fragmentExample.data

interface CountryDatasource {
    fun getCountry(countryId: Int): Country?
    fun getCountries(): List<Country>?
}

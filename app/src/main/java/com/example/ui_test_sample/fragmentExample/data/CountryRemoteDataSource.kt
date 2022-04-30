package com.example.ui_test_sample.fragmentExample.data

import com.example.ui_test_sample.fragmentExample.data.DummyCountry.Iran
import com.example.ui_test_sample.fragmentExample.data.DummyCountry.Netherlands

object CountryRemoteDataSource : CountryDatasource {
    private var Countries_REMOTE_DATA = LinkedHashMap<Int, Country>(2)
    init {
     addCountry(Netherlands)
        addCountry(Iran)
    }
    override fun getCountry(countryId: Int): Country? {
      return Countries_REMOTE_DATA[countryId]
    }


    private fun addCountry(country: Country){
        Countries_REMOTE_DATA.put(country.id,country)
    }

}
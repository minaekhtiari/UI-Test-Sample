package com.example.ui_test_sample.fragmentExample.data



class CountryRemoteDataSource : CountryDatasource {
    private var Countries_REMOTE_DATA = LinkedHashMap<Int, Country>(2)

    init {
        for (country in FakeCountryData.countries)
            addCountry(country)
    }

    override fun getCountry(countryId: Int): Country? {
        return Countries_REMOTE_DATA[countryId]
    }

    override fun getCountries(): List<Country>? {

        return ArrayList(Countries_REMOTE_DATA.values)
    }


    private fun addCountry(country: Country) {
        Countries_REMOTE_DATA.put(country.id, country)
    }

}
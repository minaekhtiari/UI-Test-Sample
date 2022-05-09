package com.example.ui_test_sample.fragmentExample.data

import com.example.ui_test_sample.fragmentExample.data.DummyCountry.Iran
import com.example.ui_test_sample.fragmentExample.data.DummyCountry.Netherlands

class CountryRemoteDataSource : CountryDatasource {
    private var Countries_REMOTE_DATA = LinkedHashMap<Int, Country>(2)
    init {
        addCountry(0,
            "The Netherlands",
            "https://dynaimage.cdn.cnn.com/cnn/q_auto,w_1100,c_fill,g_auto,h_619,ar_16:9/http%3A%2F%2Fcdn.cnn.com%2Fcnnnext%2Fdam%2Fassets%2F220216173054-amsterdam-travel-covid-19.jpg",
            "Netherlands, country located in northwestern Europe, also known as Holland. “Netherlands” means low-lying country",
            arrayListOf("Amsterdam", "Rotterdam","Utrecht"),
            arrayListOf("Leeuwarden", "Harlingen"))

        addCountry(1,
            "Iran",
            "https://cdn.wallpapersafari.com/17/83/srDn3R.jpg",
            "Iran, a mountainous, arid, and ethnically diverse country of southwestern Asia.",
            arrayListOf("Tehran", "Shiraz", "Tabriz"),
            arrayListOf("Rasht", "Uromia"))
    }



    private fun addCountry( id: Int,
                            name: String,
                            image: String,
                            description: String,
                            bigCities: ArrayList<String>?,
                            smallCities: ArrayList<String>?)
    {

        val country=Country(id=id,name=name,
        image=image,description=description,
            big_cities=bigCities,
            small_cities = smallCities)
        Countries_REMOTE_DATA.put(id,country)
    }

    override fun getCountry(countryId: Int): Country? {
        return Countries_REMOTE_DATA[countryId]
    }


}
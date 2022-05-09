package com.example.ui_test_sample.fragmetExample.fragments

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.bumptech.glide.request.RequestOptions
import com.example.ui_test_sample.R
import com.example.ui_test_sample.fragmentExample.data.Country
import com.example.ui_test_sample.fragmentExample.data.CountryRemoteDataSource
import com.example.ui_test_sample.fragmentExample.data.DummyCountry.Iran
import com.example.ui_test_sample.fragmentExample.fragments.CountryDetailFragment
import com.example.ui_test_sample.fragmentExample.fragments.CountryFragmentFactory
import io.mockk.every
import io.mockk.mockk


import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class CountryDetailFragmentTest {

    @Test
    fun isCountryDataVisible() {
        // SETUP
        val countryId = 1
        val name = "Iran"
        val description = "Iran, a mountainous, arid, and ethnically diverse country of southwestern Asia."
        val country = Country(
            countryId,
            name,
            "https://cdn.wallpapersafari.com/17/83/srDn3R.jpg",
            description ,
            arrayListOf("Tehran", "Shiraz", "Tabriz"),
            arrayListOf("Rasht", "Uromia")
        )


        val countryRemoteDataSource = mockk<CountryRemoteDataSource>()
        every {
            countryRemoteDataSource.getCountry(countryId)
        } returns country

        val requestOptions = RequestOptions()
            .placeholder(R.drawable.ic_launcher_background)
            .error(R.drawable.ic_launcher_background)
        val fragmentFactory = CountryFragmentFactory(requestOptions, countryRemoteDataSource)
        val bundle = Bundle()
        bundle.putInt("country_id", countryId)
        val scenario = launchFragmentInContainer<CountryDetailFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )


        onView(withId(R.id.country_title)).check(matches(withText(name)))

        onView(withId(R.id.country_description)).check(matches(withText(description)))


    }



}

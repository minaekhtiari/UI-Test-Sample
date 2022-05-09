package com.example.ui_test_sample.fragmetExample.fragments

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.ui_test_sample.R
import com.example.ui_test_sample.fragmentExample.data.Country
import com.example.ui_test_sample.fragmentExample.data.DummyCountry.Iran
import com.example.ui_test_sample.fragmentExample.fragments.CountryDetailFragment
import com.example.ui_test_sample.fragmentExample.fragments.CountryFragmentFactory


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




    }



}

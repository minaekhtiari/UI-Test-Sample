package com.example.ui_test_sample.fragmetExample.fragments

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.ui_test_sample.R
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
        val country = Iran
        val fragmentFactory = CountryFragmentFactory()
        val bundle = Bundle()
        bundle.putInt("country_id", country.id)
        val scenario = launchFragmentInContainer<CountryDetailFragment>(
            fragmentArgs = bundle,
            factory =fragmentFactory
        )

        // VERIFY
        onView(withId(R.id.country_title)).check(matches(withText(country.name)))

        onView(withId(R.id.country_description)).check(matches(withText(country.description)))
    }



}

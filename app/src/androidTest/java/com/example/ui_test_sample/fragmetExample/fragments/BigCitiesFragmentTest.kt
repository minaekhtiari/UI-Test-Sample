package com.example.ui_test_sample.fragmetExample.fragments

import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.ui_test_sample.R
import com.example.ui_test_sample.fragmentExample.fragments.BigCitiesFragment
import com.example.ui_test_sample.fragmentExample.fragments.CountryFragmentFactory
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class BigCitiesFragmentTest {

    @Test
    fun isBigCitiesListVisible() {
        // SetUP
        val directors = arrayListOf("Tehran", "Shiraz", "Tabriz")
        val fragmentFactory = CountryFragmentFactory()
        val bundle = Bundle()
        bundle.putStringArrayList("args_bigCities", directors)
        val scenario = launchFragmentInContainer<BigCitiesFragment>(
            fragmentArgs = bundle,
            factory = fragmentFactory
        )

        // VERIFY
        onView(withId(R.id.bigCities_text))
            .check(
                matches(
                    withText(
                        BigCitiesFragment.stringBuilderForBigCities(directors)
                    )
                )
            )
    }
}

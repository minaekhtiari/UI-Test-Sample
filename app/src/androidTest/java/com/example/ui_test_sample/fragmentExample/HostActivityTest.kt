package com.example.ui_test_sample.fragmentExample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.pressBack
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.ui_test_sample.R
import com.example.ui_test_sample.fragmentExample.Adapters.CountriesListAdapter
import com.example.ui_test_sample.fragmentExample.data.FakeCountryData
import com.example.ui_test_sample.fragmentExample.fragments.BigCitiesFragment
import com.example.ui_test_sample.fragmentExample.fragments.SmallCitiesFragment
import com.example.ui_test_sample.fragmetExample.fragments.BigCitiesFragmentTest
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class HostActivityTest{


    @get :Rule
    val activityRule = ActivityScenarioRule(HostActivity::class.java)
    val LIST_ITEM_IN_TEST = 2
    val COUNTRY_IN_TEST = FakeCountryData.countries[LIST_ITEM_IN_TEST]


    @Test
    fun test_isListFragmentVisible_onAppLaunch() {
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun test_selectListItem_isDetailFragmentVisible() {
        // Click list item
        onView(withId(R.id.recycler_view))
            .perform(actionOnItemAtPosition<CountriesListAdapter
            .CountryViewHolder>(LIST_ITEM_IN_TEST, click()))

        //  nav to DetailFragment and display name
        onView(withId(R.id.country_name)).check(matches(withText(COUNTRY_IN_TEST.name)))
    }

    @Test
    fun test_backNavigation_toMovieListFragment() {
        // Click list item
        onView(withId(R.id.recycler_view))
            .perform(actionOnItemAtPosition<CountriesListAdapter.CountryViewHolder>(LIST_ITEM_IN_TEST, click()))

        // Confirm nav to DetailFragment and display name
        onView(withId(R.id.country_name)).check(matches(withText(COUNTRY_IN_TEST.name)))

        pressBack()

        // Confirm MovieListFragment in view
        onView(withId(R.id.recycler_view)).check(matches(isDisplayed()))
    }

    @Test
    fun test_navDirectorsFragment_validateDirectorsList() {

        // Click list item #LIST_ITEM_IN_TEST
        onView(withId(R.id.recycler_view))
            .perform(actionOnItemAtPosition<CountriesListAdapter.CountryViewHolder>(LIST_ITEM_IN_TEST, click()))

        // Confirm nav to DetailFragment and display title
        onView(withId(R.id.country_name)).check(matches(withText(COUNTRY_IN_TEST.name)))

        // Nav to BigCitiesFragment
        onView(withId(R.id.big_cities)).perform(click())

        // Confirm correct directors are visible
        onView(withId(R.id.bigCities_text))
            .check(matches(withText(
                BigCitiesFragment.stringBuilderForBigCities(COUNTRY_IN_TEST.big_cities!!)
            )))
    }

    @Test
    fun test_navStarActorsFragment_validateActorsList() {
        // Click list item
        onView(withId(R.id.recycler_view))
            .perform(actionOnItemAtPosition<CountriesListAdapter.CountryViewHolder>(LIST_ITEM_IN_TEST, click()))

        // Confirm nav to DetailFragment and display name
        onView(withId(R.id.country_name)).check(matches(withText(COUNTRY_IN_TEST.name)))


        onView(withId(R.id.small_cities)).perform(click())

        onView(withId(R.id.small_cities_text))
            .check(matches(withText(
                SmallCitiesFragment.stringBuilderForSmallCities(COUNTRY_IN_TEST.small_cities!!)
            )))
    }
}
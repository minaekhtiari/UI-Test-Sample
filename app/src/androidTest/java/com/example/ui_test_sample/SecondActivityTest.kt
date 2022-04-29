package com.example.ui_test_sample

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import junit.framework.TestCase
import org.junit.Rule
import org.junit.Test

class SecondActivityTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(SecondActivity::class.java)

    // Visibility
    @Test
    fun testVisibility_title_nextButton() {
        onView(withId(R.id.activity_secondary_title))
            .check(matches(isDisplayed()))

        onView(withId(R.id.button_back))
            .check(matches(isDisplayed()))
    }

    // Text
    @Test
    fun testTitleTextDisplayed() {
        onView(withId(R.id.activity_secondary_title))
            .check(matches(withText(R.string.text_secondactivity)))
    }
}
package com.example.ui_test_sample


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner

import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @Test
    fun testIsActivityInView() {
      val activityScenario= ActivityScenario.launch(MainActivity::class.java)
       onView(withId(R.id.main))
           .check(matches(isDisplayed()))
    }

    @Test
    fun visibility_title_nextButton() {
        val activityScenario= ActivityScenario.launch(MainActivity::class.java)
     activityScenario.onActivity {
         onView(withId(R.id.activity_main_title))
             .check(matches(isDisplayed()))

         onView(withId(R.id.button_next)).check(matches(isDisplayed()))
     }
    }

    @Test
    fun isText_string_displayed() {
        val activityScenario= ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.activity_main_title))
            .check(matches(withText(R.string.text_main_activity)))
    }


    @Test
    fun test_navSecondaryActivity() {

        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.button_next)).perform(click())

        onView(withId(R.id.second)).check(matches(isDisplayed()))
    }

    /**
     * Test both ways to navigate from SecondaryActivity to MainActivity
     */
    @Test
    fun test_backPress_toMainActivity() {

        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        onView(withId(R.id.button_next)).perform(click())

        onView(withId(R.id.second)).check(matches(isDisplayed()))

        onView(withId(R.id.button_back)).perform(click()) // method 1

        onView(withId(R.id.main)).check(matches(isDisplayed()))

        onView(withId(R.id.button_next)).perform(click())

        pressBack() // method 2

        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }
}
package com.example.ui_test_sample


import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner

import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

   @Test
   fun testShowDialogTextInput(){

       val activityScenario= ActivityScenario.launch(MainActivity::class.java)
       val text="Mina"

       onView(withId(R.id.button_next)).perform(click())
       onView(withText(R.string.text_enter_text)).check(matches(isDisplayed()))
       onView(withText(R.string.text_ok)).perform(click())

       //can't click empty dialog
       onView(withText(R.string.text_enter_text)).check(matches(isDisplayed()))

       //this Id from Material Dialog Github
       onView(withId(com.afollestad.materialdialogs.input.R.id.md_input_message))
           .perform(typeText(text))

       onView(withText(R.string.text_ok)).perform(click())
       onView(withText(R.string.text_enter_text)).check(doesNotExist())

       onView(withId(R.id.activity_main_title)).check(matches(withText(text)))
   }
}
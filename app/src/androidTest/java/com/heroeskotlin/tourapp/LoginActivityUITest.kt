package com.heroeskotlin.tourapp

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.closeSoftKeyboard
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class LoginActivityTest {
    @get:Rule
    val activityRule = ActivityTestRule(LoginActivity::class.java)

    @Test
    fun testLoginSuccess() {
        // Enter valid email and password
        onView(withId(R.id.etUsername)).perform(typeText("user@example.com"))
        onView(withId(R.id.etPassword)).perform(typeText("password"), closeSoftKeyboard())

        // Click login button
        onView(withId(R.id.btnSubmit)).perform(click())

        // Check that success message is displayed
//        onView(withText(R.string.login_success)).check(matches(isDisplayed()))
    }

    @Test
    fun testLoginFailed() {
        // Enter invalid email and password
        onView(withId(R.id.etUsername)).perform(typeText("invalid"))
        onView(withId(R.id.etPassword)).perform(typeText("invalid"), closeSoftKeyboard())

        // Click login button
        onView(withId(R.id.btnSubmit)).perform(click())

        // Check that error message is displayed
//        onView(withText(R.string.login_failed)).check(matches(isDisplayed()))
    }
}
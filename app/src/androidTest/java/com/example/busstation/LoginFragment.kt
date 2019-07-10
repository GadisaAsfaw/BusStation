package com.example.busstation

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.junit.Test
import org.mockito.Mockito

class LoginFragment {
    @Test fun testView() {

        Espresso.onView(ViewMatchers.withId(R.id.login_text_tv))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.login_btn))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.signup_tv))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.user_name_et))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.user_password_et))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

    @Test
    fun testContent(){

        Espresso.onView(ViewMatchers.withId(R.id.login_text_tv))
            .check(ViewAssertions.matches(ViewMatchers.withText("LOGIN")))

        Espresso.onView(ViewMatchers.withId(R.id.login_btn))
            .check(ViewAssertions.matches(ViewMatchers.withText("LOGIN")))

        Espresso.onView(ViewMatchers.withId(R.id.signup_tv))
            .check(ViewAssertions.matches(ViewMatchers.withText("Sign Up")))

    }



}
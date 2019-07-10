package com.example.busstation

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.junit.Test

class ConfirmAccount {
    @Test
    fun testView() {

        Espresso.onView(ViewMatchers.withId(R.id.confirm_account_tv))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.acc_conf_no_et))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.acc_password_et))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


    }

    @Test
    fun testContent(){

        Espresso.onView(ViewMatchers.withId(R.id.acc_confirm_btn))
            .check(ViewAssertions.matches(ViewMatchers.withText("CONFIRM")))

        Espresso.onView(ViewMatchers.withId(R.id.confirm_account_tv))
            .check(ViewAssertions.matches(ViewMatchers.withText("CONFIRM YOUR ACCOUNT")))



    }
}
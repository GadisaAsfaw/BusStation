package com.example.busstation

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.junit.Test

class DriverProfile {

    @Test
    fun testView() {



        Espresso.onView(ViewMatchers.withId(R.id.d_user_name_tv))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.textView12))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))


    }

    @Test
    fun testContent(){


        Espresso.onView(ViewMatchers.withId(R.id.textView12))
            .check(ViewAssertions.matches(ViewMatchers.withText("Welcome to our Service")))

        Espresso.onView(ViewMatchers.withId(R.id.d_buy_ticket_btn))
            .check(ViewAssertions.matches(ViewMatchers.withText("BUY TICKET")))
        Espresso.onView(ViewMatchers.withId(R.id.available_seat_btn))
            .check(ViewAssertions.matches(ViewMatchers.withText("AVAILABLE TICKET")))
        Espresso.onView(ViewMatchers.withId(R.id.basic_info_btn))
            .check(ViewAssertions.matches(ViewMatchers.withText("BASIC INFO")))



    }
}
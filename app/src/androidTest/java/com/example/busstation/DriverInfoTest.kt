package com.example.busstation

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import org.junit.Test

class DriverInfoTest {
    @Test
    fun testView() {

        Espresso.onView(ViewMatchers.withId(R.id.place_bid_text_view))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.license_no_et))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.car_side_no_et))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.seat_no_et))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.car_vin_et))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.acc_no_et))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

    }

    @Test
    fun testContent(){

        Espresso.onView(ViewMatchers.withId(R.id.place_bid_text_view))
            .check(ViewAssertions.matches(ViewMatchers.withText("FILL INFO")))

        Espresso.onView(ViewMatchers.withId(R.id.add_info_btn))
            .check(ViewAssertions.matches(ViewMatchers.withText("Add info")))


    }

}
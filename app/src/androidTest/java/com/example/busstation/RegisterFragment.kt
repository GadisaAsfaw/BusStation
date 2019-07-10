package com.example.busstation

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class RegisterFragment {
    @Test
    fun testView() {



        Espresso.onView(ViewMatchers.withId(R.id.place_bid_text_view))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.u_name_et))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.user_password_et))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.driver_rb))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.traveller_rb))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.id_no_et))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.confirm_p_et))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))

        Espresso.onView(ViewMatchers.withId(R.id.submit_btn))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.back_button))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    @Test
    fun testContent(){


        Espresso.onView(ViewMatchers.withId(R.id.place_bid_text_view))
            .check(ViewAssertions.matches(ViewMatchers.withText("REGISTER")))

        Espresso.onView(ViewMatchers.withId(R.id.submit_btn))
            .check(ViewAssertions.matches(ViewMatchers.withText("SUBMIT")))
        Espresso.onView(ViewMatchers.withId(R.id.back_button))
            .check(ViewAssertions.matches(ViewMatchers.withText("back")))

        Espresso.onView(ViewMatchers.withId(R.id.traveller_rb))
            .check(ViewAssertions.matches(ViewMatchers.isChecked()))


        Espresso.onView(ViewMatchers.withId(R.id.driver_rb))
            .check(ViewAssertions.matches(ViewMatchers.isChecked()))

    }
}
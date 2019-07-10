package com.example.busstation

import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.filters.LargeTest
import androidx.test.runner.AndroidJUnit4
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)
@LargeTest
class EndToEnd {


    @Test
    fun testRegisteration(){

        //check radio button
        Espresso.onView(ViewMatchers.withId(R.id.traveller_rb)).perform(ViewActions.click())


        Espresso.onView(ViewMatchers.withId(R.id.traveller_rb))
            .check(ViewAssertions.matches(ViewMatchers.isChecked()))

        Espresso.onView(ViewMatchers.withId(R.id.driver_rb)).perform(ViewActions.click())

        Espresso.onView(ViewMatchers.withId(R.id.driver_rb))
            .check(ViewAssertions.matches(ViewMatchers.isChecked()))

        //fill username
        Espresso.onView(ViewMatchers.withId(R.id.u_name_et)).perform(ViewActions.typeText("ibrahim"))

        //fill password
        Espresso.onView(ViewMatchers.withId(R.id.user_password_et)).perform(ViewActions.typeText("abas"))

        // fill id no
        Espresso.onView(ViewMatchers.withId(R.id.id_no_et)).perform(ViewActions.typeText("abas"))

        //fill confirm password
        Espresso.onView(ViewMatchers.withId(R.id.confirm_p_et)).perform(ViewActions.typeText("abas"))


        //register
        Espresso.onView(ViewMatchers.withId(R.id.submit_btn)).perform(ViewActions.click())


        //back button
        Espresso.onView(ViewMatchers.withId(R.id.back_button)).perform(ViewActions.click())



    }

    @Test
    fun testLogin(){


        //username
        Espresso.onView(ViewMatchers.withId(R.id.user_name_et)).perform(ViewActions.typeText("ibrahim"))

        //password
        Espresso.onView(ViewMatchers.withId(R.id.user_password_et)).perform(ViewActions.typeText("abas"))

        //login button
        Espresso.onView(ViewMatchers.withId(R.id.login_btn)).perform(ViewActions.click())


    }



    @Test
    fun testDriverInfo(){
        //fill license no
        Espresso.onView(ViewMatchers.withId(R.id.license_no_et)).perform(ViewActions.typeText("addis 1025"))

        //fill car vin
        Espresso.onView(ViewMatchers.withId(R.id.car_vin_et)).perform(ViewActions.typeText("45d"))

        // fill car side no
        Espresso.onView(ViewMatchers.withId(R.id.car_side_no_et)).perform(ViewActions.typeText("45"))

        //fill number of seat available
        Espresso.onView(ViewMatchers.withId(R.id.seat_no_et)).perform(ViewActions.typeText("12"))

        //fill account number
        Espresso.onView(ViewMatchers.withId(R.id.acc_no_et)).perform(ViewActions.typeText("cbe4512"))


        //add info
        Espresso.onView(ViewMatchers.withId(R.id.add_info_btn)).perform(ViewActions.click())



    }

    @Test
    fun testConfirmAccount(){


        //account no
        Espresso.onView(ViewMatchers.withId(R.id.acc_conf_no_et)).perform(ViewActions.typeText("ibrahim"))

        //passwod
        Espresso.onView(ViewMatchers.withId(R.id.acc_password_et)).perform(ViewActions.typeText("abas"))

        //account confirm
        Espresso.onView(ViewMatchers.withId(R.id.acc_confirm_btn)).perform(ViewActions.click())


    }

    @Test
    fun testDriverProfile(){


//username view
        Espresso.onView(ViewMatchers.withId(R.id.d_user_name_tv))


        //buy
        Espresso.onView(ViewMatchers.withId(R.id.d_buy_ticket_btn)).perform(ViewActions.click())

        //availabe seat
        Espresso.onView(ViewMatchers.withId(R.id.available_seat_btn)).perform(ViewActions.click())

        //basic info
        Espresso.onView(ViewMatchers.withId(R.id.basic_info_btn)).perform(ViewActions.click())



    }


}
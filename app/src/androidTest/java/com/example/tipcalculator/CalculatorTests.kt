package com.example.tipcalculator

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers.containsString
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalculatorTests {
    @get:Rule()
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun calculate_20_percent_tip(){
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.calculate_tip_button))
            .perform(click())
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$10.00"))))
    }
    @Test
    fun calculate_18_percent_tip(){
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("100.00"))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.option_eighteen_percent))
            .perform(click())
        onView(withId(R.id.calculate_tip_button))
            .perform(click())
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$18.00"))))
    }
    @Test
    fun calculate_15_percent_tip(){
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("100.00"))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.option_fifteen_percent))
            .perform(click())
        onView(withId(R.id.calculate_tip_button))
            .perform(click())
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$15.00"))))
    }
    @Test
    fun calculate_15_percent_tip_no_round(){
        onView(withId(R.id.cost_of_service_edit_text))
            .perform(typeText("50.00"))
            .perform(ViewActions.closeSoftKeyboard())
        onView(withId(R.id.option_fifteen_percent))
            .perform(click())
        onView(withId(R.id.tip_round_switch))
            .perform(click())
        onView(withId(R.id.calculate_tip_button))
            .perform(click())
        onView(withId(R.id.tip_result))
            .check(matches(withText(containsString("$7.50"))))
    }
}
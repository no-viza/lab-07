package com.example.lab_7

import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)

class DriverScreenTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>() // access MainA

    @Test
    fun navigate_to_drivers_add_drivers_and_return_home() {
        // navigate to driver screen
        composeTestRule
            .onNodeWithTag("driverButton")
            .performClick()

        // verify driver screen
        composeTestRule
            .onNodeWithText("FormulaZero Drivers")
            .assertExists()

        // enter driver name
        composeTestRule
            .onNodeWithTag("nameInput")
            .performTextInput("Max V.")

        // add driver name
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify name appears
        composeTestRule
            .onNodeWithText("Max V.")
            .assertExists()

        // enter a second driver name
        composeTestRule
            .onNodeWithTag("nameInput")
            .performTextInput("Charles L.")

        // add the second driver name
        composeTestRule
            .onNodeWithTag("addDriverButton")
            .performClick()

        // verify the second name appears
        composeTestRule
            .onNodeWithText("Charles L.")
            .assertExists()

        // clear list
        composeTestRule
            .onNodeWithTag("clearButton")
            .performClick()

        // verify list is cleared
        composeTestRule
            .onNodeWithTag("drivers")
            .assertDoesNotExist()

        // return to home screen
        composeTestRule
            .onNodeWithTag("backButton")
            .performClick()

        // verify return to home screen
        composeTestRule
            .onNodeWithText("FormulaZero Home")
            .assertExists()
    }
}
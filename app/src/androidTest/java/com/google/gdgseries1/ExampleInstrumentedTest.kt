package com.google.gdgseries1

import androidx.compose.ui.test.assert
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithTag
import androidx.compose.ui.test.onAllNodesWithText
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.printToLog
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */

@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    //TODO note about the version of emulator
    //TODO the importance of the @Rule


    @Rule
    @JvmField
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun playGround() {
        composeTestRule.onRoot().printToLog("MainActivityCompose")
        val plusButton = composeTestRule.onNodeWithTag(PLUS_BUTTON)
        val quantityText = composeTestRule.onNodeWithTag(QUANTITY)
        val minusButton = composeTestRule.onNodeWithTag(MINUS_BUTTON)
        val checkoutButton = composeTestRule.onNodeWithTag(CHECKOUT)
        val successText = composeTestRule.onNodeWithTag(SUCCESS)

        quantityText.assert(hasText("Qt:0"))
        repeat(10){
            plusButton.performClick()

        }
        quantityText.assert(hasText("Qt:10"))
       repeat(10){
           minusButton.performClick()
       }
        quantityText.assert(hasText("Qt:0"))

        checkoutButton.performClick()
        composeTestRule.waitUntil(6000){
            composeTestRule.onAllNodesWithTag(SUCCESS).fetchSemanticsNodes().size ==1
        }



        //TODO finders
        /**
         *  composeTestRule.onNode(hasText("Checkout"))
         *  composeTestRule.onNodeWithContentDescription()
         *  composeTestRule.onNodeWithText()
         * composeTestRule.onNodeWithTag()
         */
        //TODO matcher
        //TODO input test with loader sample
        //best practices

        composeTestRule.onNodeWithText("Checkout")

    }
}
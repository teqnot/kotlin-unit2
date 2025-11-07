package com.example.pract8

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test

class WaterTrackerTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testInitialState() {
        composeTestRule.setContent {
            WaterTracker()
        }

        composeTestRule.onNodeWithText("0 мл").assertExists().assertIsDisplayed()
        composeTestRule.onNodeWithText("+250мл").assertExists().assertIsDisplayed()
        composeTestRule.onNodeWithText("Завершить день").assertExists().assertIsDisplayed()
        composeTestRule.onNodeWithText("Дней подряд: 0").assertExists().assertIsDisplayed()
    }

    @Test
    fun testAddWaterButton_increaseWaterCount() {
        composeTestRule.setContent {
            WaterTracker()
        }

        repeat(3) {
            composeTestRule.onNodeWithText("+250мл").performClick()
        }

        composeTestRule.onNodeWithText("750 мл").assertIsDisplayed()
    }

    @Test
    fun testFinishDayButton_resetsWaterAndUpdatesStreak_whenBelow1500() {
        composeTestRule.setContent {
            WaterTracker()
        }

        repeat(4) {
            composeTestRule.onNodeWithText("+250мл").performClick()
        }

        composeTestRule.onNodeWithText("Завершить день").performClick()

        composeTestRule.onNodeWithText("0 мл").assertExists().assertIsDisplayed()

        composeTestRule.onNodeWithText("Дней подряд: 0").assertExists().assertIsDisplayed()
    }

    @Test
    fun testFinishDayButton_increaseStreak_when1500OrMore() {
        composeTestRule.setContent {
            WaterTracker()
        }

        repeat(7) {
            composeTestRule.onNodeWithText("+250мл").performClick()
        }

        composeTestRule.onNodeWithText("Завершить день").performClick()

        composeTestRule.onNodeWithText("0 мл").assertExists().assertIsDisplayed()

        composeTestRule.onNodeWithText("Дней подряд: 1").assertExists().assertIsDisplayed()
    }

    @Test
    fun testStreakResets_afterLowWaterNextDay() {
        composeTestRule.setContent {
            WaterTracker()
        }

        repeat(6) {
            composeTestRule.onNodeWithText("+250мл").performClick()
        }
        composeTestRule.onNodeWithText("Завершить день").performClick()

        composeTestRule.onNodeWithText("+250мл").performClick()
        composeTestRule.onNodeWithText("Завершить день").performClick()

        composeTestRule.onNodeWithText("Дней подряд: 0").assertExists().assertIsDisplayed()
    }
}
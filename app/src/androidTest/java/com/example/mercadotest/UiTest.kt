package com.example.mercadotest

import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mercadotest.common.RESULT_LIST_TEST_TAG
import com.example.mercadotest.common.SEARCH_BAR_TEST_TAG
import com.example.mercadotest.presentation.MainActivity

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class UiTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun search_bar_is_displayed() {
        composeTestRule.onNodeWithTag(SEARCH_BAR_TEST_TAG).isDisplayed()
    }

    @Test
    fun result_list_is_displayed() {
        composeTestRule.onNodeWithTag(RESULT_LIST_TEST_TAG).isDisplayed()
    }
}
package com.example.lab3_5_kotlin

import android.content.pm.ActivityInfo
import androidx.lifecycle.Lifecycle
import androidx.test.core.app.launchActivity
import androidx.test.espresso.Espresso
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.action.ViewActions.*
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertTrue
import androidx.test.ext.junit.rules.ActivityScenarioRule
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class NavigationTest {
    @get:Rule
    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testOpeningFragment1(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .check(matches(isDisplayed()))
        Espresso
            .onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testOpeningFragment2() {
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToFirst))
            .check(matches(isDisplayed()))
        Espresso
            .onView(withId(R.id.bnToThird))
            .check(matches(isDisplayed()))
        Espresso
            .onView(withId(R.id.fragment2))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testFragment2to1() {
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToFirst))
            .perform(click())
        Espresso
            .onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))
        Espresso
            .onView(withId(R.id.fragment2))
            .check(doesNotExist())
        Espresso.pressBackUnconditionally()
        assertTrue(activityScenarioRule.scenario.state == Lifecycle.State.DESTROYED)
    }
    @Test
    fun testFragment2back1(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso.pressBack()
        Espresso
            .onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))
        Espresso.pressBackUnconditionally()
        assertTrue(activityScenarioRule.scenario.state == Lifecycle.State.DESTROYED)
    }
    @Test
    fun testClosingFragment2(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso.pressBack()
        Espresso
            .onView(withId(R.id.fragment2))
            .check(doesNotExist())
    }
    @Test
    fun testOpeningFragment3(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToFirst))
            .check(matches(isDisplayed()))
        Espresso
            .onView(withId(R.id.bnToSecond))
            .check(matches(isDisplayed()))
        Espresso
            .onView(withId(R.id.fragment3))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testFragment3back2(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        Espresso.pressBack()
        Espresso
            .onView(withId(R.id.fragment2))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testClosingFragment3(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        Espresso.pressBack()
        Espresso
            .onView(withId(R.id.fragment3))
            .check(doesNotExist())
    }

    @Test
    fun testFragment3to1(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToFirst))
            .perform(click())
        Espresso
            .onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testMoving3to1(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToFirst))
            .perform(click())
        Espresso
            .onView(withId(R.id.fragment2))
            .check(doesNotExist())
        Espresso
            .onView(withId(R.id.fragment3))
            .check(doesNotExist())
        Espresso.pressBackUnconditionally()
        assertTrue(activityScenarioRule.scenario.state == Lifecycle.State.DESTROYED)
    }
    @Test
    fun testFragment1toAbout() {
        launchActivity<MainActivity>()
        openAbout()
        Espresso.onView(withId(R.id.activity_about))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testFragment2toAbout(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        openAbout()
        Espresso.onView(withId(R.id.activity_about))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testFragment3toAbout(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        openAbout()
        Espresso.onView(withId(R.id.activity_about))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testAboutBackFragment1(){
        launchActivity<MainActivity>()
        openAbout()
        Espresso.pressBack()
        Espresso
            .onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testClosingAbout1(){
        launchActivity<MainActivity>()
        openAbout()
        Espresso.pressBack()
        Espresso
            .onView(withId(R.id.activity_about))
            .check(doesNotExist())
    }
    @Test
    fun testAboutBackFragment2(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        openAbout()
        Espresso.pressBack()
        Espresso
            .onView(withId(R.id.fragment2))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testClosingAbout2(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        openAbout()
        Espresso.pressBack()
        Espresso
            .onView(withId(R.id.activity_about))
            .check(doesNotExist())
    }
    @Test
    fun testAboutBackFragment3(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        openAbout()
        Espresso.pressBack()
        Espresso
            .onView(withId(R.id.fragment3))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testClosingAbout3(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        openAbout()
        Espresso.pressBack()
        Espresso
            .onView(withId(R.id.activity_about))
            .check(doesNotExist())
    }
    @Test
    fun testChangingOrientation1(){
        val activityScenario = launchActivity<MainActivity>()
        activityScenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(1000)
        activityScenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        Thread.sleep(1000)
        Espresso
            .onView(withId(R.id.bnToSecond))
            .check(matches(isDisplayed()))
        Espresso
            .onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testChangingOrientation2(){
        val activityScenario = launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        activityScenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(1000)
        activityScenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        Thread.sleep(1000)
        Espresso
            .onView(withId(R.id.bnToFirst))
            .check(matches(isDisplayed()))
        Espresso
            .onView(withId(R.id.bnToThird))
            .check(matches(isDisplayed()))
        Espresso
            .onView(withId(R.id.fragment2))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testChangingOrientation3(){
        val activityScenario = launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        activityScenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(1000)
        activityScenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        Thread.sleep(1000)
        Espresso
            .onView(withId(R.id.bnToFirst))
            .check(matches(isDisplayed()))
        Espresso
            .onView(withId(R.id.bnToSecond))
            .check(matches(isDisplayed()))
        Espresso
            .onView(withId(R.id.fragment3))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testChangingOrientationAbout(){
        val activityScenario = launchActivity<MainActivity>()
        openAbout()
        activityScenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
        }
        Thread.sleep(1000)
        activityScenario.onActivity { activity ->
            activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
        Thread.sleep(1000)
        Espresso
            .onView(withId(R.id.activity_about))
            .check(matches(isDisplayed()))
    }

    @Test
    fun testStackDepth(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        openAbout()
        Espresso.pressBack()
        Espresso.pressBack()
        Espresso.pressBack()
        Espresso.pressBackUnconditionally()
        assertTrue(activityScenarioRule.scenario.state == Lifecycle.State.DESTROYED)
    }
    @Test
    fun testNavigationUp2To1(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withContentDescription(R.string.nav_app_bar_navigate_up_description))
            .perform(click())
        Espresso
            .onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testNavigationUp3To2(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        Espresso
            .onView(withContentDescription(R.string.nav_app_bar_navigate_up_description))
            .perform(click())
        Espresso
            .onView(withId(R.id.fragment2))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testNavigationUp3To1(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        Espresso
            .onView(withContentDescription(R.string.nav_app_bar_navigate_up_description))
            .perform(click())
        Espresso
            .onView(withContentDescription(R.string.nav_app_bar_navigate_up_description))
            .perform(click())
        Espresso
            .onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testNavigationUpAboutTo1(){
        launchActivity<MainActivity>()
        openAbout()
        Espresso
            .onView(withContentDescription(R.string.nav_app_bar_navigate_up_description))
            .perform(click())
        Espresso
            .onView(withId(R.id.fragment1))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testNavigationUpAboutTo2(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        openAbout()
        Espresso
            .onView(withContentDescription(R.string.nav_app_bar_navigate_up_description))
            .perform(click())
        Espresso
            .onView(withId(R.id.fragment2))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testNavigationUpAboutTo3(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        openAbout()
        Espresso
            .onView(withContentDescription(R.string.nav_app_bar_navigate_up_description))
            .perform(click())
        Espresso
            .onView(withId(R.id.fragment3))
            .check(matches(isDisplayed()))
    }
    @Test
    fun testAllNavigationUp(){
        launchActivity<MainActivity>()
        Espresso
            .onView(withId(R.id.bnToSecond))
            .perform(click())
        Espresso
            .onView(withId(R.id.bnToThird))
            .perform(click())
        openAbout()
        Espresso
            .onView(withContentDescription(R.string.nav_app_bar_navigate_up_description))
            .perform(click())
        Espresso
            .onView(withContentDescription(R.string.nav_app_bar_navigate_up_description))
            .perform(click())
        Espresso
            .onView(withContentDescription(R.string.nav_app_bar_navigate_up_description))
            .perform(click())
        try {
            Espresso
                .onView(withContentDescription(R.string.nav_app_bar_navigate_up_description))
                .perform(click())
        } catch (ignored: NoMatchingViewException) {
        }
    }

}
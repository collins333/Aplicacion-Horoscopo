package com.collins.cursoandroid.horoscopoaplicacion.ui.home

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.intent.Intents
import androidx.test.espresso.intent.Intents.intended
import androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.collins.cursoandroid.horoscopoaplicacion.R
import com.collins.cursoandroid.horoscopoaplicacion.ui.detalle.HoroscopoDetalleActivity
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@HiltAndroidTest
class MainActivityTest {

    @get:Rule(order = 0)
    val hiltOrder = HiltAndroidRule(this)

    @get:Rule(order = 1)
    var mainActivityRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
        hiltOrder.inject()
        Intents.init()
    }

    @After
    fun tearDown() {
        Intents.release()
    }

    @Test
    fun `cuando_se_crea_mainActivity_abre_suerteFragment`() {
        onView(withId(R.id.suerteFragment)).perform(click())
    }

    @Test
    fun `cuando_selecciono_un_horoscopo_el_detalle_se_abre`() {
        onView(withId(R.id.rvHoroscopo))
          .perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
              0,
              click()
          )
        )

        intended(hasComponent(HoroscopoDetalleActivity::class.java.name))
    }
}
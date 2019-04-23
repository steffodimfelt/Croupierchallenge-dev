package com.fastiel.croupierchallenge


import android.support.test.runner.AndroidJUnit4
import com.fastiel.croupierchallenge.practice.PracticeMulti
import org.junit.Test
import org.junit.Assert.assertEquals
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SomeUnitTests {

    @Test
    fun testPractice(){
        assertEquals(PracticeMulti.amountOfQuestions.size, 20)

    }
}
package com.fastiel.croupierchallenge.practice

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.fastiel.croupierchallenge.R

class PracticeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.practice_activity)

        val frag = NumberChoiceFragment()
        val trans = supportFragmentManager.beginTransaction()
        trans.replace(R.id.practiceFrame, frag).commit()

    }
}
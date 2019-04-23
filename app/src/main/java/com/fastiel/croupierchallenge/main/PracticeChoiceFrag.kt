package com.fastiel.croupierchallenge.main

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fastiel.croupierchallenge.R
import com.fastiel.croupierchallenge.practice.PracticeActivity
import kotlinx.android.synthetic.main.practice_choice_frag.*

class PracticeChoiceFrag : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.practice_choice_frag, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        multiplicationBtn.setOnClickListener {
            val praceticeIntent = Intent(activity, PracticeActivity::class.java)
            startActivity(praceticeIntent)
        }
    }
}
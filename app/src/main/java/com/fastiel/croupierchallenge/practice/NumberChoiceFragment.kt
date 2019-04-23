package com.fastiel.croupierchallenge.practice

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fastiel.croupierchallenge.R
import kotlinx.android.synthetic.main.number_choice_fragment.*

class NumberChoiceFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.number_choice_fragment, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val nrOfButtons = numberChoiceView.childCount

        for (i in 0..(nrOfButtons - 1)) {
            val child = numberChoiceView.getChildAt(i)
            setListener(child)
        }
    }

    fun setListener(view: View) {
        view.setOnClickListener {
            val nrToPractice = when (view.id) {
                R.id.fiveBtn -> 5
                R.id.eightBtn -> 8
                else -> 0
            }

            val practiceFragment = PracticeFragment.newInstance(nrToPractice)
            val fragmentManager = fragmentManager ?: return@setOnClickListener
            val trans = fragmentManager.beginTransaction()

            trans.replace(R.id.practiceFrame, practiceFragment).commit()
        }
    }
}
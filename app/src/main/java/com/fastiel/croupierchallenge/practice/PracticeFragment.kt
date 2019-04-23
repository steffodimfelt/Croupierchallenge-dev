package com.fastiel.croupierchallenge.practice

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import com.fastiel.croupierchallenge.R
import kotlinx.android.synthetic.main.practice_fragment.*

class PracticeFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.practice_fragment, container, false)

        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val args = arguments ?: return
        val nrToPractice = args["nrToPractice"] as Int

        val questionObj = PracticeMulti.nextQuestion(nrToPractice)
        factorsTextView.text = questionObj.question

        val answerArray: MutableList<Int> = questionObj.worngAnswerList
        answerArray.add(questionObj.correctAnswer)
        answerArray.shuffle()
        val indexOfCorrectAnswer = answerArray.indexOf(questionObj.correctAnswer)
        println("index:: " + indexOfCorrectAnswer)
        option1.text = answerArray[0].toString()
        option2.text = answerArray[1].toString()
        option3.text = answerArray[2].toString()
        option4.text = answerArray[3].toString()

        val idForCorrectButton = 2131230860 + indexOfCorrectAnswer
        println("correct: " + idForCorrectButton)

        setClickListener(questionObj)

    }

    private fun setClickListener(questionToReturn: PracticeMulti.questionToReturn) {
     val nrOfChildren = practiceMathLayout.childCount
        var numberOfButtons:Int = 0
        for (i in 0..(nrOfChildren-1)){
            val view = practiceMathLayout.getChildAt(i)
            if (view is Button){
                view.setOnClickListener {
                    Toast.makeText(context, "hello from id: " + view.id, Toast.LENGTH_SHORT).show()
                    if (view.text == questionToReturn.correctAnswer.toString()){
                        points++
                        println("Points: " + points)
                    }
                }
            }
        }
    }


    companion object {
        var points:Int = 0
        fun newInstance(nrToPractice: Int): PracticeFragment {
            val fragment = PracticeFragment()
            val bundle = Bundle()
            bundle.putInt("nrToPractice", nrToPractice)

            fragment.arguments = bundle
            return fragment
        }
    }
}
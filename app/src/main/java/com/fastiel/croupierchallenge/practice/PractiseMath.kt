package com.fastiel.croupierchallenge.practice

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.fastiel.croupierchallenge.R

class PractiseMath : Fragment() {

    val multiNumber = 17
    val amountOfQuestions: List<Int> = (1..20).toList().shuffled()
    var questionCount = 0
    val wrongAnswerArray = ArrayList<Int>()


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.multiplication_fragment, container, true)
        return view
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

    println("jello")
        nextQuestion()



    }

    fun nextQuestion() {
        val temporaryAnswer = multiNumber * amountOfQuestions[questionCount]
        println("temporaryAnswer: " + temporaryAnswer)
        questionCount += 1

        wrongAnswer(temporaryAnswer, multiNumber)
    }

    fun wrongAnswer(correctAnswer: Int, multiNumber: Int) {
        wrongAnswerArray.clear()

        for (i in 1..3) {
            wrongAnswerArray.add(correctAnswer + (multiNumber * i))
            if (correctAnswer - (multiNumber * i) > 0) {
                wrongAnswerArray.add(correctAnswer - (multiNumber * i))
            }

        }

        println("wronganswerArray: " + wrongAnswerArray)

        if (questionCount < amountOfQuestions.size) {
            nextQuestion()
        }
    }
}
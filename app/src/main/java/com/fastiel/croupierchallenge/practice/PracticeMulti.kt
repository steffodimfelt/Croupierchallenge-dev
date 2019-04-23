package com.fastiel.croupierchallenge.practice

object PracticeMulti {

    data class questionToReturn(val worngAnswerList: MutableList<Int>, val correctAnswer: Int, val question: String)

    val amountOfQuestions: List<Int> = (1..20).toList().shuffled()
    var questionCount = 0
    val wrongAnswerArray = ArrayList<Int>()

    fun nextQuestion(numberIn: Int) : questionToReturn {
        val temporaryAnswer = numberIn * amountOfQuestions[questionCount]
        val multiString = amountOfQuestions[questionCount]
        val questionString = "$multiString * $numberIn"
        println("temporaryAnswer: " + temporaryAnswer)
        questionCount += 1

        val fullQuestion = wrongAnswer(temporaryAnswer, numberIn, questionString)

        return fullQuestion

    }

    fun wrongAnswer(correctAnswer: Int, multiNumber: Int, question: String) : questionToReturn {
        wrongAnswerArray.clear()

        for (i in 1..3) {
            wrongAnswerArray.add(correctAnswer + (multiNumber * i))
            if (correctAnswer - (multiNumber * i) > 0) {
                wrongAnswerArray.add(correctAnswer - (multiNumber * i))
            }

        }

        wrongAnswerArray.shuffled()

        // takes index 0 to 3 not includes 3
        val threeWrongAnswer: MutableList<Int> = wrongAnswerArray.subList(0,3)

        println("threeWrong: " + threeWrongAnswer)

        return questionToReturn(threeWrongAnswer, correctAnswer, question)

//        if (questionCount < amountOfQuestions.size) {
//            nextQuestion()
//        }
    }

}

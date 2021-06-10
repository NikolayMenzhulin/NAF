package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.bottom_sheet.widget

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.databinding.ViewQuizResultsDetailsBinding
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizAnswer
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizStage

/**
 * The view with detailed info about the passed quiz.
 */
class QuizResultsDetailsView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private val vb: ViewQuizResultsDetailsBinding =
        View.inflate(context, R.layout.view_quiz_results_details, this)
            .let { ViewQuizResultsDetailsBinding.bind(this) }

    init {
        initView()
    }

    fun setQuizResults(quizStage: QuizStage) {
        vb.questionTv.text = quizStage.questionText
        quizStage.answers.forEach { answer ->
            val answerTv: TextView = createAnswerTv(answer)
            addView(answerTv)
        }
    }

    private fun initView() {
        orientation = VERTICAL
    }

    private fun createAnswerTv(answer: QuizAnswer): TextView =
        TextView(context).apply {
            setPadding(
                resources.getDimensionPixelSize(R.dimen.dp16),
                0,
                resources.getDimensionPixelSize(R.dimen.dp16),
                resources.getDimensionPixelSize(R.dimen.dp8),
            )

            val answerNumber: Int = answer.number + 1
            val answerText: String = answer.answerText
            text = context.getString(R.string.quiz_results_details_view_quiz_answer_format, answerNumber, answerText)

            val textColor: Int =
                when {
                    answer.isSelected && !answer.isCorrect -> Color.RED
                    answer.isCorrect -> Color.GREEN
                    else -> Color.BLACK
                }
            setTextColor(textColor)
        }
}
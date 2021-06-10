package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.widget

import android.content.Context
import android.content.res.TypedArray
import android.util.AttributeSet
import android.view.View
import android.widget.LinearLayout
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import androidx.core.view.setMargins
import androidx.core.view.setPadding
import androidx.core.view.updateLayoutParams
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.databinding.ViewQuizInfoBinding
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizDifficultyType
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.storage.model.QuizResults

/**
 * The view with info about a quiz.
 */
class QuizInfoView @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null
) : LinearLayout(context, attrs) {

    private val vb: ViewQuizInfoBinding =
        View.inflate(context, R.layout.view_quiz_info, this)
            .let { ViewQuizInfoBinding.bind(this) }

    var quizResults: QuizResults? = null
        private set

    init {
        initAttrs()
        initView()
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        updateLayoutParams<MarginLayoutParams> {
            setMargins(resources.getDimensionPixelSize(R.dimen.dp16))
        }
    }

    fun setQuizResults(quizResults: QuizResults) {
        this.quizResults = quizResults
        with(quizResults) {
            vb.quizResultsTv.text = context.getString(
                R.string.quiz_results_fragment_quiz_results_format,
                countCompletedCorrectlyStages,
                stagesCount
            )
            vb.quizResultsContainer.isVisible = true
        }
    }

    fun clearQuizResults() {
        quizResults = null
        vb.quizResultsTv.text = ""
        vb.quizResultsContainer.isVisible = false
    }

    private fun initAttrs() {
        if (attrs == null) return

        val typedArray: TypedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.QuizInfoView, 0, 0)
        val quizTitle: String = typedArray.getString(R.styleable.QuizInfoView_quizTitle).orEmpty()
        val quizDifficultyTypeParam: Int = typedArray.getInteger(R.styleable.QuizInfoView_quizDifficulty, 0)
        val quizDifficultyType: String = QuizDifficultyType.getById(quizDifficultyTypeParam).text

        typedArray.recycle()

        vb.quizTitleTv.text = quizTitle
        vb.quizDifficultyTv.text = quizDifficultyType
    }

    private fun initView() {
        orientation = HORIZONTAL
        background = ContextCompat.getDrawable(context, R.drawable.bg_view_quiz)
        setPadding(resources.getDimensionPixelSize(R.dimen.dp16))
    }
}
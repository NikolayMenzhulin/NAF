package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.abstracts.AbstractFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.navigator.ScreenNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.databinding.FragmentQuizResultsBinding
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizStage
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_results.di.injector.QuizResultsFragmentInjector
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.utils.addOnBackPressedCallback

/**
 * The screen with results of a quiz.
 */
class QuizResultsFragment : AbstractFragment<QuizResultsFragmentViewModel, FragmentQuizResultsBinding, ScreenNavigator>(
    FragmentQuizResultsBinding::class.java
) {

    override val vm: QuizResultsFragmentViewModel by viewModels()

    override val injector = QuizResultsFragmentInjector(this)

    override fun onAttachCallback(context: Context) {
        addOnBackPressedCallback { vm.backToQuizChoosing() }
    }

    override fun onViewCreatedCallback(view: View, savedInstanceState: Bundle?) {
        initListeners()
    }

    override fun onObserveViewModelCallback() {
        val countCompletedCorrectlyStages: Int = vm.quiz.stages.count(QuizStage::isCompletedCorrectly)
        val stagesCount: Int = vm.quiz.stages.size
        renderQuizStatus(countCompletedCorrectlyStages, stagesCount)
        renderQuizResults(countCompletedCorrectlyStages, stagesCount)
    }

    private fun initListeners() {
        vb.backToQuizChoosingBtn.setOnClickListener { vm.backToQuizChoosing() }
    }

    private fun renderQuizStatus(countCompletedCorrectlyStages: Int, stagesCount: Int) {
        val quizStatusResId: Int =
            when {
                countCompletedCorrectlyStages == stagesCount -> R.string.quiz_results_fragment_excellent_quiz_status
                countCompletedCorrectlyStages >= stagesCount / 2 -> R.string.quiz_results_fragment_good_quiz_status
                countCompletedCorrectlyStages < stagesCount / 2 -> R.string.quiz_results_fragment_not_bad_quiz_status
                else -> R.string.quiz_results_fragment_not_bad_quiz_status
            }
        vb.quizStatusTv.text = getString(quizStatusResId)
    }

    private fun renderQuizResults(countCompletedCorrectlyStages: Int, stagesCount: Int) {
        vb.quizResultsTv.text = getString(
            R.string.quiz_results_fragment_quiz_results_format,
            countCompletedCorrectlyStages,
            stagesCount
        )
    }
}
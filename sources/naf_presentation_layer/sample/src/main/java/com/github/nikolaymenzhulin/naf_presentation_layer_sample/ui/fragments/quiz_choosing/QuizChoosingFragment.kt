package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing

import android.os.Bundle
import android.view.View
import android.widget.Toast
import android.widget.Toast.LENGTH_SHORT
import androidx.fragment.app.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.abstracts.AbstractFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.navigator.ScreenNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.databinding.FragmentQuizChoosingBinding
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizDifficultyType.*
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.di.injector.QuizChoosingFragmentInjector
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_choosing.widget.QuizInfoView

/**
 * The screen for choosing a quiz to pass.
 */
class QuizChoosingFragment : AbstractFragment<QuizChoosingFragmentViewModel, FragmentQuizChoosingBinding, ScreenNavigator>(
    FragmentQuizChoosingBinding::class.java
) {

    override val vm: QuizChoosingFragmentViewModel by viewModels()

    override val injector = QuizChoosingFragmentInjector(this)

    override fun onViewCreatedCallback(view: View, savedInstanceState: Bundle?) {
        initListeners()
    }

    override fun onObserveViewModelCallback() {
        vm.quizResultsList.observe(this) { quizResultsList ->
            if (quizResultsList.isEmpty()) {
                vb.easyQuizInfoV.clearQuizResults()
                vb.normalQuizInfoV.clearQuizResults()
                vb.hardQuizInfoV.clearQuizResults()
            } else {
                quizResultsList.forEach { quizResults ->
                    val quizInfoV: QuizInfoView =
                        when (quizResults.difficulty) {
                            EASY -> vb.easyQuizInfoV
                            NORMAL -> vb.normalQuizInfoV
                            HARD -> vb.hardQuizInfoV
                        }
                    quizInfoV.setQuizResults(quizResults)
                }
            }
        }
    }

    override fun onStartCallback() {
        vm.clearQuizPassingComponent()
    }

    private fun initListeners() {
        vb.toolbar.setOnMenuItemClickListener { menuItem ->
            if (menuItem.itemId == R.id.delete_quiz_results) {
                vm.deleteQuizResults()
            }
            true
        }

        vb.easyQuizInfoV.setOnClickListener { vm.goToQuizPassingFlow(EASY) }
        vb.normalQuizInfoV.setOnClickListener { vm.goToQuizPassingFlow(NORMAL) }
        vb.hardQuizInfoV.setOnClickListener { vm.goToQuizPassingFlow(HARD) }

        vb.easyQuizInfoV.setOnLongClickListener { vb.easyQuizInfoV.onLongClick() }
        vb.normalQuizInfoV.setOnLongClickListener { vb.normalQuizInfoV.onLongClick() }
        vb.hardQuizInfoV.setOnLongClickListener { vb.hardQuizInfoV.onLongClick() }
    }

    private fun QuizInfoView.onLongClick(): Boolean {
        if (quizResults != null) {
            vm.goToQuizResultsDetails(quizResults!!)
        } else {
            Toast.makeText(context, R.string.quiz_choosing_fragment_not_passed_quiz_toast_text, LENGTH_SHORT).show()
        }
        return true
    }
}
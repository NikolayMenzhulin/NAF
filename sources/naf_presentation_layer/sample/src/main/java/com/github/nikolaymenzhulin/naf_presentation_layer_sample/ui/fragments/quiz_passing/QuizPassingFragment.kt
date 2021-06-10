package com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing

import android.os.Bundle
import android.view.View
import android.view.ViewGroup.LayoutParams.MATCH_PARENT
import android.view.ViewGroup.LayoutParams.WRAP_CONTENT
import android.view.ViewGroup.MarginLayoutParams
import android.widget.RadioButton
import androidx.fragment.app.viewModels
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.abstracts.AbstractFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.navigation.cicerone.navigator.ScreenNavigator
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.R
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.databinding.FragmentQuizPassingBinding
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.domain.QuizAnswer
import com.github.nikolaymenzhulin.naf_presentation_layer_sample.ui.fragments.quiz_passing.di.injector.QuizPassingFragmentInjector
import java.util.*

/**
 * The screen for passing a quiz.
 */
class QuizPassingFragment : AbstractFragment<QuizPassingFragmentViewModel, FragmentQuizPassingBinding, ScreenNavigator>(
    FragmentQuizPassingBinding::class.java
) {

    override val vm: QuizPassingFragmentViewModel by viewModels()

    override val injector = QuizPassingFragmentInjector(this)

    override fun onViewCreatedCallback(view: View, savedInstanceState: Bundle?) {
        initViews()
        initListeners()
    }

    override fun onObserveViewModelCallback() {
        vm.stage.also { stage ->
            vb.questionTv.text = stage.questionText
            stage.answers.forEach { answer ->
                val answerRb: RadioButton = createRadioButton(answer)
                vb.answersRg.addView(answerRb)
            }
        }
        vb.nextBtn.text = getString(
            if (vm.isFinalStage) {
                R.string.quiz_passing_fragment_complete_quiz_btn_text
            } else {
                R.string.quiz_passing_fragment_next_stage_btn_text
            }
        )
        vm.selectedAnswer.observe(this) { selectedAnswer ->
            vb.nextBtn.isEnabled = selectedAnswer != null
        }
    }

    private fun initViews() {
        vb.toolbar.setNavigationIcon(R.drawable.ic_arrow_left)
    }

    private fun initListeners() {
        vb.toolbar.setNavigationOnClickListener { vm.exit() }
        vb.answersRg.setOnCheckedChangeListener { rg, checkedId ->
            val selectedRb: RadioButton? = rg.findViewById(checkedId)
            val selectedAnswer: QuizAnswer? = selectedRb?.tag as? QuizAnswer?
            selectedAnswer?.let { vm.onAnswerSelected(it) }
        }
        vb.nextBtn.setOnClickListener { vm.onStageCompleted() }
    }

    private fun createRadioButton(answer: QuizAnswer): RadioButton =
        RadioButton(context).apply {
            text = answer.answerText
            isChecked = answer == vm.selectedAnswer.value
            tag = answer
            id = UUID.randomUUID().hashCode()
            MarginLayoutParams(MATCH_PARENT, WRAP_CONTENT)
                .also { layoutParams ->
                    layoutParams.setMargins(0, 0, 0, resources.getDimensionPixelSize(R.dimen.dp16))
                    this.layoutParams = layoutParams
                }
        }
}
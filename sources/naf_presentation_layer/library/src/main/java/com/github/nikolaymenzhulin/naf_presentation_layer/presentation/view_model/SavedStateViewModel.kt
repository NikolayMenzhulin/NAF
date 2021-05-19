package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model

import androidx.lifecycle.SavedStateHandle

/**
 * Базовый класс view model с поддержкой сохранения состояния.
 *
 * @property savedStateHandle [SavedStateHandle], связанный c view
 */
abstract class SavedStateViewModel : BaseViewModel() {

    protected abstract val savedStateHandle: SavedStateHandle

    /**
     * Callback для сохранения состояния view model.
     * Вызывается на этапе выполнения onSaveInstantState, после вызова super.onSaveInstantState.
     */
    open fun onSaveInstantState() {
        // Empty realization.
    }
}
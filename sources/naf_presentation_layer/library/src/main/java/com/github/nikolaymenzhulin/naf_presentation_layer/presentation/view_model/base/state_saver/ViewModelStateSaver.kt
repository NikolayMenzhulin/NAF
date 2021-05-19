package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.base.state_saver

/**
 * Базовый интерфейс для view model с поддержкой сохранения состояния.
 */
internal interface ViewModelStateSaver {

    /**
     * Callback для сохранения состояния view model.
     * Вызывается на этапе выполнения onSaveInstantState, после вызова super.onSaveInstantState.
     */
    fun onSaveInstantState() {
        // Empty realization.
    }
}
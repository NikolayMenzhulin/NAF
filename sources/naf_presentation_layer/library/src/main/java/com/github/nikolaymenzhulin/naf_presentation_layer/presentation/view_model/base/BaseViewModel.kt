package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.base

import androidx.lifecycle.ViewModel
import com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view_model.base.state_saver.ViewModelStateSaver

/**
 * Базовый класс view model с поддержкой сохранения состояния.
 */
abstract class BaseViewModel : ViewModel(), ViewModelStateSaver
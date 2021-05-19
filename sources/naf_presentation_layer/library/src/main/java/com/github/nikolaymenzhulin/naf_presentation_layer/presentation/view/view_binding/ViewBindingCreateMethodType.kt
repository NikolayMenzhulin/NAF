package com.github.nikolaymenzhulin.naf_presentation_layer.presentation.view.view_binding

/**
 * Возможные типы создания view binding для view.
 *
 * @property INFLATE создание view binding через метод inflate
 * @property BIND создание view binding через метод bind
 */
internal enum class ViewBindingCreateMethodType {
    INFLATE, BIND
}
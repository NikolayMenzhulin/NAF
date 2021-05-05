package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.base.BaseFragmentTest
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.TestInjectableFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.TestInjectableFragmentInjector
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.TestInjectableFragmentInjector.TestInjectableFragmentComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.DaggerComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.test.R
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class InjectableFragmentTest : BaseFragmentTest(R.navigation.graph_injectable_fragment_test) {

    companion object {

        const val DEPENDENCY_STRING = "Test dependency."
    }

    @Test
    @DisplayName("Check creating of a view component")
    fun checkCreatingViewComponent() {
        val fragment: TestInjectableFragment = getTestFragment()
        val viewComponent: DaggerComponent? = fragment.injector.component
        assertNotNull(viewComponent)
        assertTrue { viewComponent is TestInjectableFragmentComponent }
    }

    @Test
    @DisplayName("Check resolving of view dependencies")
    fun checkResolvingViewDeps() {
        val fragment: TestInjectableFragment = getTestFragment()
        val expectedDependency: String = DEPENDENCY_STRING
        val actualDependency: String = fragment.dependency
        assertEquals(expectedDependency, actualDependency)
    }

    @Test
    @DisplayName("Check destroying of a view component")
    fun checkDestroyingViewComponent() {
        val fragment: TestInjectableFragment = getTestFragment()
        val injector: TestInjectableFragmentInjector = fragment.injector
        activity.scenario.close()
        assertNull(injector.component)
    }
}
package com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment

import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.base.BaseFragmentTest
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.TestInjectableFragment
import com.github.nikolaymenzhulin.naf_presentation_layer.android_test.presentation.view.fragment.test_data.fragment.injectable.di.holder.TestInjectableFragmentComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.di.component.DaggerComponent
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class InjectableFragmentTest : BaseFragmentTest() {

    companion object {

        const val DEPENDENCY_STRING = "Test dependency."
    }

    @BeforeEach
    fun setUp() {
        activity.scenario.onActivity { activity ->
            activity.openFragmentScreen(TestInjectableFragment())
        }
    }

    @Test
    @DisplayName("Check creating of a view component")
    fun checkCreatingViewComponent() {
        getTestFragment<TestInjectableFragment>()
        val viewComponent: DaggerComponent = TestInjectableFragmentComponentHolder.component
        assertNotNull(viewComponent)
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
        activity.scenario.close()
        assertThrows<IllegalStateException> {
            TestInjectableFragmentComponentHolder.component
        }
    }
}
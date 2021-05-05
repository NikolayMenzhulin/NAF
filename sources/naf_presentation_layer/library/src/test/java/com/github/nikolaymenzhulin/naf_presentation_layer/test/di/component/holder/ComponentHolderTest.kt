package com.github.nikolaymenzhulin.naf_presentation_layer.test.di.component.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.test.di.component.holder.test_data.component.TestComponent
import com.github.nikolaymenzhulin.naf_presentation_layer.test.di.component.holder.test_data.holder.TestComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.test.di.component.holder.test_data.module.TestModule
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class ComponentHolderTest {

    @BeforeEach
    fun setUp() {
        TestComponentHolder.clearComponent()
    }

    @Test
    fun `Check initialization of a component inside a holder`() {
        TestComponentHolder.initComponent(module = TestModule())
        assertNotNull(TestComponentHolder.component)
        assertTrue { TestComponentHolder.component is TestComponent }
    }

    @Test
    fun `Check clearing of a component inside a holder`() {
        TestComponentHolder.apply {
            initComponent(module = TestModule())
            clearComponent()
        }
        assertNull(TestComponentHolder.component)
    }
}
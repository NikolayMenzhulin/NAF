package com.github.nikolaymenzhulin.naf_presentation_layer.test.di.holder

import com.github.nikolaymenzhulin.naf_presentation_layer.test.di.holder.test_data.holder.TestComponentHolder
import com.github.nikolaymenzhulin.naf_presentation_layer.test.di.holder.test_data.module.TestModule
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class ComponentHolderTest {

    @AfterEach
    fun tearDown() {
        TestComponentHolder.clearComponent()
    }

    @Test
    fun `Check initialization of a component inside a holder`() {
        TestComponentHolder.initComponent(TestModule())
        assertNotNull(TestComponentHolder.component)
    }

    @Test
    fun `Check clearing of a component inside a holder`() {
        TestComponentHolder.apply {
            initComponent(TestModule())
            clearComponent()
        }
        assertThrows<IllegalStateException> { TestComponentHolder.component }
    }
}
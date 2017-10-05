package com.netcompany.sprak.decorator

import com.netcompany.sprak.adapter.Randomizer
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
class DecoratorTest : Spek({
    describe("Power") {
        it("pows the numbers") {
            val randomizer = mock<Randomizer> {
                on { next() } doReturn listOf(2, 4, 0, 1)
            }

            val powerRandomizer = Power(randomizer)

            assertEquals(4, powerRandomizer.next())
            assertEquals(16, powerRandomizer.next())
            assertEquals(1, powerRandomizer.next())
            assertEquals(2, powerRandomizer.next())
        }
    }
})

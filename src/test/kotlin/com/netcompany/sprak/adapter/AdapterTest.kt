package com.netcompany.sprak.adapter

import com.netcompany.sprak.BatchRandomizer
import com.nhaarman.mockito_kotlin.doReturn
import com.nhaarman.mockito_kotlin.mock
import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith

@RunWith(JUnitPlatform::class)
class AdapterTest : Spek({
    describe("BatchRandomizerAverageIterator") {
        it("takes each random batch, drops the first and last and gives the average of the rest") {
            val batchRandomizer = mock<BatchRandomizer> {
                on { nextBatch() } doReturn listOf(99, 1, 2, 3, 99)
            }

            val batchRandomizerAverageIterator = BatchRandomizerAverageIterator(batchRandomizer)

            assertEquals(2, batchRandomizerAverageIterator.next())
        }
    }
})

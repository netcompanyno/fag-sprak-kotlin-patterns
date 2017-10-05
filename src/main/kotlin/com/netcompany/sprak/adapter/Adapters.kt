package com.netcompany.sprak.adapter

import com.netcompany.sprak.BatchRandomizer
import kotlin.coroutines.experimental.buildIterator

sealed class BatchRandomizerIteratorAdapter(val batchRandomizer: BatchRandomizer) : Iterator<Int>

class Randomizer(batchRandomizer: BatchRandomizer) : BatchRandomizerIteratorAdapter(batchRandomizer) {
    var batch: List<Int> = emptyList()
    var index = 0

    override fun next(): Int {
        if (index >= batch.size) {
            batch = batchRandomizer.nextBatch()
            index = 0
        }
        return batch[index++]
    }

    override fun hasNext() = true
}

class BatchRandomizerAverageIterator(batchRandomizer: BatchRandomizer) :
        BatchRandomizerIteratorAdapter(batchRandomizer),
        Iterator<Int> by buildIterator({
            while (true) {
                val middleAverage = batchRandomizer.nextBatch().drop(1).dropLast(1).average().toInt()
                yield(middleAverage)
            }
        })


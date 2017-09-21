package com.netcompany.sprak.adapter

import com.netcompany.sprak.BatchRandomizer

class Randomizer(val batchRandomizer: BatchRandomizer) {
    var batch: List<Int> = emptyList()
    var index = 0

    fun next(): Int {
        if (index >= batch.size) {
            batch = batchRandomizer.nextBatch()
            index = 0
        }
        return batch[index++]
    }
}

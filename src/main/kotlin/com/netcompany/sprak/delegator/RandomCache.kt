package com.netcompany.sprak.delegator

import com.netcompany.sprak.BatchRandomizer

class RandomCache
private constructor(private val cache: MutableList<Int>,
                    private val batchRandomizer: BatchRandomizer)
    : List<Int> by cache {

    constructor(batchRandomizer: BatchRandomizer) : this(ArrayList<Int>(), batchRandomizer) {
        addMoreRandomNumbers()
    }

    fun addMoreRandomNumbers() {
        cache.addAll(batchRandomizer.nextBatch())
    }
}

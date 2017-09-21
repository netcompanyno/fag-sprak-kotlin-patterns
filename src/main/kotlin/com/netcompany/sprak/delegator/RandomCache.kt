package com.netcompany.sprak.delegator

import com.netcompany.sprak.BatchRandomizer

class RandomCache private constructor(private val listDelegate: MutableList<Int>,
                                      private val batchRandomizer: BatchRandomizer) : List<Int> by listDelegate {

    constructor(batchRandomizer: BatchRandomizer) : this(ArrayList<Int>(), BatchRandomizer()) {
        addMoreRandomNumbers()
    }

    fun addMoreRandomNumbers() {
        listDelegate.addAll(batchRandomizer.nextBatch())
    }

}

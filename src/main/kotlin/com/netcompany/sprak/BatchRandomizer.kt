package com.netcompany.sprak

import java.util.*

class BatchRandomizer(val max: Int = 100) {
    val random = Random()
    val batchSize = 10

    fun nextBatch() = (1..batchSize).map { random.nextInt(max) }
}

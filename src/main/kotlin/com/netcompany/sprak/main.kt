package com.netcompany.sprak

import com.netcompany.sprak.adapter.Randomizer
import com.netcompany.sprak.decorator.Power

fun main(args: Array<String>) {
    println("Hello, world!")
    println()

    println("BatchRandomizer")
    val batchRandomizer = BatchRandomizer(20)
    (1..3).forEach { println(batchRandomizer.nextBatch()) }
    println()

    println("Randomizer")
    val randomizer = Randomizer(batchRandomizer)
    (1..10).forEach { println(randomizer.next()) }
    println()

    println("LogRandomizer")
    val logRandomizer = Power(randomizer)
    (1..10).forEach { println(logRandomizer.next()) }
    println()

    val a = 4 or 2 and 1 or 2
    val b = 4 or (2 and (1 or 2))
    val c = ((4 or 2) and 1) or 2
    println(a)
    println(b)
    println(c)
}

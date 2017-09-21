package com.netcompany.sprak

fun main(args: Array<String>) {
    val randomBatch = BatchRandomizer().nextBatch()

    println("Hello, world!")
    println("Your lucky numbers are:")
    println(randomBatch.joinToString(", "))
}



package com.netcompany.sprak.factory

import com.netcompany.sprak.BatchRandomizer
import com.netcompany.sprak.adapter.Randomizer
import com.netcompany.sprak.decorator.Negator
import com.netcompany.sprak.decorator.Power

interface Factory<T> {
    fun create(): T
}

/**
 * Crude Java-like implementation
 */
class NegatePowerIteratorFactory() : Factory<Iterator<Int>> {
    override fun create(): Iterator<Int> {
        val batchRandomizer = BatchRandomizer()

        val randomizer = Randomizer(batchRandomizer)
        val negator = Negator(randomizer)
        val power = Power(negator)

        return power
    }
}

class Multiplier(private val base: Iterator<Int>,
                 private val factor: Int)
    : Iterator<Int> by base {

    companion object : Factory<Iterator<Int>> {
        override fun create(): Multiplier {
            val batchRandomizer = BatchRandomizer()
            val randomInts = Randomizer(batchRandomizer)

            return Multiplier(randomInts, 10)
        }
    }

    override fun next(): Int {
        return factor * base.next()
    }
}

fun testCallingMultiplierFactory() {
    val multiplier: Iterator<Int> = Multiplier.create()
}
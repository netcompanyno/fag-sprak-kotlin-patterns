package com.netcompany.sprak.decorator

class Timer(val base: Iterator<Int>) : Iterator<Int> by base {
    override fun next(): Int {
        val start = System.currentTimeMillis()
        val next = base.next()
        val end = System.currentTimeMillis()
        println("Time: ${end - start}")
        return next
    }
}

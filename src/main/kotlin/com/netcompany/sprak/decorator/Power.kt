package com.netcompany.sprak.decorator

class Power(val base: Iterator<Int>) : Iterator<Int> by base {
    override fun next(): Int {
        return 1 shl base.next()
    }
}

class Negator(private val base: Iterator<Int>) : Iterator<Int> by base {
    override fun next(): Int {
        return -base.next()
    }
}

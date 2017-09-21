package com.netcompany.sprak.decorator

class Logger(val base: Iterator<Int>) : Iterator<Int> by base {
    override fun next(): Int {
        return 1 shl base.next()
    }
}

package com.netcompany.sprak.delegator

interface A {
    fun doA()
}

interface B {
    fun doB()
}

class AImpl : A {
    override fun doA() {
        println("Doing A!")
    }

}

class BImpl : B {
    override fun doB() {
        println("Doing B!")
    }
}

class ABImpl(private val a: A, private val b: B) : A by a, B by b;

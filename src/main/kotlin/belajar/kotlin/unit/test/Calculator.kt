package belajar.kotlin.unit.test

class Calculator {
    fun add (first: Int, second: Int) : Int {
        return first + second
    }

    fun divide(first: Int, second: Int): Int{
        if ((first == 0)||(second == 0)){
            throw IllegalArgumentException("Can not divide by zero")
        } else {
            return first / second
        }
    }
}
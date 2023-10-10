package edu.uw.basickotlin

class Library {
    // This is just here as a placeholder, to make sure tests run and pass
    // before you add any code
    fun someLibraryMethod(): Boolean {
        return true
    }
}

// write a "whenFn" that takes an arg of type "Any" and returns a String

fun whenFn(a: Any): String {
    return when(a) {
        "Hello" -> "world"
        "Howdy" -> "Say what?"
        "Bonjour" -> "Say what?"
        is String -> "I don't understand"
        
        is Int -> {
            when(a) {
                0 -> "zero"
                1 -> "one"
                in 2..10 -> "low number"
                else -> "a number"
            }
        }
        
        else -> "I don't understand"
    }
}

// write an "add" function that takes two Ints, returns an Int, and adds the values

fun add(a: Int, b: Int): Int {
    return a + b
}
// write a "sub" function that takes two Ints, returns an Int, and subtracts the values
fun sub(a: Int, b: Int): Int {
    return a - b
}
// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments
fun mathOp(a: Int, b: Int, adds: (Int, Int) -> Int): Int {
    return adds(a,b)
}
// write a class "Person" with first name, last name and age

class Person(var firstName: String, val lastName: String, var age: Int) {
    val debugString: String 
        get() = "[Person firstName:$firstName lastName:$lastName age:$age]"
}
// write a class "Money" with amount and currency, and define a convert() method and the "+" operator

class Money(var amount: Int, var currency:String) {
    init {
        require(amount >= 0)
        require(currency in setOf("USD", "EUR", "CAN", "GBP"))
    }

    fun convert(target: String): Money {
        var newAmount: Double = when {
            currency == "USD" && target == "GBP" -> amount.toDouble() / 2
            currency == "USD" && target == "EUR" -> amount.toDouble() * 1.5
            currency == "USD" && target == "CAN" -> amount.toDouble() * 1.25

            currency == "GBP" && target == "USD" -> amount.toDouble() * 2
            currency == "GBP" && target == "EUR" -> amount.toDouble() * 3
            currency == "GBP" && target == "CAN" -> amount.toDouble() * 2.5

            currency == "EUR" && target == "GBP" -> amount.toDouble() / 3
            currency == "EUR" && target == "USD" -> (amount.toDouble() / 3) * 2
            currency == "EUR" && target == "CAN" -> (amount.toDouble() / 6) * 5

            currency == "CAN" && target == "GBP" -> amount.toDouble() * .4
            currency == "CAN" && target == "EUR" -> amount.toDouble() * 1.16
            currency == "CAN" && target == "USD" -> amount.toDouble() * .8

            else -> this.amount.toDouble()
        }

        return Money(newAmount.toInt(), target)
    }

    operator fun plus(other: Money): Money {
        if (currency == other.currency) {
            return Money(amount + other.amount, currency)
        } else {
            val newAmount = other.convert(currency).amount + amount

            return Money(newAmount, currency)
        }
    }
}


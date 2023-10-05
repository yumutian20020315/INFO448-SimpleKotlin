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
        0 -> "zero"
        1 -> "one"
        in 2..10 -> "low number"
        is String -> "I do't understand"
        is Number -> "a number"
        "Howdy" -> "Say what?"
        "Bonjour" -> "Say what?"
        else -> "I do't understand"
    }
}

// write an "add" function that takes two Ints, returns an Int, and adds the values

// write a "sub" function that takes two Ints, returns an Int, and subtracts the values

// write a "mathOp" function that takes two Ints and a function (that takes two Ints and returns an Int), returns an Int, and applies the passed-in-function to the arguments

// write a class "Person" with first name, last name and age

// write a class "Money" with amount and currency, and define a convert() method and the "+" operator

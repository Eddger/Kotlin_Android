import com.sun.jdi.Value

// Number type checker
fun primenum(num: Int): String{
    // prime numbers above greater than one and divisible by one and itself only
    if (num <= 1){
        return "$num is less than or equal to 1 and therefore is not a prime number"
    }
    for (x in 2 until  num){
        if (num % x == 0) { // checking if number is completely divisible by any other number except itself
            return "$num is divisible by $x and is therefore not a prime number"
        }
    }
    return "$num is a prime number"
}

// even numbers are completely divisible by 2, whilst odd numbers are not
fun evenoroddnum(num: Int) = if (num % 2 == 0) "$num is an Even number" else "$num is an Odd number"

// prints out if the number is integer or float
fun definition(x: Any): String{
    if (x is Int || x is Float){
        var numdef = when(x){ // comparing the value of x to the
            is Int -> return "$x is an integer"
            else -> return "$x is a float"
        }
    }else {
        return "This is not a number we can check"
    }
}

// a simple multiplication table
fun mult_table(x: Int = 5, y: Array<Int>){
    for (i in y){
        var mult = x * i
        println("$x X $i = $mult")
    }
}


fun main(args: Array<String>){
    print("Check for Prime Number, please enter a number: ")
    val input1 = readLine()!!
    val Value1: Int = input1.toInt()
    val prime_check = primenum(Value1)
    println(prime_check)


    print("Even/Odd Number Check, please enter a number: ")
    val input2 = readLine()!!
    val Value2: Int = input2.toInt()
    val evenodd_check = evenoroddnum(Value2)
    println(evenodd_check)

    print("Integer/Float Number type, please enter any number: ")
    val input3 = readLine()!!
    val Value3 = if ("." in input3) input3.toFloat() else input3.toInt()
    val def = definition(Value3)
    println(def)

    println(mult_table( y = arrayOf(23,56,78)))

}

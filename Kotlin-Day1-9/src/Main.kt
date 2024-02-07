/*fun main() {
    val name = "Kotlin"
    println("Hello, " + name + "!")

    for (i in 1..5) {
        println("i = $i")
    }
}

/*fun main(){
    var x = 3
    val name = "Cormoran"
    x = x * 10
    print("x is $x")

    while (x > 20) {
        x = x - 1
        print("\nx is now $x.")
    }
    println("\n Pow!")

    for (i in 1..10){
        x = x + 1
        print("\nx is now $x")
    }

    if (x == 20) {
        println("\nx must be 20.")
    }
    else {
        println("\nx isn't 20.")
    }
    if (name.equals("Cormoran")) {
        println("\n$name Strike")
    }
    var u = 1
    println("Before the loop. u = $u.")
    while (u < 4){
        println("In the loop. u = $u.")
        u = u + 1
    }
    println("After the loop. u = $u")
}
 */


val Choices = arrayOf("Rock","Paper","Scissors")

fun gameChoice() = Choices.random()

fun getgamechoice(optionsparam: Array<String>) = optionsparam[(Math.random() * optionsparam.size).toInt()]


fun userchoice(): String{
    var user: String = "Please enter one of the choices"
    for (user in Choices) println("Your choice is $user")
    return user
}


fun main(){
    val comp = getgamechoice(Choices)
    //var use = userchoice()
    println("computer = $comp" )
}*/

var str: String? = "Pizza"
var myArray: Array<String?> = arrayOf("Hi", "Hello")

fun main(){
    fun draw(): Long?{
        return 2
    }
    fun build(x: Int?) {
        println(x)
    }

    var w: Int? = 5
    //if (w != null){
    //draw()
    //}
    w?.let{
        println(it)
    }
    var rray = arrayOf("hi","huh",null)
    for (item in rray){
        item?.let{
            println(it)
        }
    }
    draw()?.let { it.plus(2) }

    println(w?.plus(5) ?: -1)

    var sy: String? = null
    println(sy?.plus(5) ?: -1)

    fun walk(){
        println(null)
    }
    //var x = sy!!.walk()
    //println(x)

    fun wake(str: String){
        try {
            val x = str.toInt()
            println(x)
        }catch (e: NumberFormatException){
            println("Crushed")
        }finally {
            println("${draw()} to be drawn")
        }
        println("Function ran")
    }

    wake("He, she, they")

    fun percent(x: Int){
        if (x !in 0..100){
            throw IllegalArgumentException("Percent not in range: $x")
        } else println("Percent is in range : $x")
    }
    percent(10)

    val test: String = "No"
    try {
        println("Start try")
        riskyCode(test)
        println("End try")
    } catch (e: BadException) {
        println("Bad Exception")
    } finally {
        println("Finally")
    }
    println("End of main")

}

class Duck(val height: Int? = null) {
    fun quack() {
        println("Quack! Quack!")
    }
}
class MyDucks(var myDucks: Array<Duck>) {
    fun quack() {
        for (duck in myDucks) {
            duck?.let{
                it.quack()
            }
        }
    }
    fun totalDuckHeight(): Int {
        var h: Duck? = Duck()
        for (duck in myDucks) {
            //   h += duck?.height ?: 0
        }
        return 0
    }
}

class BadException : Exception()
fun riskyCode(test: String) {
    println("Start risky code")
    if (test == "Yes") {
        throw BadException()
    }
    println("End risky code")
}

class BadException1: Exception()
fun myfunction(test: String) {
    try {
        print("t")
        riskyCode(test)
        print("o")
    } catch (e: BadException1) {
        print("a")
    } finally {
        println("w")
    }
    println("s")
}

fun riskycode(test: String){
    println("h")
    if (test == "Yes"){
        throw BadException()
    }
    println("r")
}


//print("Please enter your username: ")
//val user_input: Any? = readLine()
//log?.username(user_input)
//println(user_input)

//print("Please enter your username: ")
//val pwd_input: String? = readLine()!!
//val pwd: Int? = pwd_input?.toInt()
//log?.password(pwd)

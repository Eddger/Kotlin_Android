import kotlinx.coroutines.*

abstract class Student(val name: String, val course: String){
    abstract fun write_exams()
    abstract fun fees()
    fun read(){
        println("I read more than I can consume")
    }
}

interface graduation{
    fun cert(){
        println("Eventually we will graduate")
    }
}

class Regular_stud(name: String, course: String): Student(name, course), graduation{
    override fun write_exams(){
        println("We write exams on weekdays")
    }

    override fun fees() {
        println("We pay a maximum of 2000 cedis for tuition")
    }
}

class IDL_stud(name: String, course: String): Student(name, course), graduation{
    override fun write_exams(){
        println("We write exams on weekends")
    }

    override fun fees() {
        println("We pay a maximum of 3500 cedis for tuition")
    }
}

data class Average(val stud_name: String, val prog: String, val cwa : Double)


fun main(): Unit = runBlocking {
    println("The program begins on the: ${Thread.currentThread().name}")
    println(" ")

    val stud = listOf(Regular_stud("Chris", "Met"), IDL_stud("Emma", "Geomatic"))
    stud.forEach { it.read() }

    println(" ")

        withContext(Dispatchers.IO){
            println("Context thread: ${Thread.currentThread().name}")

            try {
            withTimeout(2000){
                stud.forEach {
                    it.fees()
                    it.write_exams()
                    it.cert()
                }
            }
        } catch(e: TimeoutCancellationException){
            println("To many elements to handle")
        }
        // perform local or network I/O outside the main thread.
    }

    println(" ")
    var score = mutableListOf(78,83,74)

    println("---------Coroutine Scope starts from here-------------")
    println(" ")

    coroutineScope {
        println("The coroutinescope thread: ${Thread.currentThread().name}")


        launch(Dispatchers.Default){
            score.forEach {
                val avg: (Int) -> Double = {it/4.0 + 0.5 * it}
                println(avg.invoke(it))
            }
            println("Scope1 thread: ${Thread.currentThread().name}")
            // perform computationally-intensive work outside the main thread
        }

        println(" ")

        launch(Dispatchers.Unconfined){
            var gpa1 = Average("Kofi","Met", 45.0)
            var (name, prog, cwa) = gpa1
            println("$name's gpa of $cwa ran on the scope2 thread: ${Thread.currentThread().name}")
            //
        }
    }

    println(" ")
    println("The program ends on the: ${Thread.currentThread().name}")
}
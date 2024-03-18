import kotlinx.coroutines.*

fun integral(num: Int): Int{
    return num * num
}

suspend fun doWorld() = coroutineScope {
    launch {
        delay(2000)
        println("World 2")
        println("coroutine3: ${Thread.currentThread().name}")
    }
    launch {
        delay(1000)
        println("World 1")
        println("coroutine4: ${Thread.currentThread().name}")
    }
    println("Hello")
}

fun main() = runBlocking {
    println("Main program starts: ${Thread.currentThread().name}")

    launch(Dispatchers.Default) {
        println("Hi there")
        println("Coroutine1: ${Thread.currentThread().name}")
        }

    val aug: Job = launch(Dispatchers.IO) {
        println("Hey")
        println("How are you doing")
        println("Coroutine2: ${Thread.currentThread().name}")
    }
    aug.join()

    val inter = async{
        try {
            withTimeout(1000) {
                integral(4)
            }
        } catch (e: TimeoutCancellationException) {
            println("The task exceeded the timeout limit.")
        }
    }
    println("Integral number is ${inter.await()}")

    withContext(Dispatchers.Unconfined){
        doWorld()
    }

    println("Main program ends: ${Thread.currentThread().name}")
}
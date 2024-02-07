class login_cred(){
    val user1: String? = "Gilbert13"
    val pin1: Int? = 2468

    fun username(name: String?){
        when (name){
            user1 -> println("You have inputted the right username")
            null -> try {
                if (name == null){
                    throw IllegalArgumentException()
                }
            }catch (e: Exception){
                println("Invalid username input")
            }
            else -> { println("You have inputted a wrong username")}
        }

    }
    fun password(pass: Int?){
        when (pass) {
            pin1 -> println("You have inputted the right password")
            null ->{
                try {
                    if (pass == null){
                        throw IllegalArgumentException()
                    }
                }catch (e: Exception){
                    println("Invalid password input")
                }
            }
            else -> {
                println("You have inputted a wrong password")
            }
        }
        }
}


fun main(){
    val log: login_cred? = login_cred()

    val usr: String? = "Gilbert13"
    val psw: Int? = 123467

    log?.username(usr)
    log?.password(psw)
}

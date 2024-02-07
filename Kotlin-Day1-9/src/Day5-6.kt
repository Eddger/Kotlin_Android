/*// superclass
open class KNUST_student(val name: String, val sex: String, age: Int, var year: Int){
    var age_now = age   // setting a setter to check if the input is valid
        set(value) {
            if (value > 0) field = value
        }
    var years_left: Int = 0
        get() {     // setting a getter to return a value from the input
            return 4 - year
        }
        set(value) {    // setting a setter to check if the return value is valid
            if (value > 0) field = value
        }

    init {      // initializing the class
        println("$name is a $age_now year old student of KNUST.")
    }

    fun yearsleft(years: Int){
        year = years
        println("$name has $years_left years left to become a graduate.")
    }

    // making functions accessible to subclass
    open fun learn(){
        println(if (years_left < 3) "You are a junior course mate" else "You are a Senior course mate.")
    }
    open fun item13(){
        println("Item 13 is a must have at all knust programmes.")
    }
}

// subclass
class COSS_student(val programme: String, cwa: Double): KNUST_student("Kofi","Male", 20, 2) {
    private var CWA = cwa   // assigning a property that's only visible to this class
        set(value) {if (value > 0) field = value}


    fun gpa(){
        println(if (CWA >70.0) "$name is a First class student." else "$name is a Second or Lower class student.")
    }

    //overriding function from being executed in superclass
    override fun learn() {
        println("It has become very difficult to learn nowadays.")
    }

    override fun item13() {
        println("The College never disappoints when it comes to item.")
    }
}


fun main(){
    val coss = COSS_student("Geography", 72.45) // creating class object
    println(coss.name)
    coss.yearsleft(4)
    //coss.gpa()
    coss.learn()
    coss.item13()
}*/
// inheritance superclass contains common code that subclass can inherit from

/*open class Animal: Roamable{
    open val image = ""
    open val food = ""
    open val habitat = ""
    var hunger = 10

    open fun makeNoise(){
        println("the animal is making a noise")
    }
    open fun eat(){
        println("the animal is eating")
    }
    override fun roam(){
        println("the animal is roaming")
    }
    fun sleep(){
        println("the animal is sleeping")
    }
}
// we use the overridde on subclass properties bcoz we use the val keyword but for var there is no need for that
class hippo: Animal(){
    override val image = "hippo.jpg"
    override val food = "grass"
    override val habitat = "water"

    override fun makeNoise() {
        println("Grunt! Grunt!")
    }

    override fun eat() {
        println("the hippo is eating $food")
    }
}

open class canine: Animal(){
    override fun roam() {
        println("the canine is roaming")
    }
}

class wolf: canine(){
    override val image = "wolf.jpg"
    override val food = "meat"
    override val habitat = "forests"

    override fun makeNoise() {
        println("Howl!")
    }

    override fun eat() {
        println("the wolf is eating $food")
    }
}

class vet{
    fun giveshot(animal: Animal){
        animal.makeNoise()
    }
}
// interface can't have constructors so prop. in  body block
// there's also no need to add the abstract keyword to a named property
// prop can't store state but return value
interface Roamable {
    fun roam()
}

class vehicle: Roamable{
    override fun roam() {
        println("the vehicle is roaming")
    }
}

fun main(){
    val animals = arrayOf(hippo(),wolf())
    for (item in animals){
        item.roam()
        item.eat()
    }
    val vett = vet()
    val wlf = wolf()
    val hippoo = hippo()
    vett.giveshot(wlf)
    vett.giveshot(hippoo)

    val roamables = arrayOf(hippo(), wolf(), vehicle())
    for (item in roamables){
        item.roam()
        if (item is Animal){
            item.eat()
        }
    }
}*/


// super class
abstract class things{
    abstract fun exist(name: String)
}
//subclass
class non_living: things(){
    override fun exist(name: String) {
        println("$name, we are immortals")
    }
}
abstract class living_things(val classify: String): things(), living_actions{
    abstract fun eat()

    override fun exist(name: String){
        println(" $name exists in the ecosystem")
    }

    fun reproduce(){
        println("$classify reproduce young ones of their own kind")
    }
}
// interface
interface living_actions{
    fun breathe()

    fun grow(name: String){
        println("$name grow until death")
    }
}

// subclass and interface implement
class plants(val roots: String = "taproot", val leaves: String ="simple", val stem: String= "succulent"): living_things(classify="Plants"){

    override fun eat() {
        println("$classify photosynthesize their own food")
    }

    override fun breathe() {
        println("$classify breathe in carbon dioxide and give out oxygen")
    }
    fun shedding(){
        println("$classify shed their leaves")
    }
}
class animal(val limbs: Int = 4, val eyes: Int = 2): living_things(classify = "Animals"){

    override fun breathe() {
        println("$classify breathes in oxygen and gives out carbon dioxide")
    }
    fun makesounds(){
        println("we produce sounds of our own")
    }
    override fun eat() {
        println("we don't make our own food")
    }
    fun move(){
        println("we can move to anyway we want")
    }
}

// data class
data class family(val surname: String = "Gates", val firstname: String = "Bill"){

    fun work(net_worth: Int, expense: Int): Int{ // calculate the amount left
        return net_worth - expense
    }
}
// main function
fun main(){
    val life_forms = arrayOf(animal(),plants("taproot","simple","woody"))
    for (life in life_forms){
        life.eat()
        life.reproduce()
        life.breathe()
        life.grow("Humans")
    }
    println(" ")
    val plantation = plants()
    plantation.shedding()

    val robot = non_living()
    robot.exist("Rocks")

    val don = family("Don","Garcia")
    println("Don family safecode (hascode): ${don.hashCode()}")
    val (surname, firstname) =don
    println("$surname $firstname has a net worth of $${don.work(15000,345)}")
}

fun main(){
    // working with collections
    val Nuc_family1 = mutableListOf("Father","Mother")
    println(Nuc_family1)

    if (Nuc_family1.size >= 2){
        Nuc_family1.add(1, "child")
        println(Nuc_family1)
    }

    Nuc_family1.set(1, "Son")
    println(Nuc_family1)

    val Nuc_family2 = Nuc_family1.toMutableList()
    Nuc_family2.set(0, "Father2")
    Nuc_family2.set(2,"Mother2")
    Nuc_family2.add(2, "Daughter")
    println(Nuc_family2)

    Nuc_family1.addAll(Nuc_family2)
    val Ext_family = Nuc_family1.toList()
    println(Ext_family.get(1))
    println(Ext_family.sorted())

    val family = Ext_family.toSet()
    println(family)

    // working with dataclasses and collections
    val obj1 = Desk("book", 5)
    val obj2 = Desk("pen",7)
    val obj3 = Desk("Computer", 2)
    val obj4 = Desk("stapula",3)

    val Desk_objs = mutableMapOf("Desk1" to obj1, "Desk2" to obj2,"Desk3" to obj3)
    println(Desk_objs.getValue("Desk1"))
    println("Item with most numbers on desk: ${Desk_objs.values.maxBy { it.number }}")
    println("Total number of items on the desk: ${Desk_objs.values.sumBy { it.number }}")

    val obj_Desk = Desk_objs.entries
    println(obj_Desk)

    Desk_objs.put("Desk4", obj4)
    println(Desk_objs)

    // working with lambdas and higher order functions
    var add: (Int, Int) -> Int = {x, y -> x + y}
    println(add(7,8))

    var sub: (Int) -> Int = {it -7}
    println(sub.invoke(10))

    var temp1 = temp(27.0) { it * 1.8 + 32}
    println(temp1)

    var heavy = temp(45.0, conversions("Weight"))
    println(heavy)

    Ext_family.forEach { println(it) }
    println("---------")
    Ext_family.map { println(it) }
    println("---------")
    println(Ext_family.filter {it != "Father"})
}

data class Desk(var name: String, var number: Int)

typealias Doubleconversion = (Double)->Double

fun temp(x: Double, conversion: (Double)->Double): Double{
    var result_temp = conversion(x)
    return result_temp
}

fun conversions(uni: String = "Temperature"): Doubleconversion{
    if (uni == "Temperature"){
        return {it * 1.8 + 32}
    }else if (uni == "Weight"){
        return {(it * 1)/ 1000}
    } else{
        return {it}
    }
}
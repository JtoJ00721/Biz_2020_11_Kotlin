package com.biz.hello

fun main() {

    var sum = add(69, 74)
    println(sum)
    println(add(6.9F, 7.4F))
    println(add("붸에", "에에엙!!!"))

}

fun add(num1 : Int, num2 : Int) : Int {
    return num1 + num2
}

fun add(fnum1 : Float, fnum2 : Float) : Float {
    return fnum1 + fnum2
}

fun add(str1 : String, str2 : String) : String {
    return str1 + str2
}
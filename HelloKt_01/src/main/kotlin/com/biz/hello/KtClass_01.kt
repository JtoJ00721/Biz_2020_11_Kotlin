package com.biz.hello

class Standard(data : Int) {}
class Standard1 private  constructor(data : Int) {}

class Empty
class Empty1 private constructor() {}

class PropertyClass(val firName : String, val lastName : String) {}

fun main() {
    var st = Standard(20)
    // println(st.data)

    var em = Empty()
    var pc = PropertyClass("농","농이")
    println("${pc.firName + pc.lastName}")
}
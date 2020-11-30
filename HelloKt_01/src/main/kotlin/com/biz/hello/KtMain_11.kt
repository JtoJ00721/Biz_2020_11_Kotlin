package com.biz.hello

fun main() {

    // Kotlin에서는 자료형이 지정되지 않은 변수에 null값을 저장하면 안된다
    // 반드시 자료형을 지정하고 자료형 뒤에 ? 를 첨가해야 한다.
    var anyVar : Int? = null
    println(anyVar)
    
    // Any 키워드는 모든 타입의 값을 저장할 수 있는 변수
    // Object type 변수
    var anyVar1 : Any = 123
    anyVar1 = "벨탱이"
    anyVar1 = 69.74F

    // any type에 저장된 값의 자료형은 무엇이냐?
    when(anyVar1) {
        is String -> println("문자열형")
        is Int -> println("Integer형")
        is Float -> println("Float형")
        is Double -> println("Double형")
        else -> println("우엥 자료형이 뭐지? ><")
    }

}
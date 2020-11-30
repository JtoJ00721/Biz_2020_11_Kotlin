package com.biz.hello

fun main() {

    val intNum : Int = 123
    val binNum : Int = 0b1001001 // 2진수
    val hexNum : Int = 0xF0

    val onMillion = 1_000_000
    val creditCarNum = 1234_5678_9000_2222L
    var hexByte = 0xFF_FC_F1_F0
    val binByte = 0b0100_1001_111_000

    var num1 : Int = 10
    var num2 : Int = 20
    var num3 : Long = (num1 + num2).toLong()
    num3 = num1.toLong() + num2.toLong()

    var num4 : Long = num3 + num2

    var asciiA : Int = 'A'.toInt()
    println("문자 A의 아스키 코드 : $asciiA")

    var charA : Char = 65.toChar()
    println("숫자(아스키코드 번호) 65의 Char 문자 $charA")


}
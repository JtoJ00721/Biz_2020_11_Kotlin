package com.biz.hello

// 처음만드는 코틀린 프로젝트
// 인텔리j 에서 코틀린은 알트 + 시프트 + f10으로 처음 시작하고 이미 만들어진 파일은
// 그냥 시프트 + f10 으로 실행한다
// kt 1.3 미만에서는 
// fun main(arg : Array<String>) {
// kt 1.3이상에서는 메인 메서드에 매개변수를 생략가능하다
fun main() {

    /**
     * 변수의 선언
     * 변수명 : 변수의 타입 = 값 형식으로 선언한다
     * 값의 타입이 명확할 경우 변수타입을 지정하지 않아도 된다.
     * 값의 타입이 명호가할 경우 변수추론을 통해 타입을 자동으로 지정한다.
     *
     * Console 출력문
     * $변수명 형깃으로 사용하면 Print() 함수에서 따옴표("")와 변수명으로
     * 문자열 출력 format을 자유롭게 설정할 수 있다.
     */

    println("반갑지롱")
    println("3 + 4 = ${3+4}")
    println("Republic of Korea")

    var num1 = 69
    var num2 = 74
    var sum = num1 + num2
    println("$num1 + $num2 = $sum")

    var num3 : Long?
    num3 = 69L
    var num4 : Long?
    num4 = 74L
    println("$num3 x $num4 = ${num3 * num4}")

    // val 로 선언된 변수는 상수로서 값을 변경할 수 없다.
    val num5 = 69
    val num6 = 74
    println("$num5 + $num6 = ${num5 + num6}")

    num4 = 6974L
    // num5 = 2222

}


package com.biz.hello

import java.awt.print.Book

// 내부적으로는 생서자, getter, setter, toString 이 기본적으로 만들어지고
// equeals(), hashCode(), copy(), componentN() 메서드가 생성
data class BookVO(var title : String, var author : String, var comp : String, var price : Int)
data class UserVO(var name : String = "농농이", var tel : String = "", var age : Int = 0)

fun main() {
    // 생성자가 변수 타입만 지정된 data class는 빈 값으로 객체를 생성할 수 없다
    var bookVO = BookVO("민족 전래동화","쩔쩔이", "벨브", 10800)
    bookVO.title = "전래동화"
    println(bookVO.toString())
    println(bookVO.hashCode())

    // data class를 빈 값으로 객체로 생성하려면 클래스 선언문에 default 값이 지정되어 있어야 한다
    var userVO = UserVO()
    println(userVO.toString())
    println(userVO.hashCode())
    println("userVO야 너는 UserVO 클래스 로부터 만들어진 객체냐? " +
            "${if(userVO.equals(BookVO("","","",0))) " 맞지롱 ><" else " 아니지롱 ><"}")
    
    var userVO1 = UserVO(name="농농이", age = 17)
    var bookVO1 = BookVO(author = "빙빙이", title = "장사쟁이", comp = "구대륙", price = 2000000000)
    println(UserVO(name="쩔쩔이", tel = "010-4038-4785").toString())

    var userVOCopy =userVO1.copy(name = "팀")
    println(userVOCopy.toString())

    // var title = bookVO1.title
    // var author = bookVO1.author
    var (title, author) = bookVO1
    println("$title, $author")

    var (first, second) = Pair("농농이","빙빙이")
    var (f,s,t) = Triple("010",222,6974)

    println(StaticClass.ID)
    println(StaticClass.SECURITY)

}

class StaticClass {
    companion object NAVER_KEY {
        var ID = "1234567"
        var SECURITY = "000111000"
    }

}

class Daum_Config {
    companion object {
        var SEC_ID = "6974"
        var SEC_VALUE = 2222
    }
}

fun daum() {
    println(Daum_Config.SEC_ID)
    println(Daum_Config.SEC_VALUE)
}
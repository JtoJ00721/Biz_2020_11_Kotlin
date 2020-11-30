package com.biz.hello

fun main() {
    var escString : String = "우리는 \n" +
            "달에사는\n" +
            "미친 마법의 버섯토끼 이다"
    println(escString)

    var rawString : String = """
        자세히 보아야 예쁘다
        자주 보아야 사랑스럽다
        너도 그렇다
        """
    println(rawString) // 여백까지 보이는 그대로
    println(rawString.trimIndent()) // 여백을 제거하고

    var rawIntentString : String = """
       | 자세히 보아야 예쁘다
       | 자주 보아야 사랑스럽다
       | 너도 그렇다
       | 부에에엙
    """

    println(rawIntentString.trimMargin("|"))

    // Kotlin은 문자열을 Char 배열과 동일하게 취급한다
    // 문자열변수에 첨자를 부착하여 사용하면 문자를 추출해 낼수 있다.
    var strArray = "Moon Rabbit"
    println(strArray[3]) // 배열처럼
    println(strArray.get(2)) // get method를 사용해서
    println(strArray.length) // 문자열 길이

    for(i in 0..strArray.length - 1) {
        print("${strArray[i]} \t")
    }

}
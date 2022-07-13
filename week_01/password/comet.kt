import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val input = scanner.nextLine().split(" ")
    val P = input[0].toList()
    val K = input[1].toLong()

    val answer = solution(P, K)
    if (answer > 0) {
        println("BAD $answer")
    } else {
        println("GOOD")
    }
}

fun String.toList(): List<String> {
    var str = this
    val list = mutableListOf<String>()

    while (str.isNotEmpty()) {
        if (str.length > 10) {
            list.add(str.substring(0, 10))
            str = str.substring(10)
        } else {
            list.add(str)
            break
        }
    }

    return list
}

fun solution(P: List<String>, K: Long): Long {
    var p: Long = 2

    while (p < K) {
        if (P.mod(p) == 0L) {
            return p
        }

        p++
    }

    return 0
}

fun List<String>.mod(divider: Long): Long {
    var dividend = ""
    for (l in this) {
        dividend = ((dividend + l).toLong() % divider).toString()
    }

    return dividend.toLong()
}
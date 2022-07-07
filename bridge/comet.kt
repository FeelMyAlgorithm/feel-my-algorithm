import java.util.*
import kotlin.math.pow

fun main() {
    val scanner = Scanner(System.`in`)
    val T = scanner.nextLine().toInt()
    for (i in 0 until T) {
        val (N, M) = scanner.nextLine().split(" ").map { it.toInt() }
        println(solution(N, M))
    }
}

fun solution(n: Int, m: Int): Int {
    val numerator = Array(m + 1) { 0 }
    val denominator = Array(n + 1) { 0 }

    for (i in m downTo m - n + 1) {
        factorize(i, numerator)
    }
    for (i in n downTo 2) {
        factorize(i, denominator)
    }

    denominator.forEachIndexed { index, i ->
        numerator[index] -= i
    }

    var answer = 1

    numerator.forEachIndexed { index, i ->
        answer *= index.toDouble().pow(i).toInt()
    }

    return answer
}

fun factorize(n: Int, array: Array<Int>) {
    var number = n
    var index = 2
    while (index <= number) {
        if (number % index == 0) {
            array[index]++
            number /= index
        } else {
            index++
        }
    }
}
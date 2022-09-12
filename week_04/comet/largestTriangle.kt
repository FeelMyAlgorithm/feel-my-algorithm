import java.lang.Integer.max
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val (n, m) = scanner.nextLine().split(' ').map { it.toInt() }
    val array = Array(n) { Array(m) { 0 } }
    var max = 0

    for (i in 0 until n) {
        val input = scanner.nextLine()
        input.forEachIndexed { j, c ->
            array[i][j] = c - '0'

            if (i > 0 && j > 0) {
                val neighbors = listOf(array[i - 1][j - 1], array[i - 1][j], array[i][j - 1])

                if (array[i][j] > 0 && neighbors.all { it > 0 }) {
                    array[i][j] = neighbors.minOf { it } + 1
                }
            }

            max = max(max, array[i][j])
        }
    }

    println(max * max)
}
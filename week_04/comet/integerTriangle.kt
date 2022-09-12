import java.util.*
import kotlin.math.max

lateinit var dp: Array<Array<Int>>
var n = 0
lateinit var tri: Array<Array<Int>>

fun main() {
    val scanner = Scanner(System.`in`)

    n = scanner.nextLine().toInt()
    tri = Array(n) { Array(n) { 0 } }

    for (i in 0 until n) {
        tri[i] = scanner.nextLine().split(' ').map { it.toInt() }.toTypedArray()
    }

    dp = Array(n) { Array(n) { -1 } }
    dp[n - 1] = tri[n - 1]

    println(find(0, 0))
}

fun find(y: Int, x: Int): Int {
    if (y == n - 1) {
        return dp[y][x]
    }

    if (dp[y][x] == -1) {
        dp[y][x] = tri[y][x] + max(find(y + 1, x), find(y + 1, x + 1))
    }

    return dp[y][x]
}
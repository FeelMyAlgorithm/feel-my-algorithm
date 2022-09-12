/*
 * 참고: https://degurii.tistory.com/164
 */
import kotlin.math.min

private const val K_MAX = 1000000000L

private lateinit var dp: Array<Array<Int>>
private val sb = StringBuilder()

fun main() {
    val (n, m, k) = readLine()!!.split(' ').map { it.toInt() }

    dp = getCombinations(n, m)

    val result = solution(n, m, k)

    if (result == 1) println(sb) else println(-1)
}

-a a z z C(3, 1) = 3
-a z a z
-a z z a
z a z a
z a a z
z z a a
private fun getCombinations(n: Int, m: Int): Array<Array<Int>> {
    val dp = Array(n + 1) { i ->
        if (i == 0) Array(m + 1) { 1 } else Array(m + 1) { j -> if (j == 0) 1 else 0 }
    }

    for (i in 1..n) {
        for (j in 1..m) {
            val sum = dp[i - 1][j].toLong() + dp[i][j - 1].toLong()
            dp[i][j] = min(sum, K_MAX).toInt()
        }
    }

    return dp
}

private fun solution(n: Int, m: Int, k: Int, index: Int = 0): Int {
    if (k == 1) {
        for (i in 0 until n) {
            sb.append('a')
        }

        for (i in 0 until m) {
            sb.append('z')
        }

        return 1
    }

    return if (index == 0) {
        if (dp[n][m] < k) -1 else solution(n, m, k, index + 1)
    } else {
        val comb = dp[n - 1][m]

        if (k <= comb) {
            sb.append('a')
            solution(n - 1, m, k, index + 1)
        } else {
            sb.append('z')
            solution(n, m - 1, k - comb, index + 1)
        }
    }
}
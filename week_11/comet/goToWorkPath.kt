/*
 참고: https://sosoeasy.tistory.com/75
 */
private const val DIVISOR = 100000
private lateinit var dp: Array<Array<Array<Int>>>

fun main() {
    val (w, h) = readLine()!!.split(' ').map { it.toInt() }
    dp = Array(w) { Array(h) { Array(4) { 0 } } }

    for (i in 0 until w) {
        for (j in 0 until h) {
            // 동동, 동북, 북동, 북북
            if (i == 0 && j == 0) continue
            when {
                i == 0 -> {
                    dp[i][j][0] = 1
                }
                j == 0 -> {
                    dp[i][j][3] = 1
                }
                else -> {
                    val preY = dp[i - 1][j]
                    val preX = dp[i][j - 1]

                    dp[i][j][0] = (preX[0] + preX[2]) % DIVISOR // 동동동, 북동동
                    dp[i][j][1] = preY[0] // 동동북
                    dp[i][j][2] = preX[3] // 북북동
                    dp[i][j][3] = (preY[1] + preY[3]) % DIVISOR // 동북북, 북북북
                }
            }
        }
    }

    println(dp[w - 1][h - 1].sum() % DIVISOR)
}
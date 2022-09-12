/*
 * 참고: https://comyoung.tistory.com/279
 */
import java.util.*
import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val village = Array(n) { Array(n) { false } }
    var houses = 0
    val altitudes = mutableListOf<List<Int>>()
    val heights = mutableListOf<Int>()
    var py = 0
    var px = 0

    for (i in 0 until n) {
        val input = br.readLine()
        input.forEachIndexed { j, s ->
            if (s == 'P') {
                py = i
                px = j
            } else if (s == 'K') {
                village[i][j] = true
                houses++
            }
        }
    }

    for (i in 0 until n) {
        val input = br.readLine().split(' ').map { s ->
            val height = s.toInt()
            heights.add(height)
            height
        }
        altitudes.add(input)
    }

    var answer = 1000000
    val set = heights.toSet().sorted()
    var i = 0
    var j = 0

    while (j < set.size) {
        while (i <= j) {
            val low = set[i]
            val high = set[j]

            if (altitudes[py][px] in low..high) {
                val isPossible = bfs(village, altitudes, py, px, low, high, houses)

                if (isPossible) {
                    val diff = high - low
                    answer = min(answer, diff)
                    i++
                } else {
                    break
                }
            } else {
                break
            }
        }

        j++
    }

    println(answer)
}

private fun bfs(
    village: Array<Array<Boolean>>,
    altitude: List<List<Int>>,
    y: Int,
    x: Int,
    min: Int,
    max: Int,
    houses: Int
): Boolean {
    val dy = listOf(-1, 0, 1, 1, 1, 0, -1, -1)
    val dx = listOf(1, 1, 1, 0, -1, -1, -1, 0)

    val dq = ArrayDeque<Pair<Int, Int>>().apply {
        add(Pair(y, x))
    }

    val size = altitude.size
    val visited = Array(size) { Array(size) { false } }
    visited[y][x] = true

    var count = 0

    while (dq.isNotEmpty()) {
        val (cy, cx) = dq.poll()

        if (village[cy][cx]) {
            count++

            if (count == houses) return true
        }

        for (i in 0 until 8) {
            val ny = cy + dy[i]
            val nx = cx + dx[i]

            if (ny in 0 until size && nx in 0 until size && altitude[ny][nx] in min..max && visited[ny][nx].not()) {
                dq.add(Pair(ny, nx))
                visited[ny][nx] = true
            }
        }
    }

    return false
}
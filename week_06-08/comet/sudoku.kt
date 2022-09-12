private val sudoku = Array(9) { Array(9) { 0 } }
private var countOfZeros = 0

fun main() {
    val blanks = mutableListOf<Pair<Int, Int>>() // y, x

    for (i in 0 until 9) {
        val input = readLine()!!.split(' ').map { it.toInt() }
        var count = 0

        input.forEachIndexed { j, num ->
            if (num == 0) {
                blanks.add(Pair(i, j))
                count++
            }
        }

        countOfZeros += count
        sudoku[i] = input.toTypedArray()
    }

    solution(blanks, 0, 0)

    sudoku.forEach {
        val sb = StringBuffer()

        it.forEach { num ->
            sb.append("$num ")
        }
        sb.substring(0, sb.length - 1)

        println(sb)
    }
}

fun solution(blanks: List<Pair<Int, Int>>, index: Int, count: Int): Int {
    if (count == countOfZeros) return count

    val (y, x) = blanks[index]
    var result = count

    for (k in 1..9) {
        sudoku[y][x] = k

        if (promising(y, x)) {
            result = solution(blanks, index + 1, count + 1)

            if (result == countOfZeros) return result
        }
    }

    sudoku[y][x] = 0

    return result
}

fun promising(y: Int, x: Int): Boolean {
    val num = sudoku[y][x]
    val xOffset = listOf(0, 1, 2, 0, 1, 2, 0, 1, 2)
    val yOffset = listOf(0, 0, 0, 1, 1, 1, 2, 2, 2)
    val startX = x / 3 * 3
    val startY = y / 3 * 3

    for (i in 0 until 9) {
        if (i != x && sudoku[y][i] == num) {
            return false
        }

        if (i != y && sudoku[i][x] == num) {
            return false
        }

        val curX = startX + xOffset[i]
        val curY = startY + yOffset[i]
        if ((curX == x && curY == y).not() && sudoku[curY][curX] == num) {
            return false
        }
    }

    return true
}
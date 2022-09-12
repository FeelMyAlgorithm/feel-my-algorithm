// 참고: https://moonsbeen.tistory.com/188
import kotlin.math.max

private val words = mutableListOf<String>()
private val alphabets = Array(26) { false }
private var alphabetMax = 0
private var answer = 0

fun main() {
    val (n, k) = readLine()!!.split(' ').map { it.toInt() }

    alphabetMax = k

    for (i in 0 until n) {
        readLine()?.let {
            words.add(it)
        }
    }

    var count = 0
    for (char in "antatica") {
        val index = char - 'a'

        if (alphabets[index].not()) {
            alphabets[index] = true
            count++
        }
    }

    backtrack(0, count)

    println(answer)
}

private fun backtrack(alphabetsIndex: Int, alphabetsCount: Int) {
    if (alphabetsCount == alphabetMax) {
        var wordsCount = 0

        for (word in words) {
            var readable = true
            for (alphabet in word) {
                val index = alphabet - 'a'
                if (alphabets[index].not()) {
                    readable = false
                    break
                }
            }

            if (readable) wordsCount++
        }

        answer = max(answer, wordsCount)

        return
    }

    for (i in alphabetsIndex until alphabets.size) {
        if (alphabets[i].not()) {
            alphabets[i] = true
            backtrack(i + 1, alphabetsCount + 1)
            alphabets[i] = false
        }
    }
}
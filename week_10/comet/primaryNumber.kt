fun main() {
    val n = readLine()!!.toInt()
    val primeNums = soe(n)

    if (primeNums.isEmpty()) {
        println(0)
        return
    }

    var answer = 0
    var left = 0
    var right = 0
    val addedNums = mutableListOf(primeNums[right])
    var temp = primeNums[right]

    while (right < primeNums.size) {
        when {
            temp == n -> {
                answer++
                temp -= addedNums.removeFirst()
                left++
            }
            temp < n -> {
                right++

                if (right == primeNums.size) break

                temp += primeNums[right]
                addedNums.add(primeNums[right])
            }
            else -> {
                temp -= addedNums.removeFirst()
                left++
            }
        }
    }

    println(answer)
}

private fun soe(n: Int): List<Int> {
    val isPrime = Array(n + 1) { it >= 2 }
    var i = 2

    while (i * i <= n) {
        if (isPrime[i]) {
            var j = i * i

            while (j <= n) {
                isPrime[j] = false

                j += i
            }
        }

        i++
    }

    val result = mutableListOf<Int>()
    isPrime.forEachIndexed { index, b ->
        if (b) result.add(index)
    }

    return result
}
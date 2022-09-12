import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val (n, m, k) = br.readLine().split(' ').map { it.toInt() }
    val array = Array(n) { 0L }

    for (i in 0 until n) {
        array[i] = br.readLine().toLong()
    }

    var size = 1
    while (size < n) {
        size *= 2
    }

    val indexedTree = Array(size * 2) { 0L }
    initTree(indexedTree, array)

    for (i in 0 until m + k) {
        val st = StringTokenizer(br.readLine())
        val a = st.nextToken().toInt()
        val b = st.nextToken().toInt()

        when (a) {
            1 -> {
                // b - 1번째 수를 c로 바꿈
                val c = st.nextToken().toLong()
                update(indexedTree, b - 1, c)
            }
            2 -> {
                // b - 1번째 수부터 c - 1번째 수까지의 합을 구하여 출력
                val c = st.nextToken().toInt()
                val sum = calcSum(indexedTree, b - 1, c - 1)
                bw.write("$sum\n")
            }
        }
    }

    bw.flush()
    bw.close()
    br.close()
}

private fun initTree(tree: Array<Long>, nums: Array<Long>) {
    val size = tree.size / 2

    for (i in nums.indices) {
        tree[size + i] = nums[i]
    }

    for (i in size - 1 downTo 1) {
        tree[i] = tree[i * 2] + tree[i * 2 + 1]
    }
}

private fun update(tree: Array<Long>, index: Int, value: Long) {
    val size = tree.size / 2
    var target = size + index
    tree[target] = value
    target /= 2

    while (target > 0) {
        tree[target] = tree[target * 2] + tree[target * 2 + 1]
        target /= 2
    }
}

private fun calcSum(tree: Array<Long>, index1: Int, index2: Int): Long {
    val size = tree.size / 2
    var left = size + index1
    var right = size + index2
    var sum = 0L

    while (left <= right) {
        if (left % 2 == 1) {
            sum += tree[left++]
        }

        if (right % 2 == 0) {
            sum += tree[right--]
        }

        left /= 2
        right /= 2
    }

    return sum
}
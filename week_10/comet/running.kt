/*
 * 참고: https://kimtaehyun98.tistory.com/113
 */
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()
    val n = br.readLine().toInt()

    val tempPlayers = mutableListOf<Player>()
    val players = Array(n) { 0 }

    val size = run {
        var size = 1

        while (size < n) size *= 2

        size
    }

    val tree = Array(2 * size) { 0 }

    for (i in 0 until n) {
        val skill = br.readLine().toLong()

        tempPlayers.add(Player(i, skill))
    }

    tempPlayers.sortedBy { it.skill }.mapIndexed { skill, p ->
        players[p.ranking] = skill
    }

    for (i in 0 until n) {
        val skill = players[i]
        val answer = i + 1 - sum(skill, tree)

        bw.write("$answer\n")

        update(skill, tree)
    }

    bw.flush()
    bw.close()
    br.close()
}

data class Player(val ranking: Int, val skill: Long)

private fun sum(skill: Int, tree: Array<Int>): Int {
    var sum = 0
    val size = tree.size / 2
    var left = size
    var right = size + skill

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

private fun update(skill: Int, tree: Array<Int>) {
    val size = tree.size / 2
    var index = size + skill

    while (index > 0) {
        tree[index]++

        index /= 2
    }
}
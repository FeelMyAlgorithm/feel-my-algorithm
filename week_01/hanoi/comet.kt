class Solution {
    fun solution(n: Int): Array<IntArray> {
        return recursion(n, 1, 2, 3, mutableListOf())
    }

    fun recursion(n: Int, start: Int, mid: Int, end: Int, answer: MutableList<List<Int>>): Array<IntArray> {
        if (n <= 1) {
            answer.add(listOf(start, end))
        } else {
            recursion(n - 1, start, end, mid, answer)
            answer.add(listOf(start, end))
            recursion(n - 1, mid, start, end, answer)
        }

        return answer.map { it.toIntArray() }.toTypedArray()
    }
}
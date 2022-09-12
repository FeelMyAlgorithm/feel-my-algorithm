class Solution {
    fun solution(s: String): IntArray {
        val answer = mutableListOf<Int>()
        
        val elements = s.substring(1, s.length - 2).split("},").map {
            it.substring(1, it.length).split(',').map { it.toInt() }.toMutableList()
        }.sortedBy { it.size }
        
        elements.forEachIndexed { index, element ->
            answer.forEach {
                val index = element.lastIndexOf(it)
                element.removeAt(index)
            }

            answer.add(element[0])
        }
        
        return answer.toIntArray()
    }
}
class Solution {
    val answer = mutableListOf<String>()
    
    fun letterCombinations(digits: String): List<String> {
        val array = Array(10) { listOf<Char>() }
        
        digits.forEach {
            val number = it - '0'
            val letters = when (number) {
                2 -> listOf('a', 'b', 'c')
                3 -> listOf('d', 'e', 'f')
                4 -> listOf('g', 'h', 'i')
                5 -> listOf('j', 'k', 'l')
                6 -> listOf('m', 'n', 'o')
                7 -> listOf('p', 'q', 'r', 's')
                8 -> listOf('t', 'u', 'v')
                9 -> listOf('w', 'x', 'y', 'z')
                else -> listOf()
            }
            
            array[number] = letters
        }
        
        backtrack(array, digits, 0, "")
        
        return answer
    }
    
    fun backtrack(array: Array<List<Char>>, digits: String, index: Int, combi: String) {
        if (index == digits.length) {
            if (combi.isNotEmpty()) {
                answer.add(combi)
            }
            
            return
        }
        
        val number = digits[index] - '0'

        for (letter in array[number]) {
            val sb = StringBuilder(combi)
            sb.append(letter)
            backtrack(array, digits, index + 1, sb.toString())
        }
    }
}
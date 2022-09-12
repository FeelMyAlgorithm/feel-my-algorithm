import kotlin.collections.*

class Solution {
    val answer = mutableListOf<String>()
    
    fun generateParenthesis(n: Int): List<String> {
        var left = n
        var right = n
        
        dfs(n, n, "")
        
        return answer
    }
    
    fun dfs(left: Int, right: Int, string: String) {
        if (left == 0 && right == 0) {
            if (isWellformed(string)) answer.add(string)
            return
        }
        
        if (left > 0) {
            dfs(left - 1, right, string + '(')
        }
        
        if (right > 0) {
            dfs(left, right - 1, string + ')')
        }
    }
    
    fun isWellformed(string: String): Boolean {
        val list = mutableListOf<Char>()
        
        for (it in string) {
            if(it == ')') {
                if (list.lastOrNull() == '(') {
                    list.removeAt(list.lastIndex)
                } else {
                    return false
                }
            } else {
                list.add(it)
            }
        }
        
        return true
    }
}
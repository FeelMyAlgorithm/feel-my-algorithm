class Solution {
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        var answer = 0
        val basket = mutableListOf<Int>()
        val list = Array(board.size) { mutableListOf<Int>() }
        
        for (i in 0 until board.size) {
            for (j in 0 until board.size) {
                val doll = board[i][j]
                if (doll != 0) {
                    list[j].add(0, board[i][j])                    
                }
            }
        }
        
        moves.forEach {
            val position = list[it - 1]
            val picked = if (position.isNotEmpty()) position.removeLast() else null
            
            if (picked != null) {
                if (picked == basket.lastOrNull()) {
                    answer += 2
                    basket.removeLast()
                } else {
                    basket.add(picked)
                }   
            }
        }
        
        return answer
    }
}
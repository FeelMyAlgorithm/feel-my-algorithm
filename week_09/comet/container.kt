import kotlin.math.max
import kotlin.math.min

class Solution {
    fun maxArea(height: IntArray): Int {
        var answer = 0
        
        var start = 0
        var end = height.size - 1
        
        while (start < end) {
            val sHeight = height[start]
            val eHeight = height[end]
            val area = (end - start) * min(sHeight, eHeight)
            answer = max(answer, area)
        
            if (sHeight > eHeight) end--
            else start++
        }
        
        return answer
    }
}
import kotlin.math.max
import kotlin.math.min

class Solution {
    fun solution(w: Int, h: Int): Long {
        var answer: Long = 0
        
        val a = gcd(w, h)
        var x = w / a
        var y = h / a
        
        return w.toLong() * h.toLong() - (w + h - a)
    }
    
    fun gcd(n: Int, m: Int): Int {
        var a = max(n, m)
        var b = min(n, m)
        
        while (b > 0) {
            val r = a % b
            a = b
            b = r
        }
        
        return a
    }
}
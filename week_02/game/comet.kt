
import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val (x, y) = scanner.nextLine().split(' ').map { it.toInt() }

    println(binarySearch(x, y, x * 2))
}

fun binarySearch(x: Int, y: Int, max: Int): Int {
    val target = 100L * y / x
    var start = 0
    var end = max - 1
    var mid = (start + end) / 2

    while (end - start >= 0) {
        val new = 100L * (y + mid) / (x + mid)
        val next = 100L * (y + mid + 1) / (x + mid + 1)

        if (new == target && new != next) {
            return mid + 1
        } else if (new <= target || new == target && new == next) {
            start = mid + 1
        } else {
            end = mid - 1
        }

        mid = (start + end) / 2
    }

    return -1
}

class Solution {
    fun myPow(x: Double, n: Int): Double {
        if (n == 0) return 1.0
        if (n < 0) {
            return 1/x * myPow(1/x, -(n + 1))
        } else {
            return if (n % 2 == 0) myPow(x*x, n/2) else x*myPow(x*x, n/2)
        }
    }
}
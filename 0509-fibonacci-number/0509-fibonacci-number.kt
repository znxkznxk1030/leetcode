class Solution {
    val dp = IntArray(31)
    
    fun fib(n: Int): Int {
        if (n == 0) return 0
        if (n == 1) return 1
        
        if (dp[n] > 0) {
            return dp[n]
        } else {
            dp[n] = fib(n - 1) + fib(n - 2)
            return dp[n]
        }
    }
}
class Solution {
    fun longestArithSeqLength(nums: IntArray): Int {
        val n = nums.size
        val dp = Array(1001){ IntArray(n) }
        var result = 0
        
        for (i in 1 until n) {
            for (j in 0 until i) {
                val diff = nums[j] - nums[i] + 500
                dp[diff][i] = Math.max(dp[diff][i], 1 + dp[diff][j])
                result = Math.max(result, dp[diff][i])
            }
        }
        
        return result + 1
    }
}
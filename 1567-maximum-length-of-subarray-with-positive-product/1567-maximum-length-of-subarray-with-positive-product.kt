class Solution {
    fun getMaxLen(nums: IntArray): Int {
        val dp = Array(nums.size){ IntArray(2){0} }
        
        if (nums[0] > 0) {
            dp[0][0] = 1   
        } else if (nums[0] < 0) {
            dp[0][1] = 1
        } else {
            dp[0][0] = 0
            dp[0][1] = 0
        }
        
        var result = dp[0][0]
        
        for (i in 1 until nums.size) {
            if (nums[i] > 0) {
                dp[i][0] = dp[i - 1][0] + 1
                dp[i][1] = if (dp[i - 1][1] > 0 ) dp[i - 1][1] + 1 else 0
            } else if (nums[i] < 0) {
                dp[i][0] = if (dp[i - 1][1] > 0 ) dp[i - 1][1] + 1 else 0
                dp[i][1] = dp[i - 1][0] + 1
            } else {
                dp[i][0] = 0
                dp[i][1] = 0
            }
            
            result = Math.max(result, dp[i][0])
        }
        
        return result
    }
}
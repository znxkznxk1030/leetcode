class Solution {
    fun maxSubArray(nums: IntArray): Int {
        val dp = IntArray(nums.size)
        var max = nums[0]
        dp[0] = if(nums[0] > 0) nums[0] else 0
        
        for(i in 1 until nums.size) {
            dp[i] = dp[i - 1] + nums[i]
            max = Math.max(dp[i], max)
            if (dp[i] < 0) dp[i] = 0
        }
        
        return max
    }
}
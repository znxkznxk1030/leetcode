class Solution {
    fun canJump(nums: IntArray): Boolean {
        if (nums.size <= 1) return true
        val dp = IntArray(nums.size){ 0 }
        dp[0] = nums[0]
        
        for (i in 1 until nums.size - 1) {
            if(dp[i - 1] > 0) dp[i] = Math.max(nums[i], dp[i - 1] - 1)
        }
        
        return dp[nums.size - 2] >= 1
    }
}

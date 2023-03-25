class Solution {
    fun canJump(nums: IntArray): Boolean {
        if (nums.size < 2) return true
        
        val dp = IntArray(nums.size){ 0 }
        dp[0] = nums[0]
        if (dp[0] == 0) return false
        
        for (i in 1 until nums.size - 1) {
            dp[i] = Math.max(nums[i], dp[i - 1] - 1)
            if (dp[i] == 0) return false
        }
        
        return dp[nums.size - 2] >= 1
    }
}

class Solution {
    fun zeroFilledSubarray(nums: IntArray): Long {
        val dp = LongArray(nums.size){0} 
        
        
        for (i in nums.indices) {
            if (nums[i] != 0) continue
            dp[i]++
            
            if (i > 0 && nums[i - 1] == 0) {
                dp[i] += dp[i - 1]
            }
        }
        
        return dp.sum()
    }
}
class Solution {
    fun maxProduct(nums: IntArray): Int {
        val dp = Array(nums.size){ IntArray(2){1} }
        
        if (nums[0] > 0) {
            dp[0][0] = nums[0]
        } else if (nums[0] < 0){
            dp[0][1] = nums[0]
        } else {
            dp[0][0] = 0
            dp[0][1] = 0
        }
        
        var result = nums[0]
        
        for (i in 1 until nums.size) {
            if (nums[i] > 0) {
                dp[i][0] = Math.max(dp[i - 1][0] * nums[i], nums[i])
                dp[i][1] = Math.min(dp[i - 1][1] * nums[i], nums[i])
            } else if (nums[i] < 0){
                dp[i][0] = Math.max(dp[i - 1][1] * nums[i], nums[i])
                dp[i][1] = Math.min(dp[i - 1][0] * nums[i], nums[i])
            } else {
               dp[i][0] = 0
               dp[i][1] = 0
            }
            
            result = Math.max(Math.max(result, dp[i][0]), dp[i][1])
        }
        
        return result
    }
}
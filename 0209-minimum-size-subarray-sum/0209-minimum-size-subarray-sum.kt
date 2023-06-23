class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        val n = nums.size
        var left = 0
        var sum = 0
        var result = Int.MAX_VALUE
        
        for (right in 0 until n) {
            sum += nums[right]
            
            while(left <= right && sum >= target) {
                result = Math.min(result, right - left + 1)
                sum -= nums[left++]
            }
        }
        
        return if (result == Int.MAX_VALUE) 0 else result
    }
}
class Solution {
    fun maxSubarraySumCircular(nums: IntArray): Int {
        var curr = nums[0]
        var result = curr
        
        for (i in 1 until nums.size) {
            curr = Math.max(curr + nums[i], nums[i])
            result = Math.max(result, curr)
        }
        
        var right = nums[nums.size - 1]
        var suffixArray = IntArray(nums.size)
        suffixArray[nums.size - 1] = right
        
        for (i in nums.size - 2 downTo 0) {
            right += nums[i]
            suffixArray[i] = Math.max(suffixArray[i + 1], right)
        }
        
        curr = 0
        for (i in 0 until nums.size - 1) {
            curr += nums[i]
            result = Math.max(curr + suffixArray[i + 1], result)
        }
        
        return result
    }
}
class Solution {
    fun getMaxLen(nums: IntArray): Int {
        var positive = 0
        var negative = 0
        
        if (nums[0] > 0) {
            positive = 1   
        } else if (nums[0] < 0) {
            negative = 1
        }
        
        var result = positive
        
        for (i in 1 until nums.size) {
            if (nums[i] > 0) {
                positive = positive + 1
                negative = if (negative > 0 ) negative + 1 else 0
            } else if (nums[i] < 0) {
                var _positive = positive
                positive = if (negative > 0) negative + 1 else 0
                negative = _positive + 1
            } else {
                positive = 0
                negative = 0
            }
            
            result = Math.max(result, positive)
        }
        
        return result
    }
}
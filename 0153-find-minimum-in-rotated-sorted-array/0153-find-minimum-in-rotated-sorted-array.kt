class Solution {
    fun findMin(nums: IntArray): Int {
        var left = 0
        var right = nums.size - 1
        
        while(left <= right) {
            val mid = left + (right - left)/2
            
            // println("${left} - ${right}")
            
            if (mid > 0 && nums[mid] < nums[mid - 1]) return nums[mid]
            
            if (nums[mid] >= nums[right]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        return nums[0]
    }
}
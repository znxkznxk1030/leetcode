class Solution {
    fun findPeakElement(nums: IntArray): Int {
        if (nums.size == 1) return 0
        if (nums[0] > nums[1]) return 0
        if (nums[nums.size - 1] > nums[nums.size - 2]) return nums.size - 1
        
        var left = 0
        var right = nums.size - 1
        
        while (left <= right) {
            val mid = left + (right - left) / 2
            
            if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid
            
            if (nums[mid + 1] > nums[mid]) {
                left = mid + 1
            } else if (nums[mid + 1] <= nums[mid]) {
                right = mid
            } else if (nums[mid + 1] < nums[mid]) {
                right = mid - 1
            } else {
                left = mid
            }
        }
        
        return 0;
    }
}
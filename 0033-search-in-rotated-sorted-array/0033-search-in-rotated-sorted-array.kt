class Solution {
    fun search(nums: IntArray, target: Int): Int {
        var left = 0
        var right = nums.size - 1
        var pivot = 0
        
        while(left <= right) {
            val mid = left + (right - left) / 2
            
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                pivot = mid
                break
            }
            
            if (nums[mid] > nums[right]) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        if (pivot > 0 && nums[0] <= target && target <= nums[pivot - 1]) {
            left = 0
            right = pivot - 1
        } else {
            left = pivot
            right = nums.size - 1
        }
        
        println("${pivot} | ${left} - ${right}")
        
        while(left <= right) {
            val mid = left + (right - left) / 2
            
            if (nums[mid] == target) {
                return mid
            }
            
            if (nums[mid] < target) {
                left = mid + 1
            } else {
                right = mid - 1
            }
        }
        
        return -1
        
    }
}
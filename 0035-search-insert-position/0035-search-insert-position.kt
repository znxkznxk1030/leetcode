class Solution {
    fun searchInsert(nums: IntArray, target: Int): Int {
        if (nums.size == 0 || target < nums[0]) return 0

        var left: Int = 0
        var right: Int = nums.size


        while (left < right) {
            val mid = left + (right - left) / 2

            if (nums[mid] >= target) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        return left
    }
}
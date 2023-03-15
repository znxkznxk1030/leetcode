class Solution {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        val result = mutableListOf<List<Int>>()
        helper(nums, 0, result)
        return result.distinct()
    }

    fun helper(nums: IntArray, start: Int, result: MutableList<List<Int>>) {
        if (start == nums.size) {
            result.add(nums.toList())
            return
        }

        for (i in start until nums.size) {
            swap(nums, start, i)
            helper(nums, start + 1, result)
            swap(nums,start, i)
        }
    }

    fun swap(nums: IntArray, i: Int, j: Int) {
        nums[i] = nums[j].also{nums[j] = nums[i]}
    }
}
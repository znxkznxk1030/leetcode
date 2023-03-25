class Solution {
    fun jump(nums: IntArray): Int {
        var answer = 0
        var curFur = 0
        var curIdx = 0
        
        for (i in 0 until nums.size - 1) {
            if (nums[i] + i > curFur) {
                curFur = nums[i] + i
            }
            
            if (curIdx == i) {
                curIdx = curFur
                answer++;
            }
        }
        
        return answer
    }
}
class Solution {
    fun jump(nums: IntArray): Int {
        var answer: Int = 0;
        var curEnd: Int = 0;
        var curFur: Int = 0;

        for (i in 0 until nums.size - 1) {
            curFur = Math.max(curFur, i + nums[i]);

            if (curEnd == i) {
                answer++;
                curEnd = curFur;
            }
        }

        return answer;
    }
}
class Solution {
    fun minOperations(nums: IntArray, queries: IntArray): List<Long> {
        val sum = nums.sum().toLong()
        Arrays.sort(nums)
        
        fun lowerBound(v: Int): Int {
            var lo = 0
            var hi = nums.size
            
            while(lo < hi) {
                val mid = lo + (hi - lo) / 2
                
                if (nums[mid] >= v) {
                    hi = mid
                } else {
                    lo = mid + 1
                }
            }
            
            return lo
        }
        
        val dp = LongArray(nums.size){0}
        dp[0] = nums[0].toLong()
        
        for (i in 1 until nums.size) {
            dp[i] = dp[i - 1] + nums[i].toLong()
        }
        
        val result = mutableListOf<Long>()
        
        for (query in queries) {
            var pivot = lowerBound(query)
            
            if (pivot >= nums.size) {
                result.add((query.toLong() * nums.size.toLong()) - dp[nums.size - 1].toLong())
                continue;
            }
            
            if (nums[pivot] != query) {
                pivot--;
            }
            
            if (pivot < 0) {
                result.add(dp[nums.size - 1].toLong() - (query.toLong() * nums.size.toLong()))
                continue;
            }
            
            var answer = 0L
            answer += Math.abs(dp[pivot].toLong() - (query.toLong() * (pivot + 1).toLong()))
            answer += Math.abs((dp[nums.size - 1].toLong() - dp[pivot].toLong()).toLong() - (query.toLong() * (nums.size.toLong() - (pivot + 1).toLong()).toLong()))
            result.add(answer)
        }
        
        
        return result
    }
    
}
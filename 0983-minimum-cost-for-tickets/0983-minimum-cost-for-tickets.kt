class Solution {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val durations = intArrayOf(1, 7, 30)
        val dp = IntArray(days.size){ Int.MAX_VALUE }
        
        fun dfs(i: Int): Int {
            if (i >= days.size) return 0
            if (dp[i] < Int.MAX_VALUE) return dp[i]
            
            for (j in costs.indices) {
                val cost = costs[j]
                val duration = durations[j]
                var k = 0
                
                while(i + k < days.size && days[i + k] - days[i] < duration) k++
                
                dp[i] = Math.min(dp[i], dfs(i + k) + cost)
            }
            
            return dp[i]
        }
        
        return dfs(0)
    }
}
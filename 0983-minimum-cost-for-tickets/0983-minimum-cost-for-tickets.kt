class Solution {
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        val dp = IntArray(days.size + 1){ 99999999 }
        dp[0] = 0
        
        for (i in 1 .. days.size) {
            dp[i] = Math.min(dp[i], dp[i - 1] + Math.min(costs[0], Math.min(costs[1], costs[2])))
            
            for (j in i - 1 downTo 1) {
                val diff = days[i - 1] - days[j - 1]
                if (diff < 7) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + costs[1])
                }
                
                if (diff < 30) {
                    dp[i] = Math.min(dp[i], dp[j - 1] + costs[2])
                }
            }
        }
        
        return dp[days.size]
    }
}
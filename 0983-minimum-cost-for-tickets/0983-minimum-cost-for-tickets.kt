class Solution {
    var costs = IntArray(3)
    var dp = IntArray(366){ -1 }
    var dayset = HashSet<Int>()
    
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        this.costs = costs
        
        days.forEach{ dayset.add(it) }
        
        return dfs(1)
    }
    
    fun dfs(i: Int): Int {
        if (i > 365) return 0
        if (dp[i] > 0) return dp[i]
        
        if (dayset.contains(i)) {
            dp[i] = Math.min(dfs(i + 1) + costs[0], Math.min(dfs(i + 7) + costs[1], dfs(i + 30) + costs[2]))
        } else {
            dp[i] = dfs(i + 1)
        }
        
        return dp[i]
    }
}
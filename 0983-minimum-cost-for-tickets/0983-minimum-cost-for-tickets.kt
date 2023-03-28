class Solution {
    var costs = IntArray(3)
    var dp = IntArray(366){ -1 }
    val dayset = HashSet<Int>()
    
    fun mincostTickets(days: IntArray, costs: IntArray): Int {
        this.costs = costs
        days.forEach{ dayset.add(it) }
        return dfs(1)
    }
    
    fun dfs(day: Int): Int {
        if (day > 365) return 0
        if (dp[day] > 0) return dp[day]
        
        var result: Int
        
        if (dayset.contains(day)) {
            result = Math.min(dfs(day + 1) + costs[0], Math.min(dfs(day + 7) + costs[1], dfs(day + 30) + costs[2]))
        } else {
            result = dfs(day + 1)
        }
        
        dp[day] = result
        return result
    }
}
class Solution {
    fun canCross(stones: IntArray): Boolean {
        val n = stones.size
        val dp = Array(n + 1){ HashSet<Int>() }
        var result = false
        
        dp[1].add(0)
        
        for (i in 2 .. n) {
            val target = stones[i - 1]
            
            for (j in 1 until i) {
                val base = stones[j - 1]
                for (k in dp[j]) {
                    if (base + k - 1 == target) {
                        dp[i].add(k - 1)
                    }
                    
                    if (base + k == target) {
                        dp[i].add(k)
                    }
                    
                    if (base + k + 1 == target) {
                        dp[i].add(k + 1)
                    }
                }
            }
        }
        
        return dp[n].size > 0
    }
}
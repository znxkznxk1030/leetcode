class Solution {
    val MOD = 1_000_000_007
    fun numberOfPermutations(n: Int, requirements: Array<IntArray>): Int {
        val rmap = HashMap<Int, Int>()
        for (req in requirements) {
            rmap[req[0] + 1] = req[1]
        }
        
        val dp = Array(n + 1){ IntArray(401) }
        dp[0][0] = 1
        
        for (i in 1 .. n) {
            for (inv in 0 until 401) {
                for (pos in 0 until i) {
                    if(inv - pos < 0) continue
                    dp[i][inv] += dp[i - 1][inv - pos]
                    dp[i][inv] %= MOD
                }
            }
            
            if (!rmap.containsKey(i)) continue
            for (inv in 0 until 401) {
                if(rmap[i] == inv) continue
                dp[i][inv] = 0
            }
        }
        
        var result = 0
        
        for (i in 0 until 401) {
            result += dp[n][i]
            result %= MOD
        }
        
        return result
    }
}
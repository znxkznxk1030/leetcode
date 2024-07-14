class Solution {
    val mod = 1_000_000_007
    
    fun numberOfPermutations(n: Int, requirements: Array<IntArray>): Int {
        val rmap = HashMap<Int, Int>()
        for (req in requirements) {
            rmap[req[0] + 1] = req[1]
        }
        
        val dp = Array(n + 1){ IntArray(401) }
        dp[0][0] = 1
        
        for(l in 1 .. n) {
            for (inv in 0 until 401) {
                for(pos in 0 until l) {
                    if (inv - pos < 0) continue
                    dp[l][inv] += dp[l - 1][inv - pos]
                    dp[l][inv] %= mod
                }
            }
            
            if(rmap.containsKey(l)) {
                for (inv in 0 until 401) {
                    if(inv == rmap[l]) continue
                    dp[l][inv] = 0
                }
            }
        }
        
        var result = 0
        
        for (m in 0 until 401) {
            result += dp[n][m]
            result %= mod
        }
        
        return result
    }
}
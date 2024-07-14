class Solution {
    val MOD = 1_000_000_007
    fun numberOfPermutations(n: Int, requirements: Array<IntArray>): Int {
        val rmap = HashMap<Int, Int>()
        var max = 0
        for (req in requirements) {
            rmap[req[0] + 1] = req[1]
            max = maxOf(max, req[1])
        }
        
        val dp = Array(n + 1){ IntArray(max + 1) }
        dp[0][0] = 1
        
        for (i in 1 .. n) {
            for (inv in 0 .. max) {
                for (pos in 0 until i) {
                    if(inv - pos < 0) continue
                    dp[i][inv] += dp[i - 1][inv - pos]
                    dp[i][inv] %= MOD
                }
            }
            
            if (!rmap.containsKey(i)) continue
            for (inv in 0 .. max) {
                if(rmap[i] == inv) continue
                dp[i][inv] = 0
            }
        }
        
        var result = 0
        
        for (i in 0 .. max) {
            result += dp[n][i]
            result %= MOD
        }
        
        return result
    }
}
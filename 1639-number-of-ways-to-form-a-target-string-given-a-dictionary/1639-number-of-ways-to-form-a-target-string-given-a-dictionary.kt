class Solution {
    fun numWays(words: Array<String>, target: String): Int {
        val mod = 1_000_000_007
        val n = words[0].length
        val amap = Array(n + 1){ IntArray(27) }
        
        for (word in words) {
            for (i in 0 until word.length) {
                val ch = word[i]
                amap[i][ch - 'a']++
            }
        }
        
        var result = 0
        
        val t = target.length
        val dp = Array(n + 1){ IntArray(t + 1) }
        
        for (i in 1 .. n) {
            for (j in 0 until t) {
                dp[i][j] = (dp[i][j] + dp[i - 1][j]) % mod
                
                if (j >= t) continue
                
                val ch = target[j] - 'a'
                if (j == 0) {
                    dp[i][j] = (dp[i][j] + amap[i - 1][ch]) % mod
                } else {
                    dp[i][j] = (dp[i][j] + (dp[i - 1][j - 1].toLong() * amap[i - 1][ch].toLong() % mod.toLong()).toInt()) % mod
                }
            }
        }
        
        return dp[n][t - 1]
    }
}
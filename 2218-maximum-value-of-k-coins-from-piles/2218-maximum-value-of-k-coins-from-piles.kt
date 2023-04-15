class Solution {
    fun maxValueOfCoins(piles: List<List<Int>>, k: Int): Int {
        val n = piles.size
        val m = piles[0].size
        val dp = Array(n + 1){ IntArray(2345){ 0 } }
        
        var result = 0
        
        for (i in 1 .. n) {
            val acc = IntArray(k + 1){ 0 }
            for (j in 1 .. k) {
                acc[j] = acc[j - 1] + if (j <= piles[i - 1].size) piles[i - 1][j - 1] else 0
                
                for (d in 0 .. j) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][d] + acc[j - d])
                }
                
                result = Math.max(dp[i][Math.min(j, k)], result)
            }
        }
        
        
        return result
    }
}
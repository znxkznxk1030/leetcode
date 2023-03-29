class Solution {
    fun maxSatisfaction(satisfaction: IntArray): Int {
        Arrays.sort(satisfaction)
        
        val dp = Array(satisfaction.size + 1){ IntArray(satisfaction.size + 1){0} }
        var result = 0
        for (i in 1 .. satisfaction.size) {
            for (j in 1 .. i) {
                dp[i][j] = dp[i - 1][j - 1] + satisfaction[i - 1] * j
                result = Math.max(result, dp[i][j])
            }
        }
        
        return result
    }
}
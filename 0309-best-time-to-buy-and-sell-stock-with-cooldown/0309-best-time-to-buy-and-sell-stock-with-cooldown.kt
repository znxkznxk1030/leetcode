class Solution {
    fun maxProfit(prices: IntArray): Int {
        if (prices.size <= 1 ) return 0
        val dp = IntArray(prices.size + 1){ 0 }
        dp[1] = Math.max(0, prices[1] - prices[0])
        
        for (i in 2 until prices.size) {
            dp[i] = Math.max(dp[i - 1], Math.max(prices[i] - prices[0], prices[i] - prices[1]))
            for(j in 2 until i) {
                dp[i] = Math.max(dp[i], dp[j - 2] + prices[i] - prices[j])
            }
        }
        
        return dp[prices.size - 1]
    }
}


class Solution {
    fun maxProfit(prices: IntArray): Int {
        var result = 0
        var curr = prices[0]
        
        for (price in prices) {
            if (price < curr) {
                curr = price
            }
            
            result = Math.max(result, price - curr)
        }
        
        return result
    }
}
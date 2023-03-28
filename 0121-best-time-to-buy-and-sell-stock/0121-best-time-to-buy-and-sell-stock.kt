class Solution {
    fun maxProfit(prices: IntArray): Int {
        var result = 0
        var curr = Int.MAX_VALUE
        
        for (price in prices) {
            if (price < curr) {
                curr = price
            }
            
            result = Math.max(result, price - curr)
        }
        
        return result
    }
}
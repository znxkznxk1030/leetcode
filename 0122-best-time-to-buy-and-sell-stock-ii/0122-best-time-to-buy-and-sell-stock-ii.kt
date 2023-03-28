class Solution {
    fun maxProfit(prices: IntArray): Int {
        var lo = Int.MAX_VALUE
        var result = 0
        
        for (price in prices) {
            if (price > lo) {
                result += price - lo
            }
            
            lo = price
        }
        
        return result
    }
}
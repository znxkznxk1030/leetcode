class Solution {
    fun diagonalPrime(nums: Array<IntArray>): Int {
        var result = 0
        
        for (i in 0 until nums.size) {
            if(isPrime(nums[i][i])) {
                result = Math.max(result, nums[i][i])
            }
            
            if (isPrime(nums[nums.size - i - 1][i])) {
                result = Math.max(result, nums[nums.size - i - 1][i])
            }
        }
        
        return result
    }
    
    fun isPrime(num: Int): Boolean {
        if (num == 1) return false
        for (i in 2 .. Math.sqrt(num.toDouble()).toInt()) {
            if (num % i == 0) return false
        }
        return true
    }
}
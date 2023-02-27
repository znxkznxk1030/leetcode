class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        
        var low = 0
        var high = matrix.size - 1
        
        while (low < high) {
            val mid = low + (high - low) / 2
            val v = matrix[mid][matrix[mid].size - 1]
            
            if (v >= target) {
                high = mid
            } else {
                low = mid + 1
            }
        }
        
        var arr = matrix[low]
        var left = 0
        var right = arr.size - 1
            
        while (left <= right) {
            val mid = left + (right - left) / 2
                
            if (arr[mid] == target) return true
                
            if (arr[mid] > target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        
        
        
        return false
    }
}
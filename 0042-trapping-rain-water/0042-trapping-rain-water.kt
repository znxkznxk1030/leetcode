class Solution {
    fun trap(height: IntArray): Int {
        val left = IntArray(height.size)
        val right = IntArray(height.size)
        
        left[0] = height[0]
        for (i in 1 until height.size) {
            left[i] = Math.max(height[i], left[i - 1])
        }
        
        right[height.size - 1] = height[height.size - 1]
        for (i in height.size - 2 downTo 0) {
            right[i] = Math.max(height[i], right[i + 1])
        }
        
        var result = 0
        for (i in height.indices) {
            result += Math.min(left[i], right[i]) - height[i]
        }
        
        return result
    }
}
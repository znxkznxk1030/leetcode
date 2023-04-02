class Solution {
    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        Arrays.sort(potions)
        
        fun lowerBound(arr: IntArray, target: Long, spell: Int): Int {
            var left = 0
            var right = arr.size
            
            while (left < right) {
                val mid = left + (right - left) / 2
                
                if (arr[mid].toLong() * spell.toLong() < target) {
                    left = mid + 1
                } else {
                    right = mid
                }
            }
            
            return left
        }
        
        return spells
            .map{ if ((success/it.toLong()) > Int.MAX_VALUE.toLong()) potions.size 
                else lowerBound(potions, success, it) }
            .map{ Math.max(0, potions.size - it) }
            .toIntArray()
    }
}
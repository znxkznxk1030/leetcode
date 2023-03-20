class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var numOfPlace = 0
        
        for (i in flowerbed.indices) {
            val f = flowerbed[i]
            
            if (f == 1) continue
            
            if ((i == 0 || flowerbed[i - 1] == 0) && (i == flowerbed.size - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1
                numOfPlace++
            }
        }
        
        return numOfPlace >= n
    }
}
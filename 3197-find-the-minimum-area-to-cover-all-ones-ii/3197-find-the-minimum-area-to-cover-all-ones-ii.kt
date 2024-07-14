class Solution {
    fun minimumSum(grid: Array<IntArray>): Int {
        val h = grid.size
        val w = grid[0].size
        
        fun getMin(a: Int, b: Int, c: Int, d: Int): Int {
            var hs = 99999
            var he = 0
            var vs = 99999
            var ve = 0
            
            // println("$a $c | $b $d")
        
            for (i in b .. d) {
                for (j in a .. c) {
                    if (grid[i][j] == 1) {
                        hs = minOf(hs, j)
                        he = maxOf(he, j)
                    
                        vs = minOf(vs, i)
                        ve = maxOf(ve, i)
                    }
                }
            }
        
            if (hs == 99999) return 99999
            return (ve - vs + 1) * (he - hs + 1)
        }
        
        var result = Int.MAX_VALUE
        // 1
        for (i in 0 until w - 1) {
            for (j in 0 until h - 1) {
                var temp = 0
                
                temp += getMin(0, 0, i, j)
                temp += getMin(0, j + 1, i, h - 1)
                temp += getMin(i + 1, 0, w - 1, h - 1)
                
                // println("1 $temp ($i $j)")
                result = minOf(result, temp)
                // println("1 $temp $result ($i $j)")
            }
        }
        
        // 2
        for (i in 0 until w - 1) {
            for (j in 0 until h - 1) {
                var temp = 0
                
                temp += getMin(0, 0, w - 1, j)
                temp += getMin(0, j + 1, i, h - 1)
                temp += getMin(i + 1, j + 1, w - 1, h - 1)
                
                // println("2 $temp")
                result = minOf(result, temp)
                // println("2 $temp $result ($i $j)")
            }
        }
        
        // 3
        for (i in 0 until w - 1) {
            for (j in 0 until h - 1) {
                var temp = 0
                
                temp += getMin(0, 0, i, h - 1)
                // println(temp)
                temp += getMin(i + 1, 0, w - 1, j)
                // println(temp)
                temp += getMin(i + 1, j + 1, w - 1, h - 1)
                // println(temp)
                
                // println("3 $temp ($i $j)")
                result = minOf(result, temp)
                // println("3 $temp $result ($i $j)")
            }
        }
        
        // 4
        for (i in 0 until w - 1) {
            for (j in 0 until h - 1) {
                var temp = 0
                
                temp += getMin(0, 0, i, j)
                temp += getMin(i + 1, 0, w - 1, j)
                temp += getMin(0, j + 1, w - 1, h - 1)
                // println("4 $temp ($i $j)")
                
                result = minOf(result, temp)
                // println("4 $temp $result ($i $j)")
            }
        }
        
        // 5
        for (i in 0 until w - 2) {
            for (j in i + 1 until w - 1) {
                var temp = 0
                temp += getMin(0, 0, i, h - 1)
                temp += getMin(i + 1, 0, j, h - 1)
                temp += getMin(j + 1, 0, w - 1, h - 1)
                
                result = minOf(result, temp)
                // println("5 $temp $result ($i $j)")
            }
        }
        
        // 6
        for (i in 0 until h - 2) {
            for (j in i + 1 until h - 1) {
                var temp = 0
                
                temp += getMin(0, 0, w - 1, i)
                temp += getMin(0, i + 1, w - 1, j)
                temp += getMin(0, j + 1, w - 1, h - 1)
                
                result = minOf(result, temp)
                // println("6 $temp $result ($i $j)")
            }
        }
        
        return result
    }
}
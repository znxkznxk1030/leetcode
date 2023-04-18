class Solution {
    fun isPrintable(targetGrid: Array<IntArray>): Boolean {
        fun isRectangle(d: Int): Boolean {
            var top = Int.MIN_VALUE
            var bottom = Int.MAX_VALUE
            var left = Int.MAX_VALUE
            var right = Int.MIN_VALUE
            
            for (r in targetGrid.indices) {
                for (c in targetGrid[0].indices) {
                    if (targetGrid[r][c] == d) {
                        top = Math.max(top, r)
                        bottom = Math.min(bottom, r)
                        
                        left = Math.min(left, c)
                        right = Math.max(right, c)
                    }                    
                }
            }
            
            for (h in bottom .. top) {
                for(w in left .. right) {
                    if (targetGrid[h][w] != d && targetGrid[h][w] != -1) return false
                }
            }
            
            return top > Int.MIN_VALUE
        }
        
        val n = targetGrid.flatMap{it -> it.toList()}.max() ?: 0
        val h = targetGrid.size
        val w = targetGrid[0].size
        
        val q = LinkedList<Int>()
        val visit = BooleanArray(n + 1){ false }
        
        val directs = arrayOf(
            intArrayOf(-1, -1),
            intArrayOf(0, -1),
            intArrayOf(1, -1),
            
            intArrayOf(-1, 0),
            intArrayOf(1, 0),
            
            intArrayOf(-1, 1),
            intArrayOf(0, 1),
            intArrayOf(1, 1)
        )
        
        for (i in 0..n) {
            if (isRectangle(i)) {
                q.offer(i)
            }
        }
        
        while(!q.isEmpty()) {
            val curr = q.poll()
            visit[curr] = true
            
            val candidates = HashSet<Int>()
            
            for (r in targetGrid.indices) {
                for (c in targetGrid[0].indices) {
                    if (targetGrid[r][c] == curr) {
                        for (direct in directs) {
                            val nc = c + direct[0]
                            val nr = r + direct[1]
                        
                            if (nr >=0 && nr < h
                                && nc >= 0 && nc < w 
                                && targetGrid[nr][nc] >= 0) {
                                
                                candidates.add(targetGrid[nr][nc])
                            }
                        }
                        targetGrid[r][c] = -1
                    }
                }
            }
            
            for (c in candidates) {
                if (!visit[c] && isRectangle(c)) {
                    q.offer(c)
                    visit[c] = true
                }
            }
        }
        
        for (i in 0..n) {
            if (isRectangle(i)) {
                q.offer(i)
            }
        }
        
        while(!q.isEmpty()) {
            val curr = q.poll()
            visit[curr] = true
            
            val candidates = HashSet<Int>()
            
            for (r in targetGrid.indices) {
                for (c in targetGrid[0].indices) {
                    if (targetGrid[r][c] == curr) {
                        for (direct in directs) {
                            val nc = c + direct[0]
                            val nr = r + direct[1]
                        
                            if (nr >=0 && nr < h
                                && nc >= 0 && nc < w 
                                && targetGrid[nr][nc] >= 0) {
                                
                                candidates.add(targetGrid[nr][nc])
                            }
                        }
                        targetGrid[r][c] = -1
                    }
                }
            }
            
            for (c in candidates) {
                if (!visit[c] && isRectangle(c)) {
                    q.offer(c)
                    visit[c] = true
                }
            }
        }
        
        
        return !targetGrid.flatMap{it -> it.toList()}.any{ it != -1 }
    }
}
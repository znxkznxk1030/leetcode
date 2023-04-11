class Solution {
    fun longestIncreasingPath(matrix: Array<IntArray>): Int {
        val m = matrix.size
        val n = matrix[0].size
        val adj = Array(m*n){ mutableListOf<Int>() }
        val indegree = IntArray(m*n){ 0 }
        val directs = arrayOf(intArrayOf(1, 0), intArrayOf(-1, 0), intArrayOf(0, -1), intArrayOf(0, 1))
        
        for (r in 0 until m) {
            for (c in 0 until n) {
                val node = n * r + c
                
                for (direct in directs) {
                    val nr = r + direct[0]
                    val nc = c + direct[1]
                    
                    if (nr < 0 || nr >= m) continue
                    if (nc < 0 || nc >= n) continue
                    
                    if (matrix[nr][nc] > matrix[r][c]) {
                        val next = n * nr + nc
                        adj[node].add(next)
                        indegree[next]++
                    }
                }
            }
        }
        
        var q = LinkedList<Int>()
        
        for (i in 0 until m*n) {
            if (indegree[i] == 0) {
                q.offer(i)
            }
        }
        
        var result = 0
        while(!q.isEmpty()) {
            result++
            val nq = LinkedList<Int>()
            while(!q.isEmpty()) {
                val node = q.poll()
                for (next in adj[node]) {
                    indegree[next]--
                    if (indegree[next] == 0) {
                        nq.offer(next)
                    }
                }
            }
            
            q = nq
        }
        
        return result
    }
}
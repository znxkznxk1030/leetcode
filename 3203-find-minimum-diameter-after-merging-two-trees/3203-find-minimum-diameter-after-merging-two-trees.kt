class Solution {
    
    fun minimumDiameterAfterMerge(edges1: Array<IntArray>, edges2: Array<IntArray>): Int {
        var result = 0
        
        fun getDist(edges: Array<IntArray>): Int {
            val n = edges.size
            val degrees = IntArray(n + 2)
            val adj = HashMap<Int, MutableList<Int>>()
            
            for (edge in edges) {
                val u = edge[0]
                val v = edge[1]
                
                adj.computeIfAbsent(u){ mutableListOf<Int>() }.add(v)
                adj.computeIfAbsent(v){ mutableListOf<Int>() }.add(u)
                
                degrees[u] += 1
                degrees[v] += 1
            }
            
            var q = LinkedList<Int>()
            for (i in 0 .. n) {
                if (degrees[i] == 1) {
                    q.offer(i)
                }
            }
            
            var visit = HashSet<Int>()
            
            while(q.isNotEmpty() && q.size > 1) {
                val curr = q.poll()
                visit.add(curr)
                
                for (next in adj.getOrDefault(curr, mutableListOf<Int>())) {
                    if (visit.contains(next)) continue
                    degrees[next] -= 1
                    if (degrees[next] == 1) {
                        q.offer(next)
                        visit.add(next)
                    }
                }
            }
            
            val root = q.poll()
            
            q = LinkedList<Int>()
            q.offer(root)
            
            visit = HashSet<Int>()
            var dist = 0
            
            while(q.isNotEmpty()) {
                val nq = LinkedList<Int>()
                dist += 1
                while(q.isNotEmpty()) {
                    val curr = q.poll()
                    if(visit.contains(curr)) continue
                    visit.add(curr)
                    
                    for (next in adj.getOrDefault(curr, mutableListOf<Int>())) {
                        // println("$curr -> $next")
                        if (visit.contains(next)) continue
                        nq.offer(next)
                    }
                }
                // println(nq)
                q = nq
            }
            
            visit.clear()
            fun dfs(curr: Int): Int {
                if (visit.contains(curr)) return 0
                visit.add(curr)
                
                var ret = 0
                
                for (next in adj.getOrDefault(curr, mutableListOf<Int>())) {
                    // println("$curr -> $next")
                    if (visit.contains(next)) continue
                    
                    ret = maxOf(ret, dfs(next))
                }
                
                return ret + 1
            }
            
            
            visit.add(root)
            var sorted = mutableListOf<Int>()
            // println("$root")
            for (next in adj.getOrDefault(root, mutableListOf<Int>())) {
                var q = dfs(next)
                // println("\t\t$next $q")
                sorted.add(q)
            }
            
            sorted.sort()
            
            if (sorted.size >= 2) {
                // println(sorted)
                result = maxOf(result, sorted[sorted.size - 1] + sorted[sorted.size - 2])
            }
            
            // println("$root - ${dist}")
            return dist - 1
        }
        // println()
        var d1 = getDist(edges1)
        var d2 = getDist(edges2)
        result = maxOf(result, d1 + d2 + 1)
        return result
    }
}
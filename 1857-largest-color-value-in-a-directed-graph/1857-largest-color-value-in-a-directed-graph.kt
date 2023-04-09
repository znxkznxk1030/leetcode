class Solution {
    fun largestPathValue(colors: String, edges: Array<IntArray>): Int {
        val n = colors.length
        val adj = HashMap<Int, MutableList<Int>>()
        val indegree = IntArray(n){ 0 }
        
        for (edge in edges) {
            adj.computeIfAbsent(edge[0]){ mutableListOf<Int>() }.add(edge[1])
            indegree[edge[1]]++
        }
        
        val count = Array(n){ IntArray(26) }
        val q = LinkedList<Int>()
        
        for (i in 0 until n) {
            if (indegree[i] == 0) {
                q.offer(i)
            }
        }
        
        var result = 1
        var nodesSeen = 0
        
        while(!q.isEmpty()) {
            val curr = q.poll()
            result = Math.max(result, ++count[curr][colors[curr] - 'a'])
            nodesSeen++
            
            if (!adj.containsKey(curr)) continue
            
            for (neighbor in adj.get(curr)!!) {
                for (i in 0..25) {
                    count[neighbor][i] = Math.max(count[neighbor][i], count[curr][i])
                }
                
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor)
                }
            }
            
        }
        
        
        return if ( nodesSeen < n ) -1 else result
    }
}
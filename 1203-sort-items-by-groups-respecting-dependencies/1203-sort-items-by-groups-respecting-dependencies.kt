class Solution {
    fun sortItems(n: Int, m: Int, group: IntArray, beforeItems: List<List<Int>>): IntArray {
        val graph = Array(n){ mutableListOf<Int>() }
        val indegree = IntArray(n){ 0 }
        
        val gGraph = Array(m + n + 1){ mutableListOf<Int>() }
        val gIndegree = IntArray(m + n + 1){ 0 }
        var _m = m
        
        val _group = group.map{ if(it == -1) _m++ else it }
        
        for (v in beforeItems.indices) {
            for (u in beforeItems[v]) {
                graph[u].add(v)
                indegree[v]++
                
                var gu = _group[u]
                var gv = _group[v]
                
                if (gu != gv) {
                    gGraph[gu].add(gv)
                    gIndegree[gv]++
                }
            }
        }
        
        val itemSorted = kahn(graph, indegree)
        val groupSorted = kahn(gGraph, gIndegree)
        
        val gtoi = HashMap<Int, MutableList<Int>>()
        itemSorted.forEach{ gtoi.computeIfAbsent(_group[it]){ mutableListOf<Int>() }.add(it) }
        
        val result = mutableListOf<Int>()
        
        for( g in groupSorted) {
            result.addAll(gtoi.getOrDefault(g, mutableListOf<Int>()))
        }
        
        return result.toIntArray()
    }
    
    fun kahn(graph: Array<MutableList<Int>>, indegree: IntArray): IntArray {
        val queue = LinkedList<Int>()
        
        for(i in indegree.indices) {
            if (indegree[i] == 0) queue.offer(i)
        }
        
        val result = mutableListOf<Int>()
        
        while(!queue.isEmpty()) {
            val curr = queue.poll()
            result.add(curr)
            
            for (next in graph[curr]) {
                if (--indegree[next] == 0) {
                    queue.offer(next)
                }
            }
        }
        
        if (indegree.size != result.size) return intArrayOf()
        
        return result.toIntArray()
    }
}
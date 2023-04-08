/**
 * Definition for a Node.
 * class Node(var `val`: Int) {
 *     var neighbors: ArrayList<Node?> = ArrayList<Node?>()
 * }
 */

class Solution {
    val visit = HashMap<Int, Node>()
    
    fun cloneGraph(node: Node?): Node? {
        if (node == null) return null
        if (visit.containsKey(node.`val`)) return visit.get(node.`val`)
        val clone = Node(node.`val`)
        visit.put(clone.`val`, clone)
        
        for (neighbor in node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor))
        }
        return clone
    }
}
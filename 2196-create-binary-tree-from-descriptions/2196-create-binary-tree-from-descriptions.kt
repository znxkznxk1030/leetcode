/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
        val tmap = HashMap<Int, TreeNode>()
        val degree = HashSet<Int>()
        
        for (des in descriptions) {
            val parent = des[0]
            val node = des[1]
            
            tmap.computeIfAbsent(parent){ TreeNode(parent) }
            tmap.computeIfAbsent(node){ TreeNode(node) }
            
            val pnode = tmap.get(parent)!!
            val cnode = tmap.get(node)!!
            if( des[2] == 1) pnode.left = cnode
            else pnode.right = cnode
            
            degree.add(node)
        }
        
        for ((k, v) in tmap) {
            if ( !degree.contains(k) ) return v
        }
        
        return null
    }
}
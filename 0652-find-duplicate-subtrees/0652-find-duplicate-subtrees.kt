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
    val map: MutableMap<String, MutableList<TreeNode>> = mutableMapOf()
    
    fun findDuplicateSubtrees(root: TreeNode?): List<TreeNode?> {
        preorder(root)
        
        val result: MutableList<TreeNode?> = mutableListOf()
        
        for((k, v) in map) {
            if (v.size >= 2) {
                result.add(v.get(0))
            }
        }
        
        return result
    }
    
    fun preorder(head: TreeNode?): String {
        if(head == null) return ""
        val shape = "< ${preorder(head.left)} ${head.`val`} ${preorder(head.right)} >".trim()
        
        map.computeIfAbsent(shape){ it -> mutableListOf() } += head
        return shape
    }
}
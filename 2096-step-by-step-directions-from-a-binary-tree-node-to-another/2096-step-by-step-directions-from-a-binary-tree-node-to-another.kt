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
    fun getDirections(root: TreeNode?, startValue: Int, destValue: Int): String {
        val lca = findLCA(root, startValue, destValue)
        
        var left = Stack<String>()
        findPath(lca, startValue, left)
        var right = Stack<String>()
        findPath(lca, destValue, right)
        
        val result = "U".repeat(left.size) + right.joinToString("")
        
        return result
    }
    
    fun findLCA(node: TreeNode?, v1: Int, v2: Int): TreeNode? {
        if (node == null) return null
        
        if (node.`val` == v1 || node.`val` == v2) return node
        
        val left = findLCA(node.left, v1, v2)
        val right = findLCA(node.right, v1, v2)
        
        if (right == null) return left
        if (left == null) return right
        
        return node
    }
    
    fun findPath(node: TreeNode?, target: Int, path: Stack<String>): Boolean {
        if (node == null) return false
        if (node.`val` == target) return true
        
        path.push("L")
        if(findPath(node.left, target, path)) {
            return true
        }
        path.pop()
        
        path.push("R")
        if(findPath(node.right, target, path)) {
            return true
        }
        path.pop()
        
        return false
    }
}
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
        
        return "U".repeat(left.size) + right.joinToString("")
    }
    
    fun findLCA(node: TreeNode?, v1: Int, v2: Int): TreeNode? {
        if (node == null) return null
        if (node.`val` == v1 || node.`val` == v2) return node
        
        val leftLCA = findLCA(node.left, v1, v2)
        val rightLCA = findLCA(node.right, v1, v2)
        
        if (leftLCA == null) return rightLCA
        else if (rightLCA == null) return leftLCA
        else return node
    }
    
    fun findPath(node: TreeNode?, v: Int, stack: Stack<String>): Boolean {
        if (node == null) return false
        if (node.`val` == v) return true
        
        stack.push("L")
        if (findPath(node.left, v, stack)) {
            return true
        }
        stack.pop()
        
        stack.push("R")
        if (findPath(node.right, v, stack)) {
            return true
        }
        stack.pop()
        
        return false
    }
}
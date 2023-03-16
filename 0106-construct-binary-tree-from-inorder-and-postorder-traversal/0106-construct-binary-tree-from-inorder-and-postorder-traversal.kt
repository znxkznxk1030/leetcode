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
    fun buildTree(inorder: IntArray, postorder: IntArray): TreeNode? {
        if (postorder.size == 1) return TreeNode(postorder.last())
        if (postorder.size == 0) return null
        
        val root = TreeNode(postorder.last())
        val idx = inorder.indexOf(postorder.last())
        
        if (idx >= 0) {
            root.left = buildTree(inorder.copyOfRange(0, idx), postorder.copyOfRange(0, idx))
            root.right = buildTree(inorder.copyOfRange(idx + 1, inorder.size), postorder.copyOfRange(idx, postorder.size - 1))
        }
        
        return root
    }
}
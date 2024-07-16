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
        if(root == null) return ""
        
        val parents = HashMap<Int, Pair<TreeNode?, Int>>()
        var s: Pair<TreeNode?, Int> = Pair(root, -1)
        var d: Pair<TreeNode?, Int> = Pair(root, -1)
        
        fun findParent(node: TreeNode?, depth: Int) {
            if(node == null) return
            
            if(node.`val` == startValue) s = Pair(node, depth)
            if(node.`val` == destValue) d = Pair(node, depth)
            
            if (node.left != null) {
                parents.put(node.left?.`val` ?: -1, Pair(node, depth))
                findParent(node.left, depth + 1)
            }
            
            if (node.right != null) {
                parents.put(node.right?.`val` ?: -1, Pair(node, depth))
                findParent(node.right, depth + 2)
            }
        }
        
        parents.put(root.`val`, Pair(root, 0))
        findParent(root, 0)
        
        // println(parents)

        var result = ""
        
        var commonParent = root
        var left = ""
        var right = ""
        
        // println("$s $d")
        
        while (s != d) {
            // println("$s $d")
            if (s.second > d.second) {
                s = parents.get(s.first!!.`val`)!!
                left += "U"
            } else {
                var prev = d.first
                d = parents.get(d.first!!.`val`)!!
                val curr = d.first
                if (curr?.left == prev) {
                    right += "L"
                }
                
                if (curr?.right == prev) {
                    right += "R"
                }
            }
        }
        
        // println(left)
        // println(right)
        
        return left + right.reversed()
    }
}


















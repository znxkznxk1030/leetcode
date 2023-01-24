/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Stack<TreeNode> ls = new Stack<>();
        Stack<TreeNode> rs = new Stack<>();
        
        ls.add(root.left);
        rs.add(root.right);
        
        while(!ls.isEmpty() || !rs.isEmpty()) {
            if (ls.isEmpty() && !rs.isEmpty()) return false;
            if (rs.isEmpty() && !ls.isEmpty()) return false;
            
            TreeNode left = ls.pop();
            TreeNode right = rs.pop();
            
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            
            left.val = right.val = Integer.MIN_VALUE;
            
            ls.push(left.left);
            ls.push(left.right);
            
            rs.push(right.right);
            rs.push(right.left);
        }
        
        return true;
    }
}
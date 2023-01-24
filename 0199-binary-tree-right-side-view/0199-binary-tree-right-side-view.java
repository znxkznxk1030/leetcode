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

class TreeNodeLevel {
    int level;
    boolean visit;
    TreeNode treeNode;
    
    TreeNodeLevel(TreeNode node, int level) {
        this.level = level;
        this.treeNode = node;
        
        this.visit = false;
    }
}

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        
        Stack<TreeNodeLevel> stack = new Stack<>();
        
        stack.push(new TreeNodeLevel(root, 0));
        
        while(!stack.isEmpty()) {
            TreeNodeLevel curr = stack.pop();
            TreeNode node = curr.treeNode;
            if (result.size() == curr.level) {
                result.add(node.val);
            }
            
            if (node.left != null) {
                stack.push(new TreeNodeLevel(node.left, curr.level + 1));
            }
            
            if (node.right != null) {
                stack.push(new TreeNodeLevel(node.right, curr.level + 1));
            }
        }
        
        return result;
    }
}
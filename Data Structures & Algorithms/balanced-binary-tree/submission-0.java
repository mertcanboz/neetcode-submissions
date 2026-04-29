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
    boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        dfs(root, 1);
        return balanced;
    }

    private int dfs(TreeNode node, int depth) {
        if (!balanced) return depth - 1;
        if (node == null) return depth - 1;

        int left = dfs(node.left, depth+1);
        int right = dfs(node.right, depth+1);
        if (Math.abs(left - right) > 1) {
            balanced = false;
        }
        return Math.max(left, right);
    }
}

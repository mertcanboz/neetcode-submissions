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
    int goodNodez = 0;
    public int goodNodes(TreeNode root) {
        dfs(root, Integer.MIN_VALUE);
        return goodNodez;
    }

    private void dfs(TreeNode node, int maxValue) {
        if (node == null)
            return;
        if (node.val >= maxValue) {
            goodNodez++;
        }
        dfs(node.left, Math.max(maxValue, node.val));
        dfs(node.right, Math.max(maxValue, node.val));
    }
}

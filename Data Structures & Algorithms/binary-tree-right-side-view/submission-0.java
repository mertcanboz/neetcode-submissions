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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        
        queue.add(root);

        while (!queue.isEmpty()) {
            int lastNodeValue = Integer.MAX_VALUE;
            for (int i=queue.size()-1; i>=0; i--) {
                TreeNode node = queue.poll();
                if (node != null) {
                    queue.add(node.left);
                    queue.add(node.right);
                    lastNodeValue = node.val;
                }
            }
            if (lastNodeValue != Integer.MAX_VALUE)
                result.add(lastNodeValue);
        }

        return result;
    }
}

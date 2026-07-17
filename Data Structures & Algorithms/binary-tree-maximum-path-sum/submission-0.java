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
    int result = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        if (root == null){
            return 0;
        }
        dfs(root);
        return result;
    }

    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = dfs(node.left);
        int right = dfs(node.right);

        int best = Math.max(node.val, node.val + left);
        best = Math.max(best, node.val + right);
        best = Math.max(best, node.val + left + right);
        result = Math.max(result, best);
        return Math.max(node.val, Math.max(node.val+left, node.val+right));
    }
}

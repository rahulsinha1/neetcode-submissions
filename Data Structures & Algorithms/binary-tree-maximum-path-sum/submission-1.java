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
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxPath;
    }

    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }

        int leftSum = dfs(node.left);
        int rightSum = dfs(node.right);

        int nodeValue = node.val;

        int left  = Math.max(leftSum, 0);   // if a side is negative, don't take it
        int right = Math.max(rightSum, 0);
        maxPath = Math.max(maxPath, nodeValue + left + right);

        return nodeValue+ Math.max(left, right);
    }
}

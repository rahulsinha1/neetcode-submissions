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
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        // int leftDepth = maxDepth(root.left);
        // int rightDepth = maxDepth(root.right);

        // return 1+Math.max(leftDepth, rightDepth);

        Deque<TreeNode> queue = new ArrayDeque<>();
        int depth = 0;

        queue.offer(root);

        while(!queue.isEmpty()){
            int level = queue.size();

            for(int i = 0; i<level;i++){
                TreeNode current = queue.pop();
                if (current.left != null)  queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            depth++;
        }
        return depth;
    }
}

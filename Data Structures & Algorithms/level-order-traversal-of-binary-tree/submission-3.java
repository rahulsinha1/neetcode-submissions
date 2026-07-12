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
    public List<List<Integer>> levelOrder(TreeNode root) {

        Deque<TreeNode> queue = new ArrayDeque<>();

        List<List<Integer>> result = new ArrayList<>();

        if(root == null){
            return result;
        }
        queue.add(root);
        while (!queue.isEmpty()){
            int levelSize = queue.size();
            List<Integer> levelNodes = new ArrayList<>();
            for(int i =0;i<levelSize;i++){

                TreeNode current = queue.pop();
                levelNodes.add(current.val);
                if (current.left!=null) queue.add(current.left);
                if (current.right!=null) queue.add(current.right);
                
            }
            result.add(levelNodes);
        }
        return result;
    }
}

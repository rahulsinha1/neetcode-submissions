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
    Map<Integer, Integer> map = new HashMap<>();
    int preorderIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i =0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return createTree(preorder, 0, inorder.length-1);
    }

    private TreeNode createTree(int [] preorder, int low, int high){

        if(low>high){
            return null;
        }
        TreeNode node = new TreeNode(preorder[preorderIndex]);
        int mid = map.get(preorder[preorderIndex++]);

        node.left = createTree(preorder, low, mid-1);
        node.right = createTree(preorder, mid+1, high);

        return node;
    }
}

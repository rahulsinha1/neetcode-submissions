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
    private int preIdx = 0;
    Map<Integer, Integer> inorderIndex = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0 ||
        inorder.length != preorder.length){
            return null;
        }

        for (int i =0; i<inorder.length;i++){
            inorderIndex.put(inorder[i],i);
        }

        return createTree(preorder, 0, preorder.length-1);
    }

    private TreeNode createTree(int [] preorder, int inorderLow, int inorderHigh){

        if(inorderLow>inorderHigh){
            return null;
        }

        int nodeVal = preorder[preIdx];
        TreeNode node = new TreeNode(nodeVal);
        preIdx++;

        node.left = createTree(preorder,inorderLow, inorderIndex.get(nodeVal)-1);
        node.right = createTree(preorder,inorderIndex.get(nodeVal)+1, inorderHigh );

        return node;
    }
}

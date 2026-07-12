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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {

        if (root == null && subRoot ==null){
            return true;
        }
        if (root == null && subRoot !=null){
            return false;
        }

        if(sameTree(root, subRoot) || isSubtree(root.left, subRoot) 
        || isSubtree(root.right, subRoot)){
            return true;
        }
        return false;
    }

    private boolean sameTree(TreeNode p, TreeNode q){

        if(p == null && q == null){
            return true;
        }

        if(p== null || q == null){
            return false;
        }

        if(p.val != q.val){
            return false;
        }

        if(!sameTree(p.left, q.left)){
            return false;
        }

        if(!sameTree(p.right, q.right)){
            return false;
        }

        return true;
    }
}

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

public class Codec {
    StringBuilder sb = new StringBuilder();
    int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        dfs(root);
        return sb.toString();
    }

    private void dfs(TreeNode node){
        if (node == null){
            sb.append("N").append(",");
        }
        else{
            sb.append(node.val).append(",");
            dfs(node.left);
            dfs(node.right);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("") || data.isEmpty() || data.equals("N")){
            return null;
        }
        String [] dataArray = data.split(",");
        return createTree(dataArray);
    }

    private TreeNode createTree(String [] data){
        
        if(data[index].equals ("N")){
            index++;
            return null;
        }
    
        TreeNode node = new TreeNode(Integer.parseInt(data[index++]));
        node.left = createTree(data);
        node.right = createTree(data);

        return node;
    }
}

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


    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root==null) return "";

        StringBuilder str = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
             TreeNode node = q.poll();
             
             if(node==null){
                str.append("null,");
             }else{
                str.append(node.val).append(",");

                q.offer(node.left);
                q.offer(node.right);
             }
        }

        return str.toString();
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        if(data.isEmpty()) return null;

        String[] str = data.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(str[0]));

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        int i = 1;

        while(!q.isEmpty() && i<str.length){
            TreeNode node = q.poll();

    
            if (!str[i].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(str[i]));
                node.left = leftNode;
                q.offer(leftNode);
            }
            i++;

           
            if (!str[i].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(str[i]));
                node.right = rightNode;
                q.offer(rightNode);
            }
            i++;
        }

        return root;

    }
       
}

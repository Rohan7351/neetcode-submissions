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


      int ind = 0;
    // Encodes a tree to a single string.
    
    public void serializeHelper(TreeNode root, StringBuilder str){
        if(root==null){
            str.append("null,");
            return ;
        }
           
       str.append(root.val).append(",");
       serializeHelper(root.left, str);
       serializeHelper(root.right, str);

    }

    public String serialize(TreeNode root) {

        StringBuilder str = new StringBuilder("");

        serializeHelper(root, str);
       
        return str.toString();
    }


    public TreeNode deserializeHelper(String[] str){
         if(str[ind].equals("null")){
            ind++;
            return null;
         }

         TreeNode root = new TreeNode(Integer.parseInt(str[ind]));
         ind++;

         root.left = deserializeHelper(str);
         root.right = deserializeHelper(str);

         return root;

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {

        String[] values = data.split(",");
        ind = 0;
       return  deserializeHelper(values);
    }
}

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
    public int getHeight(TreeNode node){
        if(node==null) return 0;

        int left = getHeight(node.left);
        int right = getHeight(node.right);

        if(left==-1 || right==-1 || Math.abs(left-right)>1) return -1;

        return 1 + Integer.max(left, right);

    }
    public boolean isBalanced(TreeNode root) {

       if(getHeight(root)==-1) return false;
    return true;
    

    }
}

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
    int ans = 0;
    public int getMaxValuePath(TreeNode root){
      if(root==null) return 0;

        int left = getMaxValuePath(root.left);
        int right = getMaxValuePath(root.right);

         ans = Integer.max(ans , (1 + left + right));
        return 1 + Integer.max(left, right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        getMaxValuePath(root);

        return ans-1;
    }
}

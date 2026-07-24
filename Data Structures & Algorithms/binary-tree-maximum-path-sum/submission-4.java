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

    int ans = Integer.MIN_VALUE;
    public int helper(TreeNode node){
      if(node == null ) return 0;

      int left = Integer.max(0, helper(node.left));
      int right = Integer.max(0, helper(node.right));

      ans = Integer.max(ans , node.val + left + right);
      return node.val +Integer.max(left, right);

    }

    public int maxPathSum(TreeNode root) {

       helper(root);

       return ans;
    }
}

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
    
    int count = 0;

    public void countGoodNode(TreeNode node, int currMax){
         if(node == null) return ;

         if(node.val>=currMax){
            count++;
            currMax = node.val;
         }

         countGoodNode(node.left,  currMax);
         countGoodNode(node.right, currMax);    

         return;    

    }

    public int goodNodes(TreeNode root) {
         
        //  int count = 0;
         int currMax = root.val;

         countGoodNode(root, currMax);

         return count;

        
    }
}

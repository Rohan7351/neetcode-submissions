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
    public int countGoodNode(TreeNode node, int currMax){
         if(node == null) return 0;


         int count = 0;

         if(node.val>=currMax){
            count++;
            currMax = node.val;
         }

         int lcount = countGoodNode(node.left,  currMax);
         int rcount = countGoodNode(node.right, currMax);    

         return count + lcount + rcount;    

    }

    public int goodNodes(TreeNode root) {
         
        //  int count = 0;
         int currMax = root.val;

         return countGoodNode(root, currMax);

        
    }
}

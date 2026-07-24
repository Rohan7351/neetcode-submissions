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
    
    public TreeNode build(int[] preorder,int startPre,int endPre, int[] inorder, int startIn, int endIn, Map<Integer, Integer> mp){
        
        if(startPre>endPre || startIn>endIn) return null;

        TreeNode node = new TreeNode(preorder[startPre]);
        int mid = mp.get(preorder[startPre]);

        int left = mid - startIn;
 
        node.left = build(preorder,startPre+1,startPre + left, inorder , startIn, mid-1 , mp);
        node.right = build(preorder,startPre+left+1, endPre, inorder, mid+1, endIn , mp);
         
         return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
         int n = preorder.length;

         Map<Integer, Integer> mp = new HashMap<>();

         for(int i=0;i<n;++i){
            mp.put(inorder[i], i);
         }

         return build(preorder, 0, n-1,inorder,0, n-1, mp);   
    }
}

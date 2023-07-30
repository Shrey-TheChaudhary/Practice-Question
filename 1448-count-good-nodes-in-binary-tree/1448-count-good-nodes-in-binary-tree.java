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
    int count=0;
    public int goodNodes(TreeNode root) 
    {
    return 1+maxNode(root.left,root.val)+maxNode(root.right,root.val);
        
    }
    public int maxNode(TreeNode root,int maxVal){
        if(root==null)  
            return 0;

        int res=0;
        if(root.val>=maxVal){
            res=1;
            maxVal=Math.max(maxVal,root.val);
        }

        count=res+maxNode(root.left,maxVal)+maxNode(root.right,maxVal);

        return count;
    }
}
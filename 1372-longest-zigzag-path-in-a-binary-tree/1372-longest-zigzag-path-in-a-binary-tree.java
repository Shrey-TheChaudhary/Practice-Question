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
    int max_m=Integer.MIN_VALUE;
    public int helper(boolean left, boolean right, TreeNode root,int max,HashMap<TreeNode,Integer> dp)
    {
        if(root==null)
	        return 0;
        
	        if(dp.containsKey(root))
	        	return dp.get(root);
        
	        if(left==true && root.left!=null)
	        helper(false,true,root.left,max+1,dp);
        
	        if(right==true && root.right!=null)
	        helper(true,false,root.right,max+1,dp);
        
	        max_m=Math.max(max_m,max);
	        dp.put(root, max_m);
        
	        max=0;
	        helper(false,true,root.left,1,dp);
	        helper(true,false,root.right,1,dp);
	        return max_m;
    }
    public int longestZigZag(TreeNode root) {
      if(root.left==null && root.right==null)
	        return 0;
	        HashMap<TreeNode, Integer> dp=new HashMap<>();
	        return Math.max(helper(false,true,root.left,1,dp),helper(true,false,root.right,1,dp));
    }
}
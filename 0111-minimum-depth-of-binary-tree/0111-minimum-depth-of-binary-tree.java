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
    public int minDepth(TreeNode root) {
        if(root == null)
            return 0;

        int left = minDepth(root.left)+1;
        int right = minDepth(root.right)+1;
		
        if(root.left == null)
            return right;
        
        if(root.right == null)  
            return left;
        
        int depth = Math.min(left,right);
		
        return depth;
    }
}
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
    public int sumNumbers(TreeNode root) {
        return helper(root , 0);
    }
    static int helper(TreeNode root , int currentSum){
        if(root == null) 
            return 0;

        int newSum = currentSum * 10 + root.val;
        if(root.left == null && root.right == null) 
            return newSum;
        
        int leftSum = helper(root.left , newSum);
        int rightSum = helper(root.right , newSum);

        return leftSum +  rightSum;
    }
}
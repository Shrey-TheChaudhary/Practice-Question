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
    static int maxValue;
    public int maxPathSum(TreeNode root) {
         maxValue = Integer.MIN_VALUE;
         maxPathDown(root);

        return maxValue; 
    }

    public static int maxPathDown(TreeNode root){
        if(root == null)
         return 0;

        int lh = Math.max(0, maxPathDown(root.left));
        int rh = Math.max(0, maxPathDown(root.right));
// Update the max path sum if the path passing through the current node has a greater sum
        maxValue = Math.max(maxValue, root.val + lh + rh);
// Return the maximum path sum down to the current node
        return root.val + Math.max(lh, rh);
    }
}

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
    public TreeNode constructMaximumBinaryTree(int[] nums) {
       return buildTree(nums,0,nums.length-1);
    }
    TreeNode buildTree(int[] nums, int l, int r){
        if(l>r)
            return null;
        int max=Integer.MIN_VALUE;
        int ind=0;
        for(int i=l;i<=r;i++){
          if(nums[i]>max){
              max=nums[i];
              ind=i;
          }
        }
        TreeNode root=new TreeNode(max);
        root.left=buildTree(nums,l,ind-1);
        root.right=buildTree(nums,ind+1,r);
        return root;
    }
}
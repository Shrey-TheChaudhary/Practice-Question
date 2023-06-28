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
    int idx=0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         return helper(preorder, inorder, 0, preorder.length-1);
    }
    public TreeNode helper(int[] preorder,int[] inorder,int left,int right){
        if(left>right)
            return null;
        
          TreeNode root = new TreeNode(preorder[idx]);

        for(int i=left; i<=right;i++)
        {
            if(preorder[idx]==inorder[i])
            {
                idx++;
                root.left = helper(preorder, inorder, left, i-1);
                root.right = helper(preorder, inorder, i+1, right);
                break;
            }
        }
        return root;

    }
}
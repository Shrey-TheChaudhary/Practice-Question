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
    int max = 0;
    public int longestZigZag(TreeNode root) {
        if(root.left != null){
            traverse(root.left,true,1);
        }
        if(root.right != null){
            traverse(root.right,false,1);
        }
        return max;
    }
    public void traverse(TreeNode root,boolean left,int count){
        if(max < count){
            max = count;
        }
        if(root.left != null){
            traverse(root.left,true,!left?count+1:1);
        }
        if(root.right != null){
            traverse(root.right,false,left?count+1:1);
        }
    }
}
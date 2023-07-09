/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null)
            return null;
        
        if(root==p ||root==q)
            return root;
        
        TreeNode lca1=lowestCommonAncestor(root.left,p,q);
        TreeNode lca2=lowestCommonAncestor(root.right,p,q);
        
        if(lca1!=null && lca2!=null)
            return root;
        
        if(lca1!=null)
            return lca1;
        else
            return lca2;
        
        
    }
}
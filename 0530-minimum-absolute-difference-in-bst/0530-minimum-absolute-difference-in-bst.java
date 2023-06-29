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
    public int getMinimumDifference(TreeNode root) {
        List<Integer> trav = new ArrayList<>();
        inorder(root, trav);
        
        int diff = Math.abs(trav.get(1) - trav.get(0));
        for (int i = 1; i < trav.size(); i++)
        {
        diff = Math.min(diff, Math.abs(trav.get(i) - trav.get(i - 1)));
        }
        
        return diff;
    }
    
    private void inorder(TreeNode root, List<Integer> trav) {
        if (root == null) {
            return;
        }
        
        inorder(root.left, trav);
        trav.add(root.val);
        inorder(root.right, trav);
    }
}
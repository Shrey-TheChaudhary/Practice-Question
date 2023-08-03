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
    public List<String> binaryTreePath(TreeNode root,String path,List<String> list){
        if(root == null){
            return list;
        }
        if(root.left == null && root.right == null){
            list.add(path + root.val);
            return list;
        }
        binaryTreePath(root.left,(path + root.val + "->"),list);
        binaryTreePath(root.right,(path + root.val + "->"),list);
        return list;
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<String>();
        binaryTreePath(root,"",list);
        return list;
    }
}
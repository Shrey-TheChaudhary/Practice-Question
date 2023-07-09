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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum)    {
        List<List<Integer>> list = new ArrayList<>();
        allPathSum(root,targetSum, new ArrayList<Integer>(),list);
        return list;
    }
    
    public void allPathSum(TreeNode root,int targetSum,List<Integer> path,List<List<Integer>> list){
        
        if(root == null)
            return ;
        
        path.add(root.val);
        
        if(root.left == null && root.right == null && root.val == targetSum){
            list.add(new ArrayList<Integer>(path));
        }
        allPathSum(root.left,(targetSum - root.val),path,list);
        allPathSum(root.right,(targetSum - root.val),path,list);
        path.remove(path.size()-1);
    }
    
}
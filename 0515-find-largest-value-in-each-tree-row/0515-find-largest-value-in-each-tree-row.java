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
   public List<Integer> largestValues(TreeNode root) {
      List<Integer> list=new ArrayList<>();
      if (root==null)return list;
      Queue<TreeNode> q=new LinkedList<>();
      int max=Integer.MIN_VALUE;
      q.add(root);
      q.add(null);
      while (!q.isEmpty()){
          TreeNode curr=q.poll();
          if (curr==null){
              list.add(max);
              max=Integer.MIN_VALUE;
              if (q.isEmpty()){
                  break;
              }else {
                  q.add(null);
              }
          }else {
              max=Math.max(max, curr.val);
              if (curr.left!=null){
                  q.add(curr.left);
              }
              if (curr.right!=null){
                  q.add(curr.right);
              }
          }
      }
      return list;
    }
}
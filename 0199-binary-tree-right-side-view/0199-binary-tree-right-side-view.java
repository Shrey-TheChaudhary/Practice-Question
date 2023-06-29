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
    public List<Integer> rightSideView(TreeNode root) {
          List<Integer> ans=new ArrayList<Integer>();
        if(root==null)
            return ans;
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
      
        while(!q.isEmpty())
        {
            int count=q.size();
            for(int i=0;i<count;i++)
            { TreeNode curr=q.poll();
                if(i==count-1)
                    ans.add(curr.val);
             if(curr.left!=null)
                 q.add(curr.left);
             if(curr.right!=null)
                 q.add(curr.right);
            }
        }
        return ans;
        
        
    }
}
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans=new ArrayList<Double>();
        if(root==null)
            return ans;
        
        Queue<TreeNode> q=new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty())
        {double sum=0;double avg=0;
            int count=q.size();
            for(int i=0;i<count;i++)
            {
                TreeNode curr=q.poll();
                sum+=curr.val;
                if(curr.left!=null)
                    q.add(curr.left); 
                 if(curr.right!=null)
                    q.add(curr.right); 
            }
         avg=sum/count;
         ans.add(avg);
        }
        return ans;
    }
}
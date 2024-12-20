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
    public TreeNode reverseOddLevels(TreeNode root) {
       Queue<TreeNode> q=new LinkedList<>();
       q.add(root);
       int level=0;
       while(q.size()>0)
       {
            int size=q.size();
            ArrayList<Integer> list=new ArrayList<>(size);
            ArrayList<TreeNode> nodelist=new ArrayList<>(size);
            while(size-->0)
            {
                TreeNode currelement=q.poll();
                list.add(currelement.val);
                nodelist.add(currelement);
                
                if(currelement.left!=null) 
                    q.add(currelement.left);
                if(currelement.right!=null)
                    q.add(currelement.right);
            }
            if(level%2==1)
            {
                Collections.reverse(list);
                int n=nodelist.size();
                for(int i=0;i<n;i++)
                {
                    nodelist.get(i).val=list.get(i);
                }
            }
            level++;
       }
       return root;
    }
}
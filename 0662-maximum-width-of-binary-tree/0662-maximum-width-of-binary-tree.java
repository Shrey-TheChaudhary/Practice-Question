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
 class pair {
    int level;
    TreeNode root;
    public pair(TreeNode root, int level)
    {
        this.level=level;
        this.root=root;
    }
}

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<pair> q = new LinkedList<>();

        int max = Integer.MIN_VALUE;

        if(root==null) return 0;

        q.addLast(new pair(root,0));

        while(!q.isEmpty())
        {
            int size = q.size();
            max = Math.max(max, (q.getLast().level - q.getFirst().level +1));

            for(int i=0;i<size;i++)
            {
                pair element = q.removeFirst();

                if(element.root.left!=null)
                q.addLast(new pair(element.root.left,2*element.level));

                if(element.root.right!=null)
                q.addLast(new pair(element.root.right,2*element.level+1));
            }
        }
return max;

    }
}
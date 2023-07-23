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
    Map<Integer , List<TreeNode>> map = new HashMap<>();
public List<TreeNode> allPossibleFBT(int n) {
    
    if(!map.containsKey(n)){
        List<TreeNode> res = new ArrayList<>();

        if(n == 1){
            res.add(new TreeNode(0,null,null));
        } else {
            for(int i = 1 ; i < n ; i += 2){
                List<TreeNode> leftSubtree = allPossibleFBT(i);
                List<TreeNode> rightSubtree = allPossibleFBT(n - i - 1);

                for(TreeNode left : leftSubtree){
                    for(TreeNode right : rightSubtree){
                        res.add(new TreeNode(0,left,right));
                    }
                }
            }
        }
        map.put(n , res);
    }
    
    return map.get(n);
}
}
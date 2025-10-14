/*
class Node {
    int data;
    Node left, right;
    Node(int val) {
        data = val;
        left = right = null;
    }
}
*/

class Solution {
    public int nodeSum(Node root, int l, int r) {
        // Base case: if root is null, return 0
        if (root == null) {
            return 0;
        }
        
        // If current node's value is less than the lower bound,
        // we only need to search in the right subtree
        if (root.data < l) {
            return nodeSum(root.right, l, r);
        }
        
        // If current node's value is greater than the upper bound,
        // we only need to search in the left subtree
        if (root.data > r) {
            return nodeSum(root.left, l, r);
        }
        
        // If current node's value is within the range,
        // include it in the sum and search both subtrees
        return root.data + 
               nodeSum(root.left, l, r) + 
               nodeSum(root.right, l, r);
    }
}
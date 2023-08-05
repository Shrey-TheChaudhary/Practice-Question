/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    List<Integer> arr = new ArrayList<>();
    public List<Integer> preorder(Node root) 
    {
        if (root==null)
            return arr;
        
        arr.add(root.val);
        for (Node i : root.children) 
            preorder(i);
        
        return arr;
    }
}
/*
class Node {
    int data;
    Node left, right;
    Node(int val){
        data = val;
        left = right = null;
    }
}
*/

class Solution {
  private ArrayList<Integer> res = new ArrayList<>();

  public ArrayList<Integer> postOrder(Node root) {
    if (root == null)
      return null;
    postOrder(root.left);
    postOrder(root.right);
    res.add(root.data);
    return res;
  }
}
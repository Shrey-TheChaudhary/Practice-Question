/*
class Node {
    int data;
    Node left,right;
    Node(int d)
    {
        data=d;
        left=right=null;
    }
}
*/

class Solution {
  ArrayList<Integer> zigZagTraversal(Node root) {
    ArrayList<Integer> res = new ArrayList<>();
    Queue<Node> q = new LinkedList<>();
    q.offer(root);
    boolean isLeftToRight = false;
    while (!q.isEmpty()) {
      int len = q.size();
      ArrayList<Integer> row = new ArrayList<>();
      for (int i = 0; i < len; ++i) {
        Node node = q.poll();
        row.add(node.data);

        if (node.left != null)
          q.offer(node.left);

        if (node.right != null)
          q.offer(node.right);
      }
      if (isLeftToRight) {
        Collections.reverse(row);
      }
      res.addAll(row);
      isLeftToRight = !isLeftToRight;
    }
    return res;
  }
}
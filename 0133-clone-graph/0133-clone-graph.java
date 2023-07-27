/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

   class Solution {
   public void dfs(Node original,Node copiedNode,Node visited[]){
       visited[copiedNode.val] = copiedNode;

       for(Node node:original.neighbors)
       {
           if(visited[node.val] == null)
           {
               Node newNode =  new Node(node.val);
               copiedNode.neighbors.add(newNode);
               dfs(node,newNode,visited);    
           }
           else{
               copiedNode.neighbors.add(visited[node.val]);
           }
       }
   }
   public Node cloneGraph(Node node) {
       
       if(node == null) 
           return null;
   
       Node visited[] = new Node[101]; 
       Node copiedNode = new Node(node.val);
       dfs(node,copiedNode,visited);

       return copiedNode;
   }
}
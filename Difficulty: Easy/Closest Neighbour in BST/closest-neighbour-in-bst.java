/*
class Node {
    int data;
    Node left, right;

    Node(int x) {
        data = x;
        left = right = null;
    }
} */
class Solution {

    public int findMaxFork(Node root, int k) {
        // code here.
       int ans = -1;
       
       while(root != null){
           if(root.data==k){
               return k;
           }else if(root.data < k){
               ans = root.data;
               root = root.right;
           }else{
               root = root.left;
           }
       }
      
        return ans;
    }
}
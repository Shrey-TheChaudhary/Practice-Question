/*
class Node {
        int data;
        Node left, right;

        Node(int item) {
            data = item;
            left = right = null;
        }
}*/

class Solution {
    int GUB=(int)1e5+1; // GLOBAL UPPER BOUND
    int GLB=0; // GLOBAL LOWER BOUND
    public boolean isDeadEnd(Node root) {
        // Code here.
        return f(root,GUB,GLB);
    }
    
    public boolean f(Node root, int UB, int LB){
        if(root== null) return false; // here false is ok as our logic will try to find answer from other end
        if(root.left==null && root.right==null) {
            if(root.data-LB ==1 && UB-root.data==1) return true; // means no element can be inserted
            return false;
        }
        return f(root.left,root.data,LB) || f(root.right,UB,root.data);
    }
}
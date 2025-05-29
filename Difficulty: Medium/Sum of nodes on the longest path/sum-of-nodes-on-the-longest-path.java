/*
class Node {
    int data;
    Node left, right;

    public Node(int data){
        this.data = data;
    }
} */
class Solution {
     HashMap<Integer,Integer>map;
    public int sumOfLongRootToLeafPath(Node root) {
          map=new HashMap<>();
        if(root==null){
            return 0;
        }
        dfs(root,0,0);
        int max_level=-1;
        int max_val=0;
        for (int level : map.keySet()) {
            if(level>max_level){
                max_level=level;
                max_val=map.get(level);
            }
        }
        return max_val;
    }
    public void dfs(Node root,int level,int val){
        if(root==null){
            if(map.containsKey(level)){
                int x=map.get(level);
                int mx=Math.max(val, x);
                map.put(level, mx);
            }else{
                map.put(level, val);
            }
            return;
        }
        dfs(root.left, level+1, val+root.data);
        dfs(root.right, level+1, val+root.data);    
    }
}
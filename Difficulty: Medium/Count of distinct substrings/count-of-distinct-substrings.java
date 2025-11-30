class Solution {
    
    static class Node{
        Node children[];
        boolean eow;
        
        Node(){
            children = new Node[26];
            for(int i=0; i<26; i++){
                children[i] = null;
            }
            this.eow = false;
        }
    }
    
    public static void insert(Node root, String word){
        Node curr = root;
        
        for(int i=0; i<word.length(); i++){
            int idx = word.charAt(i) - 'a';
            if(curr.children[idx] == null){
                curr.children[idx] = new Node();
            }
            curr = curr.children[idx];
        }
        curr.eow = true;
    }
    
    public static int count(Node root){
        if(root == null) return 0;
        
        int count = 0;
        for(int i=0; i<root.children.length; i++){
            if(root.children[i] != null){
               count += 1 + count(root.children[i]);
            }
        }
        return count;
    }
    
    public static int countSubs(String s) {
        // code here
        int n = s.length();
    
        Node root = new Node();
        
        String[] words = new String[n];
        
        for(int i=0; i<n; i++){
            words[i] = s.substring(i, n);
        }
        
        for(int i=0; i<n; i++){
            insert(root, words[i]);
        }
        
        return count(root);
        
    }
}
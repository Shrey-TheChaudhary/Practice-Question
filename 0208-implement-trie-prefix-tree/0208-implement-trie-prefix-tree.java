class Node{
    Node child[] = new Node[26];
    boolean isend = false;
}
class Trie {
    Node root;

    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node curr=root;
        for(int i=0;i<word.length();i++)
        {
            int ind=word.charAt(i)-'a';
        
        if(curr.child[ind]==null)
            curr.child[ind]=new Node();
        
            curr=curr.child[ind];
    }
        curr.isend=true;
    }
    
    public boolean search(String word) {
        Node curr = root;
        for(char c : word.toCharArray()){
            int idx = c-'a';
            if(curr.child[idx] == null){
               return false;
            }
            curr = curr.child[idx];
        }
        return curr.isend == true;        
    }
    
    public boolean startsWith(String prefix) {
         Node curr = root;
        for(char c : prefix.toCharArray()){
            int idx = c-'a';
            if(curr.child[idx] == null){
                return false;
            }
            curr = curr.child[idx];
        }
        return true;
    }
}
/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
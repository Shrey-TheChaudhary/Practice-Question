class MyHashSet {

    class Node{
        int val = 0;
        Node next = null;
        Node(int v, Node n){
            val = v;
            next = n;
        }
    }
    int hash = 500;
    Node[] set = new Node[hash];
    MyHashSet() {
        
    }
    
    void add(int key) {
        if(set[key%hash]==null)
            set[key%hash]=new Node(key,null);
        
        else{
            Node temp = set[key%hash];
            if(temp.val==key)
                return;
            while(temp.next!=null)
            {
                if(temp.val==key || temp.next.val==key)
                    return;
                temp=temp.next;
            }
            temp.next = new Node(key,null);
        }
    }
    
    void remove(int key) {
        if(set[key%hash]!=null)
        {
            Node temp = set[key%hash];
            if(temp.val==key)
            {
                set[key%hash]=temp.next;
                return;
            }
            while(temp.next!=null)
            {
                if(temp.next.val==key)
                {
                    temp.next = temp.next.next;
                    return;
                }
                temp=temp.next;
            }
        }
    }
    
    boolean contains(int key) {
        if(set[key%hash]!=null)
        {
            Node temp = set[key%hash];
            while(temp!=null)
            {
                if(temp.val==key)
                    return true;
                
                temp=temp.next;
            }
        }
        return false;
    }
}
/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
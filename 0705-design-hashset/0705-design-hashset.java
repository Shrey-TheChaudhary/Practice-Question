class MyHashSet {
    boolean[] arr  ;

    public MyHashSet() {
        arr  = new boolean[1000001];
    }
    
    public void add(int i) {
        arr[i] = true;
    }
    
    public void remove(int i) {
        arr[i] = false;
    }
    
    /** Returns true if this set contains the specified element */
    public boolean contains(int i) {
        return arr[i];
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
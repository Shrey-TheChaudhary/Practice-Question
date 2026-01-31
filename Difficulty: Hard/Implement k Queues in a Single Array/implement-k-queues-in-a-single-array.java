class kQueues {
    List<Queue<Integer>> qt = new ArrayList<>();
    int k;
    int n;
    int size;
    kQueues(int n, int k) {
        // Initialize your data members
        for(int i = 0; i < n; i++) {
            qt.add(new LinkedList<>());
        }
        this.k = k;
        this.n = n;
    }

    void enqueue(int x, int i) {
        // enqueue element x into queue number i
        if(i >= qt.size()) return;
        
        size++;
        qt.get(i).offer(x);
    }

    int dequeue(int i) {
        // dequeue element from queue number i
        if(i >= qt.size()) return -1;
        if(qt.get(i).isEmpty()) return -1;
        size--;
        return qt.get(i).poll();
    }

    boolean isEmpty(int i) {
        // check if queue i is empty
        if(i >= qt.size()) return false;
        return qt.get(i).isEmpty();
    }

    boolean isFull() {
        // check if array is full
        return size == n;
    }
}
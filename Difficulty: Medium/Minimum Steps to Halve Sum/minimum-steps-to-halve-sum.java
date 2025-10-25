class Solution {
    public int minOperations(int[] arr) {
        // code here
        int op=0;
        PriorityQueue<Double> pq=new PriorityQueue<>((a,b)-> Double.compare(b,a));
        double sum=0;
        for(int i=0;i<arr.length;i++){
            pq.add((double)arr[i]);
            sum=sum+(double)arr[i];
        }
        
        double req=sum/2;
        
        while(sum>req && !pq.isEmpty()){
            double curr=pq.poll();
            double add=curr/2;
            sum=sum-curr+add;
            pq.add(add);
            op++;
        }
        return op;
    }
}


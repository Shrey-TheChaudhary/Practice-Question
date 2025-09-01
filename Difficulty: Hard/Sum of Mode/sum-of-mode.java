class Solution {
    class pair{
        int f,v;
        pair(int f,int v){
            this.f=f;
            this.v=v;
        }
    }
    public int sumOfModes(int[] arr, int k) {
        HashMap<Integer,Integer>mp = new HashMap<>();
        PriorityQueue<pair>pq=new PriorityQueue<>((a,b)->{
           if(a.f==b.f)return a.v-b.v;
           return b.f-a.f;
        });
        int n=arr.length,r=0,j=0;
        for(int i=0;i<k;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
            pq.add(new pair(mp.get(arr[i]),arr[i]));
        }
        for(int i=k;i<n;i++){
            while(mp.get(pq.peek().v)!=pq.peek().f) pq.remove();
            r+=pq.peek().v;
            mp.put(arr[j],mp.getOrDefault(arr[j++],0)-1); //remove
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1); // add
            pq.add(new pair(mp.get(arr[i]),arr[i]));
        }
        while(mp.get(pq.peek().v)!=pq.peek().f) pq.remove();
        r+=pq.peek().v;
        return r;
    }
}
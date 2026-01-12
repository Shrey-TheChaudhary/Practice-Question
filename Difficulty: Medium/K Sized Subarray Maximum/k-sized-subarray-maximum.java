class Solution {
    public ArrayList<Integer> maxOfSubarrays(int[] arr, int k) {
        return f(arr,k);
    }
    
    ArrayList<Integer> f(int[] arr,int k){
        Deque<Integer> dq=new ArrayDeque<>();
        ArrayList<Integer> ans=new ArrayList<>();
        int i=0;
        for(i=0;i<k;i++){
            while(dq.size()>0 &&dq.peekLast()<arr[i]) dq.removeLast();
            dq.addLast(arr[i]);
        }
        
        ans.add(dq.peekFirst());
        
       for(;i<arr.length;i++){
           while(dq.size()>0 && dq.peekFirst()<arr[i-k]) dq.removeFirst();
           if(dq.size()>0 && dq.peekFirst()==arr[i-k]) dq.removeFirst();
           
            while(dq.size()>0 && dq.peekLast()<arr[i]) dq.removeLast();
            dq.addLast(arr[i]);
            
             ans.add(dq.peekFirst());
            
       }
       return ans;
    }
}
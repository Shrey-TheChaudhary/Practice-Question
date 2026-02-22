class Solution {
    public long subarrayXor(int arr[], int k) {
        // code here
        int n = arr.length;
        HashMap<Integer,Integer> h = new HashMap<>();
        int res = 0;
        int xor = 0;
        
        for(int i=0;i<n;i++){
            int num = arr[i];
            xor = xor ^ num;
            
            if(xor == k){
                res++;
            }
            
            if(h.get(xor ^ k) != null){
                res += h.get(xor ^ k);
            }
            
            h.put(xor,h.getOrDefault(xor,0)+1);
        }
        return res;

    }
}
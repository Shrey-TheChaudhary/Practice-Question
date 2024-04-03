class Solution {
    public int subarraySum(int[] arr, int k) {
        int n=arr.length;
        int count=0,sum=0;
        HashMap<Integer,Integer> map=new HashMap<>();
        
        for(int i=0;i<n;i++)
        {
            sum+=arr[i];
            if(sum==k) 
                count++;
            if(map.containsKey(sum-k))
                count+=map.get(sum-k);
            
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
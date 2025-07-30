class Solution {
    public int cntSubarrays(int[] arr, int k) {
        int n=arr.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        int cnt=0;int sum=0;
        map.put(0,1);
        for(int it:arr){
            sum+=it;
            if(map.containsKey(sum-k)){
                cnt+=map.get(sum-k);
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return cnt;
    }
}
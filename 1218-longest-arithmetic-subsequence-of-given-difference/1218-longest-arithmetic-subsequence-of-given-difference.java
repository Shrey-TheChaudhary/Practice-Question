class Solution {
    public int longestSubsequence(int[] arr, int difference) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int max=0;
        for(int x:arr)
        {
            int val = map.getOrDefault(x-difference,0)+1;
            max = Math.max(max,val);
            map.put(x,val);
        }
        return max;
    }
}
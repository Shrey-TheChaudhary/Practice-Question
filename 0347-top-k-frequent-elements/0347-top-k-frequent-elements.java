class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       int result[] = new int[k];

       Map<Integer,Integer> map = new HashMap<>();
       for(int i: nums)
           map.put(i, map.getOrDefault(i,0) + 1);
       

       PriorityQueue<Map.Entry<Integer,Integer>> pq = 
       new PriorityQueue<>((a,b) -> b.getValue() - a.getValue());

       for(Map.Entry<Integer,Integer> entry: map.entrySet())
           pq.add(entry);
       

       for(int i=0; i<k; i++){
           result[i] = pq.poll().getKey();
       }

       return result;
        
    }
}
class Solution {
    public static int minCost(int[] arr) {
        // code here
          PriorityQueue<Integer> minPq = new PriorityQueue<>();
        for(int i = 0 ; i < arr.length ; i++){
            minPq.add(arr[i]);
        }
        int minTotalCost = 0;
        while(minPq.size() > 1){
            int rope1 = minPq.poll();
            int rope2 = minPq.poll();
            int currentCost = rope1 + rope2;
            minTotalCost +=currentCost;
            minPq.add(currentCost);
        }
        return minTotalCost;
    }
}
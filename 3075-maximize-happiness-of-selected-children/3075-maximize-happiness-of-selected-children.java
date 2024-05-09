class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int h : happiness) 
            pq.add(h);
        
        long totalHappinessSum = 0;
        int turns = 0;

        for (int i = 0; i < k; i++) {
            // Add the current highest value to the total happiness sum and remove it from the max heap 
            totalHappinessSum += Math.max(pq.poll() - turns, 0);
            // Increment turns for the next iteration
            turns++;
        }
        return totalHappinessSum;
    }
}
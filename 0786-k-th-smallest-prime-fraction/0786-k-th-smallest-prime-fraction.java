class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Double.compare((double)arr[a[0]] / arr[a[1]], (double)arr[b[0]] / arr[b[1]]));
        
        for (int i = 0; i < arr.length - 1; ++i) 
            pq.offer(new int[]{i, arr.length - 1});
        
        while (--k > 0) 
        {
            int[] pair = pq.poll();
            if (pair[1] - 1 > pair[0])
                pq.offer(new int[]{pair[0], pair[1] - 1});
        }
        
        int[] result = pq.peek();
        return new int[]{arr[result[0]], arr[result[1]]};
    }
}
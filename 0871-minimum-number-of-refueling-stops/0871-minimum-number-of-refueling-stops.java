class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        
        int res = 0, curDist = startFuel;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> stations[b][1] - stations[a][1]);
        int i = 0; 
        while (curDist < target) {
            while (i < stations.length && stations[i][0] <= curDist)
                pq.add(i++);
            
            if (pq.isEmpty()) {
                return -1;
            }
            curDist+= stations[pq.poll()][1];
            res++;
        }
        return res;
    }
}
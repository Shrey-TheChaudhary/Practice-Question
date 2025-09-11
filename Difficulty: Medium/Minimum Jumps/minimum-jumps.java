class Solution {
    public int minJumps(int[] arr) {
        // code here
         int n = arr.length;
        if (n <= 1) return 0;        // already at the end
        if (arr[0] == 0) return -1;  // can't move anywhere

        int maxReach = arr[0];  // farthest index reachable so far
        int steps = arr[0];     // steps we can still take in current jump
        int jumps = 1;          // we take the first jump

        for (int i = 1; i < n; i++) {
            if (i == n - 1) return jumps;  // reached the end

            maxReach = Math.max(maxReach, i + arr[i]);
            steps--;

            if (steps == 0) {              // we need to jump again
                jumps++;
                if (i >= maxReach) return -1; // stuck, cannot move
                steps = maxReach - i;
            }
        }
        return -1; // not reachable
    }
}
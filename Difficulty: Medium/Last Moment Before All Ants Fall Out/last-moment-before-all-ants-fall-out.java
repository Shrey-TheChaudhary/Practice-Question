class Solution {
    public int getLastMoment(int n, int left[], int right[]) {
        int maxTime = 0;
        
        // For ants moving left, they need 'position' time to reach the left end (0)
        for (int pos : left) {
            maxTime = Math.max(maxTime, pos);
        }
        
        // For ants moving right, they need 'n - position' time to reach the right end (n)
        for (int pos : right) {
            maxTime = Math.max(maxTime, n - pos);
        }
        
        return maxTime;
    }
}

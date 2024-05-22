class Solution {
    public boolean areSimilar(int[][] mat, int k) {
        for (int[] l : mat) 
        {
            int n = l.length;
            for (int i = 0; i < n; ++i) {
                if (l[i] != l[(i + k) % n]) {
                    return false;
                }
            }
        }
        return true;
    }
}
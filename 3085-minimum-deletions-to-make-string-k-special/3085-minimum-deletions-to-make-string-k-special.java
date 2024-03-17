import java.util.Arrays;

class Solution {
    public int minimumDeletions(String word, int k) {
        int res = 100000, A[] = new int[26];
        for (char c : word.toCharArray()) {
            A[c - 'a']++;
        }
        for (int x : A) {
            int cur = 0;
            for (int a : A) {
                cur += (a < x) ? a : Math.max(0, a - (x + k));
            }
            res = Math.min(res, cur);
        }
        return res;
    }
}
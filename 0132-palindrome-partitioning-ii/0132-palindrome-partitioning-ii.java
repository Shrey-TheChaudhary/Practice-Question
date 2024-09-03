//Striver DP-53

class Solution {
    public int minCut(String s) {
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[n] = 0;
        for (int i = n - 1; i >= 0; i--) {
            int minCost = Integer.MAX_VALUE;
            // String[i...j]
            for (int j = i; j < n; j++) {
                if (isPalindrome(i, j, s)) {
                    int cost = 1 + dp[j + 1];
                    minCost = Math.min(minCost, cost);
                }
            }
            dp[i] = minCost;
        }
        return dp[0] - 1;
    
    }
    static boolean isPalindrome(int i, int j, String s) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

//----------Recurssion-------------------
//  class Solution {

//     static int minCut(String str) {
//         int n = str.length();
//         return f(0, n, str) - 1;
//     }
//     static boolean isPalindrome(int i, int j, String s) {
//         while (i < j) {
//             if (s.charAt(i) != s.charAt(j)) return false;
//             i++;
//             j--;
//         }
//         return true;
//     }

//     static int f(int i, int n, String str) {
//         // Base case:
//         if (i == n) return 0;

//         int minCost = Integer.MAX_VALUE;
//         // String[i...j]
//         for (int j = i; j < n; j++) {
//             if (isPalindrome(i, j, str)) {
//                 int cost = 1 + f(j + 1, n, str);
//                 minCost = Math.min(minCost, cost);
//             }
//         }
//         return minCost;
//     }
//}
class Solution {
    
    private Set<String> power5Set = new HashSet<>();
    private int[] memo;

    public int cuts(String s) {
        for (long i = 1; i <= (1 << 30); i *= 5) {
            power5Set.add(Long.toBinaryString(i));
        }

        memo = new int[s.length()];
        Arrays.fill(memo, -2); 

        int result = dfs(s, 0);
        return result == Integer.MAX_VALUE ? -1 : result;
    }

    private int dfs(String s, int index) {
        if (index == s.length()) return 0;
        if (memo[index] != -2) return memo[index];

        int minCuts = Integer.MAX_VALUE;

        for (int i = index + 1; i <= s.length(); i++) {
            String sub = s.substring(index, i);
            if (isValidPowerOf5(sub)) {
                int res = dfs(s, i);
                if (res != Integer.MAX_VALUE) {
                    minCuts = Math.min(minCuts, 1 + res);
                }
            }
        }

        memo[index] = minCuts;
        return minCuts;
    }

    private boolean isValidPowerOf5(String s) {
        return s.charAt(0) != '0' && power5Set.contains(s);
    }
}
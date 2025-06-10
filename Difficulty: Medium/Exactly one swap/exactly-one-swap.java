class Solution {
    int countStrings(String s) {
        // code here
        Map<Character, Integer> freqMap = new HashMap<>();
        
        // Count the frequency of each character in the string
        for (char ch : s.toCharArray()) {
            freqMap.put(ch, freqMap.getOrDefault(ch, 0) + 1);
        }
        int ln = s.length();
        
        // Calculate sum of c * (c - 1) / 2 for all character frequencies
        int ans = 0;
        for (int count : freqMap.values()) {
            ans += (count * (count - 1)) / 2;
        }

        // Compute the final result
        int res = (ln * (ln - 1)) / 2 - ans;
        if (ans != 0) {
            res += 1;
        }

        return res;
    }
}
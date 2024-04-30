class Solution {
    public long wonderfulSubstrings(String word) {
        Map<Integer, Integer> count = new HashMap<>();
        count.put(0, 1);
        long result = 0;
        int bitmask = 0;

        for (char ch : word.toCharArray())
        {
            int charIndex = ch - 'a';
            bitmask ^= 1 << charIndex;
            result += count.getOrDefault(bitmask, 0);
            
            for (int i = 0; i < 10; i++) 
            {
                result += count.getOrDefault(bitmask ^ (1 << i), 0);
            }
            count.put(bitmask, count.getOrDefault(bitmask, 0) + 1);
        }

        return result;
    }
}
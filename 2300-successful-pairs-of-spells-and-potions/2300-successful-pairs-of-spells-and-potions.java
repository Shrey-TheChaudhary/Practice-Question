class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int pairs[] = new int[spells.length];

        Arrays.sort(potions);

        for(int i = 0; i < spells.length; i++)
        {
            int low = 0, high = potions.length-1;
            while(low <= high)
            {
                int mid = low + (high - low)/2;
                if(potions[mid] * (long)spells[i] >= success)
                {
                    high = mid - 1;
                }
                else
                {
                    low = mid + 1;
                }
            }
            pairs[i] = potions.length - low;
        }

        return pairs;
    }
}
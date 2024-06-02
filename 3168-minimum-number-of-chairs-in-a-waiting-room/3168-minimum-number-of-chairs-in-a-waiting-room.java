class Solution {
    public int minimumChairs(String s) {
        int curr = 0;
        int max = 0;

        for (char event : s.toCharArray()) {
            if (event == 'E')
            {
                curr++;
                max=Math.max(max,curr);
            } 
            else 
                curr--;
        }
        return max;
    }
}
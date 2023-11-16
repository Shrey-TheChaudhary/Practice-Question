class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();

        for (int i = 0; i < nums.length; ++i) {
            char currentChar = nums[i].charAt(i);
            char oppositeChar = (currentChar == '0') ? '1' : '0';

            // Append the opposite character to the result string
            ans.append(oppositeChar);
        }

        return ans.toString();
    }
}
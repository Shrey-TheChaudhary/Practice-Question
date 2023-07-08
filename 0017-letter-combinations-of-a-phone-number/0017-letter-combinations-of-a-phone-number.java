class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        String[] letter = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        combi(digits, 0, "", letter, result);

        return result;
    }
    
    private void combi(String digits, int index, String combination, String[] letter, List<String> result) {
        if (index == digits.length()) {
            result.add(combination);
            return;
        }

        String letters = letter[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++)
        {
        combi(digits,index+1,combination+letters.charAt(i),letter, result);
        }
    }
}

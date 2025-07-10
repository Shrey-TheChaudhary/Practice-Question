class Solution {
    public String longestString(String[] arr) {
        // code here
         Arrays.sort(arr, (a, b) -> {
            if (a.length() == b.length())
                return a.compareTo(b);
            return a.length() - b.length();
        });

        Set<String> set = new HashSet<>();
        String answer = "";

        for (String word : arr) {
            // If word is 1 char or its immediate prefix is valid
            if (word.length() == 1 || set.contains(word.substring(0, word.length() - 1))) {
                set.add(word);
                if (word.length() > answer.length() || 
                   (word.length() == answer.length() && word.compareTo(answer) < 0)) {
                    answer = word;
                }
            }
        }

        return answer.isEmpty() ? "-1" : answer;
    }
}

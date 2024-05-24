class Solution {
    public String toGoatLatin(String sentence) {
        boolean[] vowels = new boolean[256];
        for(char c : "aeiouAEIOU".toCharArray()) {
            vowels[c] = true;
        }

        StringBuilder result = new StringBuilder();
        int index = 1;

        for (String word : sentence.split("\\s")) {
            if (result.length() > 0) {
                result.append(" ");
            }

            char firstChar = word.charAt(0);
            if (vowels[firstChar]) {
                result.append(word);
            } else {
                result.append(word.substring(1)).append(firstChar);
            }

            result.append("ma");
            for (int j = 0; j < index; j++) {
                result.append("a");
            }

            index++;
        }

        return result.toString();
    }
}
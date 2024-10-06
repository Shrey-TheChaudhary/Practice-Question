import java.util.StringTokenizer;
class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        StringTokenizer st1 = new StringTokenizer(sentence1);
        StringTokenizer st2 = new StringTokenizer(sentence2);

        // Convert the tokenized words into arrays
        String[] words1 = new String[st1.countTokens()];
        String[] words2 = new String[st2.countTokens()];
        
        int i = 0;
        while (st1.hasMoreTokens()) {
            words1[i++] = st1.nextToken();
        }

        i = 0;
        while (st2.hasMoreTokens()) {
            words2[i++] = st2.nextToken();
        }

        int start = 0;
        int end1 = words1.length - 1;
        int end2 = words2.length - 1;

        // Compare words from the start
        while (start < words1.length && start < words2.length && words1[start].equals(words2[start])) {
            start++;
        }

        // Compare words from the end
        while (end1 >= start && end2 >= start && words1[end1].equals(words2[end2])) {
            end1--;
            end2--;
        }

        // If we have compared all words in one of the sentences
        return start > end2 || start > end1; 
    }
}
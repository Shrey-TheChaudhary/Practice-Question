import java.util.*;
class Solution {
    public String customSortString(String order, String s) {
            
// Create an array to store the order of characters
        int[] charOrder = new int[26];

        // Populate charOrder array with the positions of characters in 'order'
        for (int i = 0; i < order.length(); i++) {
            charOrder[order.charAt(i) - 'a'] = i;
        }

        // Convert string s to a Character array for sorting
        Character[] charArray = new Character[s.length()];
        for (int i = 0; i < s.length(); i++) {
            charArray[i] = s.charAt(i);
        }

        // Custom comparator based on the charOrder array
        Comparator<Character> customComparator = Comparator.comparingInt(c -> charOrder[c - 'a']);

        // Sort the Character array using the custom comparator
        Arrays.sort(charArray, customComparator);

        // Convert the sorted Character array back to a string
        StringBuilder result = new StringBuilder();
        for (Character c : charArray) {
            result.append(c);
        }

        return result.toString();
    }
}
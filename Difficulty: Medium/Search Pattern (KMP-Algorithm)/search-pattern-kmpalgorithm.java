//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String s, patt;
            s = sc.next();
            patt = sc.next();

            Solution ob = new Solution();

            ArrayList<Integer> res = ob.search(patt, s);
            if (res.size() == 0)
                System.out.print("[]");
            else {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        // your code here
         ArrayList<Integer> result = new ArrayList<>();
        int M = pat.length();  // Length of the pattern
        int N = txt.length();  // Length of the text

        int[] lps = computeLPS(pat);  // Preprocess the pattern to get the LPS array
        int i = 0; // Index for txt
        int j = 0; // Index for pat

        // Loop through the text
        while (i < N) {
            // If characters match, move both indices forward
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            // If we have found the pattern
            if (j == M) {
                // Add the starting index of the pattern in the text to the result list (convert to 0-based index)
                result.add(i - j);  // Use 0-based indexing
                // Update j to the length of the longest prefix suffix that is also a suffix
                j = lps[j - 1];
            } else if (i < N && txt.charAt(i) != pat.charAt(j)) {
                // If there is a mismatch after j matches
                if (j != 0) {
                    // Use the LPS array to avoid unnecessary comparisons
                    j = lps[j - 1];
                } else {
                    // If j is 0, move to the next character in the text
                    i++;
                }
            }
        }
        return result;
    }

    // Preprocesses the pattern to create the LPS (Longest Prefix which is also Suffix) array.
    public static int[] computeLPS(String pat) {
        int M = pat.length();  // Length of the pattern
        int[] lps = new int[M];  // LPS array to hold the longest prefix suffix values
        int len = 0;  // Length of the previous longest prefix suffix
        lps[0] = 0;  // LPS[0] is always 0
        int i = 1;

        // Loop through the pattern to fill the LPS array
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                // If there is a match, increment the length of the current LPS and assign it to LPS[i]
                len++;
                lps[i] = len;
                i++;
            } else {
                // If there is a mismatch
                if (len != 0) {
                    // Update len to the previous LPS value
                    len = lps[len - 1];
                } else {
                    // If len is 0, LPS[i] is 0
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }
}
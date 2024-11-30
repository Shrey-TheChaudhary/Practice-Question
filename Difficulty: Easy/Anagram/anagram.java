//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s1 = br.readLine(); // first string
            String s2 = br.readLine(); // second string

            Solution obj = new Solution();

            if (obj.areAnagrams(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {

        // Your code here
        if(s1.length() != s2.length()){
            return false;
        }
        else{
            
            char[] charArray1 = s1.toCharArray();
            char[] charArray2 = s2.toCharArray();
            
            Arrays.sort(charArray1);
            Arrays.sort(charArray2);
            
            boolean status = Arrays.equals(charArray1,charArray2);
            
            if(status)
                return true;
            else return false;
        }
    }
}
//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public String roundToNearest(String str) {
        StringBuilder sb = new StringBuilder(str);
        int n = str.length();
        
        if (sb.charAt(n - 1) <= '5') {
            sb.setCharAt(n - 1, '0');
        } else {
            sb.setCharAt(n - 1, '0');
            for (int i = n - 2; i >= 0; i--) {
                int a = sb.charAt(i) - '0';
                a += 1;
                if (a != 10) {
                    sb.setCharAt(i, (char) (a + '0'));
                    return sb.toString();
                }
                sb.setCharAt(i, '0');
            }
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());

        // looping through all testcases
        while (testcases-- > 0) {

            String str = br.readLine().trim();

            Solution obj = new Solution();

            String res = obj.roundToNearest(str);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends
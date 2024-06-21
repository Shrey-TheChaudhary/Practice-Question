//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class GFG {
    public static void main(String args[]) throws IOException {

        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

        Solution ob = new Solution();
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str = read.readLine().trim();
            String ans = ob.compareFrac(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {

    String compareFrac(String str) {
        // Code here
         String[] fractions = str.split(", ");

        // Split the first fraction to get numerator and denominator
        String[] fraction1 = fractions[0].split("/");
        double a = Double.parseDouble(fraction1[0]);
        double b = Double.parseDouble(fraction1[1]);

        // Split the second fraction to get numerator and denominator
        String[] fraction2 = fractions[1].split("/");
        double c = Double.parseDouble(fraction2[0]);
        double d = Double.parseDouble(fraction2[1]);
        
        double res1=(a/b);
        double res2=(c/d);
        
        
        if(res1==res2)
            return "equal";
        else if(res1>res2)
            return  fraction1[0]+ "/" + fraction1[1];
        
         return fraction2[0] + "/" + fraction2[1];
    }
}
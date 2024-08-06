//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.util.*;

public class validip {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            String s = sc.next();
            Solution obj = new Solution();

            if (obj.isValid(s))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    public boolean isValid(String str) {
       String ar[] = str.split("\\.");
        if(ar.length<4){return false;}
        for(String c:ar){
            if((c.length()>1 && c.charAt(0)=='0') || (Integer.parseInt(c)>255 ||
            Integer.parseInt(c)<0)){return false;}
        }
        return true;
    }
}
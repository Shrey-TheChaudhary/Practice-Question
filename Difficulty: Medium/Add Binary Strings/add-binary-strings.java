//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String addBinary(String s1, String s2) {


       StringBuilder sb = new StringBuilder();
       int l1 = s1.length()-1;
       int l2 = s2.length()-1;
       int carry = 0;
       
       while(l1>=0||l2>=0||carry>0)
       {
           int a = (l1>=0) ? s1.charAt(l1)-'0' : 0;
           int b = (l2>=0) ? s2.charAt(l2)-'0' : 0;
           
           int sum = a+b+carry;
           int digit = sum%2;
           carry = sum/2;
           
           sb.append(digit);
           l1--;
           l2--;
       }
       sb.reverse();
       while (sb.length() > 0 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0); 
        }
       
       return sb.toString();
    }
}
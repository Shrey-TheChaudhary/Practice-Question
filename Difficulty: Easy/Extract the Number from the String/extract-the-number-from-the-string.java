//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.regex.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.ExtractNumber(S));
        }
    }
}
// } Driver Code Ends


// User function Template for Java
class Solution {
    long ExtractNumber(String s) {
        int i=0, n=s.length();
        long ans=-1;
        
        while(i<n){
            
            if(s.charAt(i)>='0' && s.charAt(i)<='9'){
            
                long no = 0;
                boolean nine = false;
                
                while(i<n && s.charAt(i)>='0' && s.charAt(i)<='9'){
                    int val = s.charAt(i)-'0';
                    
                    no = no*10 + val;
                    if(val==9)  nine = true;
                    
                    i++;
                }
                
                if(!nine)   ans = Math.max(no,ans);

            }else{

                i++;

            }
        }
        
        return ans;
    }
}
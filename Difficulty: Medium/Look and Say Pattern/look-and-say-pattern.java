//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(read.readLine());

            Solution ob = new Solution();

            System.out.println(ob.countAndSay(n));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public String countAndSay(int n) {
        // code here
        if(n == 1){
            return "1";
        }
        
        String num = countAndSay(n-1);
        
        StringBuilder str = new StringBuilder();
        
        int count = 1;
        
        for(int i=0;i<num.length();i++){
            
            if(i == num.length()-1 || num.charAt(i) != num.charAt(i+1)){
                str.append(count);
                str.append(num.charAt(i));
                count=1;
            }else{
                count++;
            }
        }
        
        return str.toString();
    }
}
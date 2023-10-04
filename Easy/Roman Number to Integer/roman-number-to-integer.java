//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String roman = br.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.romanToDecimal(roman));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Finds decimal value of a given roman numeral
    public int romanToDecimal(String s) {
         if(s == null || s.length()==0) 
        return 0;
        
        Map<Character,Integer>map = new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);        

        int next=0, sum = 0;       

        int prev = map.get(s.charAt(0));
        
        for(int i=1;i<s.length();i++)
        {
            next = map.get(s.charAt(i));         
            if(prev<next) 
            sum -= prev;
            else 
            sum += prev;
            
            prev = next;
        }      
        sum += prev;
        return sum;
    }
}
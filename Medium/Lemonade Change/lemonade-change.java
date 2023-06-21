//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int a[] = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            Solution obj = new Solution();
            boolean ans = obj.lemonadeChange(n, a);
            System.out.println(ans ? "True" : "False");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static boolean lemonadeChange(int N, int bills[]) {
        int five = 0;
        int ten = 0;
        
        for(int i = 0; i < bills.length; i++)
        {
            int bill = bills[i];
            
            if(bill == 5)  {  /*if the current bill is $5 simplly increment bill of $5 by 1 and skip next statements*/
                five++;
                continue;
            }
            else if(bill == 10) {/*if the current bill is $10 give customer 1 bill of $5, so decrement $5, increment $10*/
                
                   /*if at any point you have no bill of $5 simple return false, you can not move further.*/
                if(five < 1) 
                    return false;

                ten++;
                five--;
            }
            else
            {/*if the current bill is $20*/
                if(ten >= 1 && five >= 1) { /*check if you have more than 1 of $10 and 1 of $5 each */
                    ten--;
                    five--;
                } else if (five >= 3) { five-=3;}/*check if you dont have $10 then you should have 3 of $10 */    
                else return false;
            }
        }
        return true;
    }
}
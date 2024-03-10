//{ Driver Code Starts
//Initial Template for Java



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String str = br.readLine().trim();

            String ans = new Solution().removeDuplicates(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    String removeDuplicates(String str) {
        int freqa[]=new int[26];
        int freqA[]=new int[26];
        String ans="";
        
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(Character.isLowerCase(ch))
                freqa[ch-'a']=1;
            else
                freqA[ch-'A']=1;
        }
        
        for(int i=0;i<str.length();i++)
        {
            char ch=str.charAt(i);
            if(Character.isLowerCase(ch) && freqa[ch-'a']==1)
            {
                ans+=ch;
                freqa[ch-'a']=0;
            }    
            else if(Character.isUpperCase(ch) && freqA[ch-'A']==1)
            {
                ans+=ch;
                freqA[ch-'A']=0;
            }
        }
        
        return ans;
    }
}
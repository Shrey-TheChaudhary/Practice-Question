//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
     public static String[] winner(String arr[], int n)
    {
        int maxCount = 0;
        Map<String, Integer> map = new HashMap<>();
        TreeSet<String> set = new TreeSet<>();
        for (String str : arr) {
            int currCount = map.getOrDefault(str, 0) + 1;
            map.put(str, currCount);
            maxCount = Math.max(maxCount, currCount);
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() == maxCount) {
                set.add(entry.getKey());
            }
        }
        return new String[] { set.pollFirst(), String.valueOf(maxCount) };
    }
}

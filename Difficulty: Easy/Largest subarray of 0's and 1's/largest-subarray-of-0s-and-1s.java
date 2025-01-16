//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Create BufferedReader for efficient input reading
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Read number of test cases
        int T = Integer.parseInt(br.readLine());

        // Process each test case
        while (T-- > 0) {
            // Read the entire line containing the array elements
            String line = br.readLine();

            // Split the line into an array of strings, then parse them as integers
            String[] tokens = line.split("\\s+");
            int[] a = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                a[i] = Integer.parseInt(tokens[i]);
            }

            // Create the Solution object
            Solution obj = new Solution();

            // Call maxLen function and print the result
            System.out.println(obj.maxLen(a));
        }
    }
}
// } Driver Code Ends


class Solution {
    public int maxLen(int[] arr) {
        // Your code here
        int n = arr.length;
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i=0; i<n; i++)
        {
            if(arr[i] == 0)
            {
                arr[i] = -1;
            }
        }
       
       int sum = 0;
       int max = 0;
       
       for(int i=0; i<n; i++)
       {
           sum += arr[i];
           if(sum == 0)
           {
               max = i + 1;
               continue;
           }
           
           if(map.containsKey(sum))
           {
               max = Math.max(max, i - map.get(sum));
               //System.out.println(i + " - " + map.get(sum) + "   " +( i - map.get(sum) + 1));
           }
           else
           {
               map.put(sum, i);
           }
       }
       
       return max;
    }
}
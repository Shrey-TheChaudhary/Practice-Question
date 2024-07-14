//{ Driver Code Starts


// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            new Solution().segregate0and1(arr);
            for (int i = 0; i < array.size(); i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void segregate0and1(int[] arr) {
        int n=arr.length;
        int ZeroCnt=0;
        int OneCnt=0;

        // Count no. of 0's and 1's
        for(int a: arr){  
            if(a==0)ZeroCnt++;
            else OneCnt++;
        }
        
        int i=0;
        while(i<n && ZeroCnt>0){
            arr[i++]=0;
            ZeroCnt--;
        }
        
        while(i<n && OneCnt>0){
            arr[i++]=1;
            OneCnt--;
        }
        
    }
}
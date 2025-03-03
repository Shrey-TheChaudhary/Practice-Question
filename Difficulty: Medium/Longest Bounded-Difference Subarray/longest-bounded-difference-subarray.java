//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.HashMap;


// } Driver Code Ends


class Solution {

    public ArrayList<Integer> longestSubarray(int[] arr, int x) {
        int n = arr.length;
        int l = 1;
        int idx = 0;
        int i = 0, j = 1;
        while(j<n) {
            int k = i;
            while(k <= j){
                if(Math.abs(arr[k] - arr[j]) > x){
                    i = k+1;
                }
                k++;
            }
            if(l < j - i + 1){
                l = j - i + 1;
                idx = i;
            }
            j++;
        }
        
        if(l == 1){
            idx = 0;
        }
        ArrayList<Integer> ans = new ArrayList<>();
        j = idx;
        while(j < n && j < idx+l){
            ans.add(arr[j]);
            j++;
        }
        return ans;
    }
}


//{ Driver Code Starts.
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
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

            int k = Integer.parseInt(br.readLine());
            // Create Solution object and find closest sum
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.longestSubarray(arr, k);

            // Print the result as a space-separated string
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println(); // New line after printing the results
            System.out.println("~");
        }
    }
}

// } Driver Code Ends
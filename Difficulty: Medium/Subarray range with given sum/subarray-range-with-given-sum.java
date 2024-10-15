//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.lang.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to count the number of subarrays which adds to the given sum.
    static int subArraySum(int arr[], int tar) {
    // HashMap to store prefixsum that previously appeared
    HashMap<Integer,Integer> map = new HashMap<>();
    // Initial Condition
    map.put(0,1);
    int count = 0,ps = 0;
    for(int i =0;i<arr.length;i++){
        ps += arr[i];
        
        // as we know currsum - sum if contained by arr so that only left sum
        // so we add the count that it have
        if(map.containsKey(ps - tar)){
            count += map.get(ps-tar);
        }
        // since if we get a match so we need to uncrease count 
        // also if we get a new prefix sum we want to increase count 
        map.put(ps,map.getOrDefault(ps,0)+1);
    }
    
    return count;
    }
        
    }

//{ Driver Code Starts.

class GFG {
    public static void main(String[] args) throws IOException {
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

            int tar = Integer.parseInt(br.readLine());
            Solution obj = new Solution();
            int res = obj.subArraySum(arr, tar);

            System.out.println(res);
            // System.out.println("~");
        }
    }
}
// } Driver Code Ends
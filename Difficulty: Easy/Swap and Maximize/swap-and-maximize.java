//{ Driver Code Starts
import java.io.*;
import java.util.*;

// Driver class

// } Driver Code Ends
// User function Template for Java

class Solution {
    public long maxSum(Long[] arr) {
        
        ArrayList<Long>res=new ArrayList<>();
        Arrays.sort(arr);
        
        for (int p = 0; p < arr.length; p++){
            res.add(arr[p]);
        }
        
        int i=1;
        
        while(i<=arr.length-1){
            res.add(i,res.get(res.size()-1));
            res.remove(res.size()-1);
            i+=2;
        }
        
        long sum=0;
        
        for(int j=0;j<res.size()-1;j++){
            sum+=Math.abs(res.get(j)-res.get(j+1));
        }
        
        sum+=Math.abs(res.get(0)-res.get(res.size()-1));
        
        return sum;
    }
}


//{ Driver Code Starts.
class Main {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the Long integers
            ArrayList<Long> array = new ArrayList<>();

            // Parse the tokens into Long integers and add to the array
            for (String token : tokens) {
                array.add(Long.parseLong(token));
            }

            // Convert ArrayList to array
            Long[] arr = new Long[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call maxSum method and print result
            long ans = ob.maxSum(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}
// } Driver Code Ends
//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Main {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());// input size of array
		    int arr[] = new int[n];
		    String inputLine2[] = br.readLine().trim().split(" ");
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine2[i]); // input elements of array
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.circularSubarraySum(arr, n));// print the circularSubarraySum
		}
	}
}



// } Driver Code Ends


class Solution{

    // a: input array
    // n: size of array
    //Function to find maximum circular subarray sum.
    static int circularSubarraySum(int nums[], int n) {
        
       int maxnormal = kadane(nums);
        if(maxnormal<0)
            return maxnormal;
        
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
            nums[i] = -nums[i]; 
        }


        int maxcircular = totalSum+kadane(nums);
        return Math.max(maxcircular,maxnormal);
    }

    public static int kadane(int[] a) {
        int res = a[0], maxsum=a[0];
        for (int i=1;i<a.length;i++)
        {
        maxsum=Math.max(a[i],maxsum+a[i]);
            res=Math.max(maxsum,res);
        }

        return res;
    }
}
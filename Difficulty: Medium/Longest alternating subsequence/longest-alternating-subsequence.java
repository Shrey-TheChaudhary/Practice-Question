//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends
// User function Template for Java
//Back-end complete function Template for Java
class Solution {
    public int alternatingMaxLength(int[] arr) {
        int dec=1,inc=1;
        for(int i=1;i<arr.length;i++){
            if(arr[i]>arr[i-1])inc=dec+1;
            else if(arr[i]<arr[i-1])dec=inc+1;
        }
        return Math.max(inc,dec);
    }
}

//{ Driver Code Starts.

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String s[] = br.readLine().trim().split(" ");
            int[] nums = new int[s.length];
            for (int i = 0; i < s.length; i++) {
                nums[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            int ans = obj.alternatingMaxLength(nums);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends
//{ Driver Code Starts
// Initial template for JAVA

import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        // taking input using class Scanner
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            // taking total number of elements
            int k = Integer.parseInt(br.readLine());
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
            ArrayList<Integer> res = new Solution().max_of_subarrays(k, arr);

            // printing the elements of the ArrayList
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function template for JAVA

class SegmentTree {
    private int segmentTree[];
    int size;
    
    SegmentTree(int n) {
        size=4*n;
        segmentTree=new int[size];
    }
    
    void buildTree(int i, int l, int r, int arr[]) {
        if(l==r) {
            segmentTree[i]=arr[l];
            return;
        }
        int mid=l+((r-l)>>1);
        buildTree(2*i+1,l,mid,arr);
        buildTree(2*i+2,mid+1,r,arr);
        segmentTree[i]=Math.max(segmentTree[2*i+1],segmentTree[2*i+2]);
    }
    
    int findMax(int start, int end, int i, int l, int r) {
        if(r<start || l>end) return Integer.MIN_VALUE;
        if(l>=start && r<=end) return segmentTree[i];
        int mid=l+((r-l)>>1);
        return Math.max(findMax(start,end,2*i+1,l,mid),findMax(start,end,2*i+2,mid+1,r));
    }
}
class Solution {
    // Function to find maximum of each subarray of size k.
    public ArrayList<Integer> max_of_subarrays(int k, int arr[]) {
        // Your code here
        int n=arr.length;
        SegmentTree st=new SegmentTree(n);
        st.buildTree(0,0,n-1,arr);
        
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=0;i<=n-k;i++) {
            ans.add(st.findMax(i,i+k-1,0,0,n-1));
        }
        
        return ans;
    }
}
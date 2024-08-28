//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.Map.Entry;


// } Driver Code Ends
// User function Template for Java

class Solution {
    // Function to sort the array according to frequency of elements.
    public ArrayList<Integer> sortByFreq(int arr[]) {
        // add your code here
        Map<Integer,Integer>map=new HashMap<>();
        for(int num: arr)
          map.put(num,map.getOrDefault(num,0)+1);
        Queue<int[]>pq=new PriorityQueue<>((a,b)->b[1]-a[1]==0?a[0]-b[0]:b[1]-a[1]);
        for(int key:map.keySet())
          pq.offer(new int[]{key,map.get(key)});
        
        ArrayList<Integer>ans=new ArrayList<Integer>();
        while(!pq.isEmpty()){
            int[]temp=pq.poll();
            while(temp[1]--!=0)
              ans.add(temp[0]);
        }
        return ans;
    }
}

//{ Driver Code Starts.

class Driverclass {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader sc = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(sc.readLine());
        while (n != 0) {
            String input = sc.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            ArrayList<Integer> ans = new ArrayList<Integer>();
            ans = new Solution().sortByFreq(arr);
            for (int i = 0; i < ans.size(); i++) System.out.print(ans.get(i) + " ");
            System.out.println();
            n--;
        }
    }
}

// } Driver Code Ends
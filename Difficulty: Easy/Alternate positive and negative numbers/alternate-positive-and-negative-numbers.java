//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String input = br.readLine();
            String[] inputArray = input.split("\\s+");
            ArrayList<Integer> arr = new ArrayList<>();

            for (String s : inputArray) {
                arr.add(Integer.parseInt(s));
            }

            new Solution().rearrange(arr);
            for (int num : arr) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    void rearrange(ArrayList<Integer> arr) {
        // code here


        ArrayList<Integer> posArr=new ArrayList<>();
        ArrayList<Integer> negArr=new ArrayList<>();
        for(int i=0;i<arr.size();i++){
            if(arr.get(i)<0){
                negArr.add(arr.get(i));
            }
            else{
                posArr.add(arr.get(i));
            }
        }
        arr.clear();
        int m=Math.min(posArr.size(),negArr.size());
        int n=Math.max(posArr.size(),negArr.size());
        for(int i=0;i<m;i++){
            arr.add(posArr.get(i));
            arr.add(negArr.get(i));
        }
        if(n==posArr.size()){
            for(int i=m;i<n;i++){
            arr.add(posArr.get(i));
        }
        }
        else{
            for(int i=m;i<n;i++){
            arr.add(negArr.get(i));
        }
        }
        
    }
}
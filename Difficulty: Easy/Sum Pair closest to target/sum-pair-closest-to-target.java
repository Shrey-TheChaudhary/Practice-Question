//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            ArrayList<Integer> array = new ArrayList<>();

            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int target = Integer.parseInt(br.readLine());

            Solution ob = new Solution();
            List<Integer> res = ob.sumClosest(arr, target);
            if (res.isEmpty()) {
                System.out.print("[]");
            } else {
                for (Integer num : res) {
                    System.out.print(num + " ");
                }
            }
            System.out.println();
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public List<Integer> sumClosest(int[] arr, int target) {
        Arrays.sort(arr);
        List<Integer> res = new ArrayList<>();
        int l = 0;
        int h = arr.length-1;
        int a = -1;
        int b = -1;
        int maxDiff = 0;
         
        while(l < h){
            int sum = arr[l] + arr[h];
            
            if(sum <= target){
                if(Math.abs(target - sum) < Math.abs(target - (a + b))
                || (sum == a + b && Math.abs(arr[l] - arr[h]) > maxDiff)){
                    a = arr[l];
                    b = arr[h];
                    maxDiff = Math.abs(arr[l] - arr[h]);
                }
                l++;
            }else{
                if((a == -1 && b == -1) || Math.abs(target - sum) < Math.abs(target - (a + b))
                || (sum == a + b && Math.abs(arr[l] - arr[h]) > maxDiff)){
                    a = arr[l];
                    b = arr[h];
                    maxDiff = Math.abs(arr[l] - arr[h]);
                }
                h--;
            }
        }
        
        if(a != -1 && b != -1){
            res.add(a);
            res.add(b);
        }
        
        return res;
    }
}
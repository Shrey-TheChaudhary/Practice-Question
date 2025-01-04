//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            int target = Integer.parseInt(sc.nextLine());

            Solution ob = new Solution();
            int ans = ob.countTriplets(arr, target);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int countTriplets(int[] arr, int target) {
        int n = arr.length;
        HashMap<Integer, ArrayList<Integer>>map = new HashMap<>();
        for(int i=0; i<n; i++){
            if(!map.containsKey(arr[i])){
                ArrayList<Integer>q = new ArrayList<>();
                map.put(arr[i], q);
            }
            map.get(arr[i]).add(i);
            
        }
        int count = 0;
        for(int i=1; i<n; i++){
            for(int j = i-1; j>=0; j--){
                int sum = arr[i] + arr[j]; 
                
                
                if(map.containsKey(target-sum)){
                    ArrayList<Integer>q = map.get(target-sum);
                   
                    for(int index: q){
                        if(index>i){
                            count++;
                            
                        }
                    }
                
                }
                
            }
        }
        
        return count;
    }
}
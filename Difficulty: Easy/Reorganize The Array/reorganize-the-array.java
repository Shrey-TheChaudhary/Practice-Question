//{ Driver Code Starts
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


// } Driver Code Ends



class Solution {
    public List<Integer> rearrange(List<Integer> arr) {
        // Code here
        
        boolean vis[] = new boolean[arr.size()];
        
        int cntMin = 0;
        
        for(int x : arr){
            if(x == -1) cntMin++;
            else vis[x] = true;
        }
        
        List<Integer> ans = new ArrayList<Integer>();
        
        for(int i = 0; i < arr.size(); i++){
            if(vis[i])
                ans.add(i);
            else if(cntMin > 0){
                ans.add(-1);
                cntMin--;
            }
        }
        
        return ans;
        
    }
}



//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        Solution solution = new Solution();

        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split("\\s+");
            List<Integer> arr = new ArrayList<>();
            for (String s : inputArr) {
                arr.add(Integer.parseInt(s));
            }

            List<Integer> ans = solution.rearrange(arr);

            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        scanner.close();
    }
}
// } Driver Code Ends
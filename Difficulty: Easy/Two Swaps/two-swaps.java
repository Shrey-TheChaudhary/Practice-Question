//{ Driver Code Starts
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t = Integer.parseInt(scanner.nextLine()); // Read number of test cases

        // Loop through each test case
        while (t-- > 0) {
            String input = scanner.nextLine();
            String[] inputArr = input.split(" ");
            List<Integer> arr = new ArrayList<>();

            // Convert input to list of integers
            for (String str : inputArr) {
                arr.add(Integer.parseInt(str));
            }

            Solution ob = new Solution();
            boolean ans = ob.checkSorted(arr);

            // Output result
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");
        }

        scanner.close();
    }
}

// } Driver Code Ends


class Solution {

    public boolean checkSorted(List<Integer> a) {
        // code here
        int c=1;
        int s=0;
        for(int i:a){
            if(i!=c){
                int k=a.get(i-1);
                 a.set(i-1,i);
                 s++;
                if(k==c){
                    a.set(c-1,k);
                }else{
                    int p=a.get(k-1);
                    a.set(k-1,k);
                    s++;
                    if(p!=c){return false;}
                     a.set(c-1,p);
                     }
                  }
                if(s>2){return false;}
                c++;
    
        }
        return true;
    }
}
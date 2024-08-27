//{ Driver Code Starts
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            String input = br.readLine();
            String[] inputs = input.split(" ");
            int[] arr = new int[inputs.length];

            for (int i = 0; i < inputs.length; i++) {
                arr[i] = Integer.parseInt(inputs[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.findMaxDiff(arr));
        }
    }
}

// } Driver Code Ends


class Solution {
    private static int[] rightNearest(int[] arr, int n){
        Stack<Integer> st = new Stack<>();
        int[] right = new int[n];
        st.push(arr[n-1]);
        right[n-1] = 0;
        for(int i = n-2; i>=0; i--){
            while(!st.isEmpty() && st.peek() >= arr[i]){
                st.pop();
            }
            right[i] = st.isEmpty() ? 0 : st.peek();
            st.push(arr[i]);
        }
        return right;
    }
    private static int[] leftNearest(int[] arr,int n){
        Stack<Integer> st = new Stack<Integer>();
        int[] left = new int[n];
        st.push(arr[0]);
        left[0] = 0;
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && st.peek()>=arr[i]){
                st.pop();
            }
            left[i] = st.isEmpty() ? 0 : st.peek();
            st.push(arr[i]);
        }
        return left;
    }
    public int findMaxDiff(int[] arr) {
        // code here
        int n = arr.length;
        int Left[] = leftNearest(arr,n);
        int Right[] = rightNearest(arr,n);
        int diff = 0;
        for(int i=0; i<n; i++){
            diff = Math.max(Math.abs(Left[i]-Right[i]),diff);
        }
        return diff;
    }
}
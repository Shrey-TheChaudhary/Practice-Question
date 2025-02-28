//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;


// } Driver Code Ends


class Solution {
    public int evaluate(String[] arr) {
       Stack<Integer>st=new Stack<>();
        for(int i=0;i<arr.length;i++)
        {
            String ch=arr[i];
            if(!(ch.equals("+") || ch.equals("-") || ch.equals("/") || ch.equals("*")))
            st.push(Integer.parseInt(arr[i]));
            else
            {
                int a=(st.peek());
                st.pop();
                int b=(st.peek());
                st.pop();
                if(arr[i].equals("*"))
                st.push(b*a);
                else if(arr[i].equals("+"))
                st.push(b+a);
                else if(arr[i].equals("-"))
                st.push(b-a);
                else
                st.push(b/a);
            }
        }
        return st.peek();
    }
}


//{ Driver Code Starts.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        int t = Integer.parseInt(line);
        while (t-- > 0) {
            line = reader.readLine();
            String[] arr = line.split(" ");
            Solution solution = new Solution();
            System.out.println(solution.evaluate(arr));
            System.out.println("~");
        }
    }
}

// } Driver Code Ends
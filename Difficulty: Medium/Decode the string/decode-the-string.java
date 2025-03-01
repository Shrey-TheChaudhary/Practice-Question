//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine());
        while (t-- > 0) {
            String s = in.readLine();

            Solution ob = new Solution();
            out.println(ob.decodeString(s));

            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends



class Solution {
    static String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> st = new Stack<>();
        StringBuilder current = new StringBuilder();
        
        int num = 0;
        
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }
            else if (c == '[') {
                nums.push(num);
                st.push(current);
                current = new StringBuilder();
                num = 0;
            }
            else if (c == ']') {
                StringBuilder temp = current;
                current = st.pop();
                int count = nums.pop();
                current.append(String.valueOf(temp).repeat(count));
            }
            else {
                current.append(c);
            }
        }
        
        return current.toString();
    }
}
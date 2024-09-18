//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution {
    // Function to check if brackets are balanced or not.
    static boolean ispar(String x) {
        Map<Character, Character> map = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        
        // Initialize the mapping of closing brackets to their corresponding opening brackets
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        
        for (int i = 0; i < x.length(); i++) {
            char curr = x.charAt(i);
            
            // If the current character is a closing bracket
            if (map.containsKey(curr)) {
                // Check if the stack is empty or the top of the stack does not match the expected opening bracket
                if (stack.isEmpty() || stack.pop() != map.get(curr)) {
                    return false;
                }
            } else {
                // If it's an opening bracket, push it onto the stack
                stack.push(curr);
            }
        }
        
        // If the stack is empty, all brackets were properly balanced
        return stack.isEmpty();
    }
}


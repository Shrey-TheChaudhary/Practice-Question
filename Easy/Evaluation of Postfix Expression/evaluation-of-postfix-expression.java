//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    System.out.println(new Solution().evaluatePostFix(br.readLine().trim()));
		}
	}
}
// } Driver Code Ends



class Solution
{
    //Function to evaluate a postfix expression.
    public static int evaluatePostFix(String S)
    {
       Stack<Integer> st = new Stack<>();
        char ch[] = S.toCharArray();
        for(char i : ch)
        {
            if(i >= '0'  && i<= '9' )
                st.push((int) i - '0');   // if it is -8 '- 0 ' convert it into 8;

            else
            {
                int op2 = st.pop();
                int op1 = st.pop();

               switch(i)
               {
                   case '+':
                       st.push(op1 + op2);
                       break;
                   case '-':
                       st.push(op1 - op2);
                        break;
                   case '*':
                       st.push(op1 * op2);
                        break;
                   case '/':
                       st.push(op1 / op2);
                        break;
               }
            }
        }
        return st.pop();
    }
}
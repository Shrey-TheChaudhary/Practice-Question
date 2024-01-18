//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG {
	public static void main (String[] args)throws IOException {
		
		BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
		PrintWriter out=new PrintWriter(System.out);
		int t = Integer.parseInt(in.readLine().trim());
        while(t-- > 0)
        {
            int n = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            
            int gallery[] = new int[n];
            for(int i=0; i<n; i++)
                gallery[i] = Integer.parseInt(s[i]);
            Solution T = new Solution();
            out.println(T.min_sprinklers(gallery,n));
        }
		out.close();
		
	}
}





// } Driver Code Ends


//User function Template for Java

class Solution
{
    int min_sprinklers(int gallery[], int n) {
        int[][] rangeArray = new int[n][2];

        for(int index=0; index < n; index++) {
            
            if(gallery[index] == -1)
                continue;
                
            rangeArray[index][0] = index - gallery[index];
            if(rangeArray[index][0] < 0)
                rangeArray[index][0] = 0;

            rangeArray[index][1] = index + gallery[index];
            if(rangeArray[index][1] >= n)
                rangeArray[index][1] = n;
        }
        
       Arrays.sort(rangeArray, (a1,a2) -> a1[0] == a2[0] ? a2[1] - a1[1] : a1[0]-a2[0]);  

        int start=0, index=0, answer=0;
        int currentMax=Integer.MIN_VALUE;

        while(start < n) {

            while(index < n) {

                if(rangeArray[index][0] > start)
                    break;

                currentMax=Math.max(currentMax, rangeArray[index][1]);
                index++;
            }

            if(currentMax < start)
                return -1;

            answer++;
            start=currentMax+1;

        }

        return answer;
    }
}
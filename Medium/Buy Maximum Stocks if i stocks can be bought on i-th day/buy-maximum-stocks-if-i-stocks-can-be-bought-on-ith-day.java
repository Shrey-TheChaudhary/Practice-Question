//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            String str=br.readLine();
    		String[] starr=str.split(" ");
    		
    		//input n and d
    	    int n=Integer.parseInt(starr[0]);
    		int k= Integer.parseInt(starr[1]);
            
            starr = br.readLine().trim().split(" ");
            int[] price = new int[n];
            for(int i = 0; i < n; i++)
                price[i] = Integer.parseInt(starr[i]);
            
            Solution obj = new Solution();
            int res = obj.buyMaximumProducts(n, k, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends

class Solution {
    public static int buyMaximumProducts(int n, int k, int[] price) {
           PriorityQueue<Value> priorityQueue=new PriorityQueue<Value>();
        for(int i=0;i<n;i++)
        {
            priorityQueue.add(new Value(price[i],i+1));
        }
        int count=0;
        while (k>0&&!priorityQueue.isEmpty())
        {
            Value temp=priorityQueue.poll();

            int day=temp.index;

            int value=temp.value;

             while (day>0&&k>=value)
             {
                       k-=value;

                     count++;

                      day--;
             }
        }
        return count;
    }
}
 class Value implements Comparable<Value>
{
    int value,index;
    public Value(int value, int index) {

        this.value = value;

        this.index = index;
    }
    @Override
    public int compareTo(Value o) {
        return Integer.compare(this.value,o.value);
    }
}


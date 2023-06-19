//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int N; 
            N = Integer.parseInt(br.readLine());
            
            
            int K; 
            K = Integer.parseInt(br.readLine());
            
            
            int[] Arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            int res = obj.kthLargest(N, K, Arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int kthLargest(int N, int K, int[] arr) {
        PriorityQueue<Integer>pq=new PriorityQueue<>();
        for(int i=0;i<N;i++)
        {
            int sum=0;
            for(int j=i;j<N;j++)
            {
              sum+=arr[j];
              if(pq.size()<K)
              pq.add(sum);
              else
              {
                if(sum>pq.peek())
                {
                    pq.remove();
                    pq.add(sum);
                }
              }
            }
        }
        return pq.peek();
    }
}

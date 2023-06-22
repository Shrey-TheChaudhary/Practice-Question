//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            
            String arr[] = read.readLine().split(" ");

            Solution ob = new Solution();
            String[] res = ob.findPrefixes(arr,N);
            
            for(int i=0; i<res.length; i++)
                System.out.print(res[i] + " ");
            System.out.println();
        }
    }
}
// } Driver Code Ends



//User function Template for Java

class TrieNode 
{
   TrieNode children [] = new TrieNode [26];
   boolean isEndOfWord = false ;
   
}
class Solution 
{
  static  void insert(TrieNode root, String key) 
  {
  
   TrieNode node = root ;
   for( int i = 0; i < key.length(); i++)
   {
       if(node.children[key.charAt(i) - 'a'] == null)
       {
           TrieNode newNode = new TrieNode ();
           node.children[key.charAt(i) - 'a'] = newNode;
       }
       node = node.children[key.charAt(i) - 'a'] ;
   }
   
   node.isEndOfWord = true;

}

static String search(TrieNode root, String key)
{
  
  int start = 0; 
  int end = 0;
  TrieNode node = root ;
  int count;
   
   for( int i = 0; i < key.length(); i++)
   {
       count = 0 ;
       for(int j= 0 ; j < 26 ; j++)
       {
            if( node.children [j] != null ) 
            count ++;
       }
       if (count > 1 && i!=0 ) 
       end = i ;
       node = node.children[key.charAt(i) - 'a'];
       
   }
     String prefix = key.substring(start, end +1);
     return prefix;
}
   static String[] findPrefixes(String[] arr, int N) {
       
       TrieNode root = new TrieNode ();
       for(int i = 0; i< arr.length; i++) 
       {
           insert (root, arr[i]);
       }
       String [] result = new String [N] ;
       for (int i = 0 ; i < arr.length; i++ )
       {
           result [i] = search(root, arr[i]);
       }
       return result ;
   }
};
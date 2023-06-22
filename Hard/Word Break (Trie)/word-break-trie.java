//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Solution obj = new Solution();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    static Node root;
   static class Node {
       Node[] links = new Node[26];
       boolean flag = false;
       boolean containsKey(char ch) {
           return links[ch - 'a'] != null;
       }
       Node get(char ch) {
           return links[ch - 'a'];
       }
       void put(char ch, Node node) {
           links[ch - 'a'] = node;
       }
       void setEnd() {
           flag = true;
       }
       boolean isEnd() {
           return flag;
       }
   }

   static void insert(String word) {
       Node node = root;
       for (int i = 0; i < word.length(); i++) {
           char c = word.charAt(i);
           if (!node.containsKey(c)) {
               node.put(c, new Node());
           }
           node = node.get(c);
       }
       node.setEnd();
   }
    static boolean search(String s, Node root) {
       Node node = root;
       for (int i = 0; i < s.length(); i++) {
           if (!node.containsKey(s.charAt(i))) {
               return false;
           }
           node = node.get(s.charAt(i));
       }
       return node.isEnd();
   }
   public static boolean wordBreakUtil(String a, Node root) {
       int n = a.length();
       if (n == 0) {
           return true;
       }
       for (int i = 1; i <= n; i++) {
           if (search(a.substring(0, i), root) && wordBreakUtil(a.substring(i, n), root)) {
               return true;
           }
       }
       
       return false;
   }
   
   public static int wordBreak(String s, ArrayList<String> arr )
   {
       root = new Node();
       for (int i = 0; i < arr.size(); i++) {
           insert(arr.get(i));
       }
       if(wordBreakUtil(s, root)){
           return 1;
       }
       return 0;
   }
}
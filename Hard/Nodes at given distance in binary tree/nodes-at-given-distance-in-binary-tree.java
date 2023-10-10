//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}

// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution {
  public static ArrayList < Integer > KDistanceNodes(Node root, int target, int k) {
    // return the sorted list of all nodes at k dist

    ArrayList < Node > path = new ArrayList < > ();
    ArrayList < Integer > result = new ArrayList < > ();

    Node blockNode = null;
    hasPath(root, target, path);
    int n = path.size();
    for (int i = n - 1; i >= 0; i--) {
      if (i == n - 1) {
        blockNode = null;
      } else {
        blockNode = path.get(i + 1);
      }
      moveDown(path.get(i), k - n + i + 1, result, blockNode);
    }
    Collections.sort(result);
    return result;
  }

  public static boolean hasPath(Node root, int x, ArrayList < Node > path) {
    if (root == null)
      return false;
    path.add(root);

    if (root.data == x)
      return true;
    if (hasPath(root.left, x, path) || hasPath(root.right, x, path))
      return true;

    path.remove(path.size() - 1);
    return false;
  }

  public static void moveDown(Node root, int k, ArrayList < Integer > result, Node blockNode) {
    if (root == null || k < 0 || root == blockNode)
      return;
    if (k == 0) {
      result.add(root.data);
      return;
    }
    moveDown(root.left, k - 1, result, blockNode);
    moveDown(root.right, k - 1, result, blockNode);
  }
}


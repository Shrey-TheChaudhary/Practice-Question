//{ Driver Code Starts
// Initial Template for Java

// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}

class MaxSum {
    static Node buildTree(String str) {

        if (str.length() == 0 || str.charAt(0) == 'N') {
            return null;
        }

        String ip[] = str.split(" ");
        // Create the root of the tree
        Node root = new Node(Integer.parseInt(ip[0]));
        // Push the root to the queue

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        // Starting from the second element

        int i = 1;
        while (queue.size() > 0 && i < ip.length) {

            // Get and remove the front of the queue
            Node currNode = queue.peek();
            queue.remove();

            // Get the current node's value from the string
            String currVal = ip[i];

            // If the left child is not null
            if (!currVal.equals("N")) {

                // Create the left child for the current node
                currNode.left = new Node(Integer.parseInt(currVal));
                // Push it to the queue
                queue.add(currNode.left);
            }

            // For the right child
            i++;
            if (i >= ip.length) break;

            currVal = ip[i];

            // If the right child is not null
            if (!currVal.equals("N")) {

                // Create the right child for the current node
                currNode.right = new Node(Integer.parseInt(currVal));

                // Push it to the queue
                queue.add(currNode.right);
            }
            i++;
        }

        return root;
    }

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t > 0) {
            String s = br.readLine();
            Node root = buildTree(s);
            Solution ob = new Solution();
            int ans = ob.getMaxSum(root);
            System.out.println(ans);
            t--;

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java
/*class Node
{
    int data;
    Node left, right;

    Node(int data)
    {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}*/

class Solution {
    // Function to return the maximum sum of non-adjacent nodes.
    HashMap<Node,Long> pick=new HashMap<>();
    HashMap<Node,Long> notPick=new HashMap<>();
    HashMap<Node,Long> dp[]=new HashMap[2];
    
    public int getMaxSum(Node root) {
        // code here
        dp[0]=pick;
        dp[1]=notPick;
        long ans=Math.max(f(root,0),f(root,1));
        return (int)ans;
    }
    // pick==1 means it is picked;
    long f(Node root, int pick){
        if(root==null) return 0;
        if(dp[pick].containsKey(root)) return dp[pick].get(root);
        long ans=0;
        
        if(pick==0){
            ans= Math.max(f(root.left,0),f(root.left,1))+Math.max(f(root.right,0),f(root.right,1));
        }
        else{
            ans=root.data+f(root.left,0)+f(root.right,0);
        }
        dp[pick].put(root,ans);
        return ans;
    }
    
}

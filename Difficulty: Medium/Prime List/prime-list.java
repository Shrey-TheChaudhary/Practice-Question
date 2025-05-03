//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class Node {
    Node next;
    int val;

    public Node(int data) {
        val = data;
        next = null;
    }
}

class Main {
    public static void main(String args[]) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);

        int t;
        t = Integer.parseInt(in.readLine());
        while (t-- > 0) {

            Node head, tail;
            String s[] = in.readLine().trim().split(" ");
            int num = Integer.parseInt(s[0]);
            head = new Node(num);
            tail = head;
            for (int i = 1; i < s.length; i++) {
                num = Integer.parseInt(s[i]);
                tail.next = new Node(num);
                tail = tail.next;
            }
            Solution ob = new Solution();
            Node temp = ob.primeList(head);
            while (temp != null) {
                out.print(temp.val + " ");
                temp = temp.next;
            }
            out.println();
            out.println("~");
        }
        out.close();
    }
}
// } Driver Code Ends


// User function Template for Java
/*
class Node{
    Node next;
    int val;
    public Node(int data){
        val=data;
        next=null;
    }
}
*/

class Solution {
    private Boolean in(int n)
    {
        if(n<=1)
        return false;
        if(n==2)
        return true;
        if(n%2==0)
        return false;
        for(int i=3;i<=Math.sqrt(n);i+=2)
        {
            if(n%i==0)
            return false;
        }
        return true;
    }
    public int np(int n)
    {
        if(in(n))
        {
            return n;
        }
        int l=n-1,u=n+1;
        while(true)
        {
            if(in(l))
            return l;
            if(in(u))
            return u;
            l--;
            u++;
        }
    }
    Node primeList(Node head) 
    {
        Node c=head;
        while (c!=null)
        {
            c.val=np(c.val);
            c=c.next;
        }
        return head;
        // code here
        
    }
}
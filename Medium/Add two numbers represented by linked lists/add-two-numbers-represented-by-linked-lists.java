//{ Driver Code Starts
// driver

import java.util.*;

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG{
    
    static void printList(Node n){
        while(n!=null){
            System.out.print(n.data+" ");
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while (T-- > 0) {
            
            int n = sc.nextInt();
            int val = sc.nextInt();
            
            Node num1 = new Node(val);
            Node tail = num1;
            for(int i=0; i<n-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            int m = sc.nextInt();
            val = sc.nextInt();
            
            Node num2 = new Node(val);
            tail = num2;
            for(int i=0; i<m-1; i++)
            {
                val = sc.nextInt();
                tail.next = new Node(val);
                tail = tail.next;
            }
            
            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);
        }
    }
}

// } Driver Code Ends




/* node for linked list

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

*/

class Solution{
 
    static Node addTwoLists(Node first, Node second){
        first = reverseList(first);
        second = reverseList(second);        
        Node dummy = new Node(-1);
        Node temp = dummy;
        int carry = 0;        
        while (first != null || second != null || carry == 1){
            int sum = 0;
            
            if (first != null){
                sum += first.data;
                first = first.next;
            }
            if (second != null){
                sum += second.data;
                second = second.next;
            }
            sum += carry;
            carry = sum/10;           
            Node newnode = new Node(sum%10);
            temp.next = newnode;
            temp = temp.next;
        }        
        Node ans = reverseList(dummy.next);
        
        while(ans!=null && ans.data == 0)ans = ans.next;
        
        return (ans==null)?new Node(0):ans;
        
    }   
    
    static Node reverseList(Node head){
        
        if (head == null || head.next == null)return head;            
        
        Node prev = null , curr = head , next = null;
        
        while(curr!=null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        
        return prev;
    }
}
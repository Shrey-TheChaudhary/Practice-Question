//{ Driver Code Starts
// driver

import java.io.*;
import java.util.*;


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

class Solution {
    static Node addTwoLists(Node num1, Node num2) {
        // code here
        Stack<Integer> stack1 = new Stack<>(), stack2 = new Stack<>();
        Node temp = num1;
        while(temp != null){
            stack1.push(temp.data);
            temp = temp.next;
        }
        temp = num2;
        while(temp != null){
            stack2.push(temp.data);
            temp = temp.next;
        }
        int carry = 0;
        Node ans = null;
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            int sum = carry;
            if(!stack1.isEmpty() ) sum += stack1.pop();
            if(!stack2.isEmpty() ) sum += stack2.pop();
            carry = sum /10;
            Node node = new Node(sum % 10);
            node.next = ans;
            ans = node;
        }
        if(carry==1){
            Node node = new Node(1);
            node.next = ans;
            ans = node;
        }
        while(ans.next!=null && ans.data==0){
            ans= ans.next;
        }
        return ans;
    }
}

//{ Driver Code Starts.

class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

class GfG {

    static void printList(Node n) {
        while (n != null) {
            System.out.print(n.data + " ");
            n = n.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(read.readLine());
        while (T-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            Node num1 = new Node(Integer.parseInt(str[0]));
            Node tail = num1;
            for (int i = 1; i < n; i++) {
                int val = Integer.parseInt(str[i]);
                tail.next = new Node(val);
                tail = tail.next;
            }

            String str2[] = read.readLine().trim().split(" ");
            int m = str2.length;

            Node num2 = new Node(Integer.parseInt(str2[0]));
            tail = num2;
            for (int i = 1; i < m; i++) {

                tail.next = new Node(Integer.parseInt(str2[i]));
                tail = tail.next;
            }

            Solution g = new Solution();
            Node res = g.addTwoLists(num1, num2);
            printList(res);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends
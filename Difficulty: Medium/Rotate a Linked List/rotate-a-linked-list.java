//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}


// } Driver Code Ends
/* node of linked list:

class Node{
    int data;
    Node next;
    Node(int d){
        data=d;
        next=null;
    }
}

*/

class Solution {
    public Node rotate(Node head, int k) {
        // add code here
        int lSize = size(head);
        k = k % lSize;
        Node reverseHead = reverseNode(head);
        // reverse first lSize-k node 
        Node nextNode = null;
        Node curr = reverseHead;
        for (int i = 0; i < lSize-k-1; i++) {
            curr = curr.next;
        }
        nextNode = curr.next;
    curr.next = null; // disconnect the first part
    Node reverseStartingNode = reverseNode(reverseHead);
    Node reverseNextNode = reverseNode(nextNode);
    // Find the last node of the first reversed segment
    Node temp = reverseStartingNode;
    while (temp.next != null) {
        temp = temp.next;
    }
    temp.next = reverseNextNode; // connect the two parts
    return reverseStartingNode;
        
    }
    private static Node reverseNode(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    private static int size(Node node) {
        int count = 0;
        Node curr = node;
        while (curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }
}

//{ Driver Code Starts.

public class GFG {
    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            String input = br.readLine().trim();
            if (!input.isEmpty()) {
                String[] numbers = input.split("\\s+");
                for (String num : numbers) {
                    if (!num.isEmpty()) {
                        arr.add(Integer.parseInt(num));
                    }
                }
            }

            Node head = null;
            if (!arr.isEmpty()) {
                head = new Node(arr.get(0));
                Node tail = head;
                for (int i = 1; i < arr.size(); ++i) {
                    tail.next = new Node(arr.get(i));
                    tail = tail.next;
                }
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution ob = new Solution();
            head = ob.rotate(head, k);
            printList(head);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends
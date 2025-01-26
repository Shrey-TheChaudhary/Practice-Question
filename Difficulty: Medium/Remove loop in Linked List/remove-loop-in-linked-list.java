//{ Driver Code Starts
// driver code

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;
}

class GFG {
    public static Node newNode(int data) {
        Node temp = new Node();
        temp.data = data;
        temp.next = null;
        return temp;
    }

    public static void makeLoop(Node head, int x) {
        if (x == 0) return;
        Node curr = head;
        Node last = head;

        int currentPosition = 1;
        while (currentPosition < x) {
            curr = curr.next;
            currentPosition++;
        }

        while (last.next != null) last = last.next;
        last.next = curr;
    }

    public static boolean detectLoop(Node head) {
        Node hare = head.next;
        Node tortoise = head;
        while (hare != tortoise) {
            if (hare == null || hare.next == null) return false;
            hare = hare.next.next;
            tortoise = tortoise.next;
        }
        return true;
    }

    public static int length(Node head) {
        int ret = 0;
        while (head != null) {
            ret += 1;
            head = head.next;
        }
        return ret;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {

            String str[] = read.readLine().trim().split(" ");
            int n = str.length;

            int num = Integer.parseInt(str[0]);
            Node head = newNode(num);
            Node tail = head;

            for (int i = 1; i < n; i++) {
                num = Integer.parseInt(str[i]);
                tail.next = newNode(num);
                tail = tail.next;
            }

            int pos = Integer.parseInt(read.readLine());
            makeLoop(head, pos);

            Solution x = new Solution();
            x.removeLoop(head);

            if (detectLoop(head) || length(head) != n)
                System.out.println("false");
            else
                System.out.println("true");

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


/*
class Node
{
    int data;
    Node next;
}
*/

class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        if (head == null || head.next == null) {
            return; // No loop possible in an empty list or a single-node list.
        }

        Node slow = head;
        Node fast = head;

        // Step 1: Detect the loop using slow and fast pointers.
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Loop detected.
            if (slow == fast) {
                break;
            }
        }

        // If no loop is detected, return.
        if (fast == null || fast.next == null) {
            return;
        }

        // Step 2: Find the starting node of the loop.
        slow = head;
        if (slow == fast) {
            // Special case: The loop starts at the head node.
            while (fast.next != slow) {
                fast = fast.next;
            }
        } else {
            // General case: Move slow and fast one step at a time.
            while (slow.next != fast.next) {
                slow = slow.next;
                fast = fast.next;
            }
        }

        // Step 3: Break the loop by setting the next of the last node in the loop to null.
        fast.next = null;
    }
}
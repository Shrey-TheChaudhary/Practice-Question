/*
class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}
*/

class Solution {

    private Node findMid(Node head) {
        Node slow = head, fast = head.next; // start fast ahead
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private Node merge(Node left, Node right) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (left != null && right != null) {
            if (left.data <= right.data) {
                tail.next = left;
                left = left.next;
            } else {
                tail.next = right;
                right = right.next;
            }
            tail = tail.next;
        }

        // Attach remaining nodes
        tail.next = (left != null) ? left : right;
        return dummy.next;
    }

    public Node mergeSort(Node head) {
        if (head == null || head.next == null) return head;

        Node mid = findMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        Node left = mergeSort(head);
        Node right = mergeSort(rightHead);

        return merge(left, right);
    }
}
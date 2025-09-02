/*
class Node {
    int data;
    Node next;

    Node(int x) {
        data = x;
        next = null;
    }
}
*/
class Solution {
    public Node swapKth(Node head, int k) {
         if (head == null || k <= 0) 
        return head; 
// Step 1: Count the number of nodes in the list 
    int count = 0;
    Node curr = head; 
    while (curr != null) {
        count++; 
        curr = curr.next; 
        
    } 
// If k is more than the number of nodes, return head 
    if (k > count) return head; 
// Step 2: Find the k-th node from the beginning and the end 
    Node first = head, firstPrev = null; 
    for (int i = 1; i < k; i++) {
        firstPrev = first; 
        first = first.next; 
        
    } 
    Node second = head, secondPrev = null;
    for (int i = 1; i < count - k + 1; i++) {
        secondPrev = second;
        second = second.next; 
        
    } 
// Step 3: Swap the k-th nodes from the beginning and end 
    if (firstPrev != null) 
        firstPrev.next = second; 
    if (secondPrev != null) 
        secondPrev.next = first; 
    Node temp = first.next; 
    first.next = second.next; 
    second.next = temp; 
// If k-th node from the beginning is the head of the list 
    if (k == 1) 
        head = second; 
// If k-th node from the end is the head of the list 
    if (k == count) 
        head = first; 
    return head;
    }
}

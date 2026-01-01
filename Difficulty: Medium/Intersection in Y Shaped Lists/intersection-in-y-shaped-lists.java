/*
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
    public Node intersectPoint(Node head1, Node head2) {
        // code here
         Set<Node> set = new HashSet<>();
        
        while (head1 != null) {
            set.add(head1);
            head1 = head1.next;
        }
        
        while (!set.contains(head2)) {
            head2 = head2.next;
        }
        return head2;
    }
}
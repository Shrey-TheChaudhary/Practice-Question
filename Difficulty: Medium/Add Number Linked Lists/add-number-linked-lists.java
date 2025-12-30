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
    public Node addTwoLists(Node head1, Node head2) {
        // code here
         if(head1 == null && head2 == null) return head1;
        if(head1 == null) return head2;
        if(head2 == null) return head1;
        
        Node n1 = REV(head1);
        Node n2 = REV(head2);
        
        Node ans = REV(ADD(n1, n2));
        return RMV(ans);
    }
    
    private Node RMV(Node a) {
        
        Node curr = a;
        if(curr.data != 0) return curr;
        Node dummy = new Node(-1);
        Node ans = dummy;
        
        while(curr != null) {
            if(curr.data != 0) {
                ans.next = curr;
                return dummy.next;
            } else {
                curr = curr.next;
            }
        }
        
        return null;
    }
    
    private Node ADD(Node a, Node b) {
        
        Node dummy = new Node(-1);
        Node ans = dummy;
        int carry = 0;
        while(a != null || b != null || carry != 0) {
            int x = a == null ? 0 : a.data;
            int y = b == null ? 0 : b.data;
            int s = x + y + carry;
            carry = s/10;
            int coef = s%10;
            Node newNode = new Node(coef);
            ans.next = newNode;
            ans = newNode;
            if(a != null) a = a.next;
            if(b != null) b = b.next;
        }
        return dummy.next;
    }
    
    private Node REV(Node head) {
        
        Node curr = head;
        Node prev = null;
        Node next = curr.next;
        
        while(curr != null) {
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) next = next.next;
        }
        
        return prev;
    }
}
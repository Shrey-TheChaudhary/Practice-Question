class Solution {
    public boolean isPalindrome(Node head) {
        // code here
        if(head.next == null)   return true;

        Node fast = head, slow = head, prev = null, nextStart = null;
        while (fast != null) {
            fast = fast.next;
            if (fast == null) { // edge case -> odd no of items, dont consider middle
                nextStart = slow.next;
                slow = prev;
                break;
            }
            if(fast.next == null)    break;
            fast = fast.next;

            // reverse previous pointers of slow
            Node temp = slow;
            slow = slow.next;
            temp.next = prev;
            prev = temp;
        }

        if(slow != null && nextStart == null) {
            nextStart = slow.next;
            slow.next = prev;
        }

        // simple check for palindrome
        while (nextStart != null && slow != null) {
            if (nextStart.data != slow.data)    return false;
            nextStart = nextStart.next;
            slow = slow.next;
        }

        return slow == null && nextStart == null;
    }
}
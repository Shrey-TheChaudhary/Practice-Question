/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        
        if(head == null || head.next == null)
            return true;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null && fast.next.next!=null)         {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // reverse the second part of linked list
        ListNode curr = slow.next;
        ListNode prev = null;
        while(curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        
        fast = prev; // head of second part
        slow = head; // head of first part
        while(slow != null && fast != null)
        {
            if (slow.val != fast.val)
                return false;
            
            slow = slow.next;
            fast = fast.next;
        }
        
        return true;
    }
}
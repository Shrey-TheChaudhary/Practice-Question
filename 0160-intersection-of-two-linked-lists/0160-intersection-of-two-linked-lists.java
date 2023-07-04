/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) 
            return null;
        
        ListNode p = headA;
        ListNode q = headB;
        while (p != q) 
        {
            p =  (p != null) ? p.next : headB;
            q =  (q != null) ? q.next : headA;
        }
        return p;
    }
}
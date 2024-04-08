/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
// public class Solution {
//     public ListNode detectCycle(ListNode head) {
//         //using hashset
//         Set<ListNode> nodes = new HashSet<>();
//         while (head != null && !nodes.contains(head)) {
//             nodes.add(head);
//             head = head.next;
//         }
//         return head;
//     }
// }

public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        
        while (fast != null && fast.next != null) 
        {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) 
            {
                slow = head;
                
                while (slow != fast) 
                {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}
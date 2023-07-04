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
public class Solution {
    public ListNode detectCycle(ListNode head) {
        //using hashset
        Set<ListNode> nodes = new HashSet<>();
        while (head != null && !nodes.contains(head)) {
            nodes.add(head);
            head = head.next;
        }
        return head;
    }
}
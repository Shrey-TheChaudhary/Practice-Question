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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode point1 = list1;
        int count = 1;
        while (count != a) {
            point1 = point1.next;
            count++;
        }

        ListNode point2 = point1.next;
        while (count != b + 1) {
            point2 = point2.next;
            count++;
        }

        point1.next = list2;
        ListNode temp = list2;
        while (temp.next != null)
            temp = temp.next;

        temp.next = point2;

        return list1;
    }
};
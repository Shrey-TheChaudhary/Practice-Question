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
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode slow=head;
        ListNode fast=head;
        ListNode prev=null;

        while(fast!=null && fast.next!=null){
            prev=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode l1=sortList(head);
        ListNode l2=sortList(slow);
        
        return mergeSort(l1,l2);
    }
    public ListNode mergeSort(ListNode list1, ListNode list2) {
        ListNode ans=new ListNode(-1);
        ListNode temp=ans;
        
        while(list1 != null && list2 != null){
            if(list1.val > list2.val){
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
            else if(list1.val < list2.val){
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
            }
            else {
                temp.next = list1;
                list1 = list1.next;
                temp = temp.next;
                temp.next = list2;
                list2 = list2.next;
                temp = temp.next;
            }
        }

        if(list1 != null){
            temp.next = list1;
        }
        if(list2 != null){
            temp.next = list2;
        }
        return ans.next;
    }
}
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
       public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) 
            return null;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for(ListNode node : lists)
        {
            while(node != null)
            {
                priorityQueue.add(node.val);
                node = node.next;
            }
        }

        ListNode head;
        if(!priorityQueue.isEmpty()) 
            head = new ListNode(priorityQueue.poll());
        else 
            return null;
        

        ListNode temp = head;
        while(!priorityQueue.isEmpty()){
            temp.next = new ListNode(priorityQueue.poll());
            temp = temp.next;
        }
        temp.next = null;
        return head;
    }
}
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
// class Solution {
//        public ListNode mergeKLists(ListNode[] lists) {
//         ListNode ans = null;
//         for (ListNode list : lists) {
//             ans = mergeTwoLists(ans, list);
//         }
//         return ans;
//     }

//     public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//         if (l1 == null) 
//             return l2;
        
//         if (l2 == null) 
//             return l1;
        
//         if (l1.val < l2.val) 
//         {
//             l1.next = mergeTwoLists(l1.next, l2);
//             return l1;
//         } 
//         else 
//         {
//             l2.next = mergeTwoLists(l1, l2.next);
//             return l2;
//         }
//     }
// }

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
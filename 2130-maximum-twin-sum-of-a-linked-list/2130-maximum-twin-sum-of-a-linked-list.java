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
    public int pairSum(ListNode head) {
         int[] arr = new int[100000];
    int n = 0;
    while (head != null)
    {
        arr[n++] = head.val;
        head = head.next;
    }
    int maxSum = 0;
    for (int i = 0; i < n / 2; i++) 
    {
        int twinSum = arr[i] + arr[n - 1 - i];
        maxSum=Math.max(maxSum,twinSum);
    }
    return maxSum;
    }
        
}
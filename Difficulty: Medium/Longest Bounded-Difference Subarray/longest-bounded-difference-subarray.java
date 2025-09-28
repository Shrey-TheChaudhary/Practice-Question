import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

class Solution{
    static ArrayList<Integer> longestSubarray(int[] arr, int x) {
        
        Deque<Integer> minQueue = new LinkedList<>();
        Deque<Integer> maxQueue = new LinkedList<>();
        
        int n = arr.length, start = 0, end = 0;
        
        int resStart = 0, resEnd = 0;
        while (end < n) {
            
            while (!minQueue.isEmpty() && arr[minQueue.peekLast()] > arr[end])
                minQueue.pollLast();
           
            while (!maxQueue.isEmpty() && arr[maxQueue.peekLast()] < arr[end])
                maxQueue.pollLast();
                
            minQueue.addLast(end);
            maxQueue.addLast(end);
            
            while (arr[maxQueue.peekFirst()] - arr[minQueue.peekFirst()] > x) {
                       
                if (start == minQueue.peekFirst())
                    minQueue.pollFirst();
                if (start == maxQueue.peekFirst())
                    maxQueue.pollFirst();
                start += 1;
            }
            
            if (end - start > resEnd - resStart) {
                resStart = start;
                resEnd = end;
            }
            end += 1;
        }

       
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = resStart; i <= resEnd; i++)
            res.add(arr[i]);
            
        return res;
    }
}
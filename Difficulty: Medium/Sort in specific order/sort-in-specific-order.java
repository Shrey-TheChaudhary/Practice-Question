import java.util.*;

class Solution {
    public void sortIt(int[] arr) {
 
        PriorityQueue<Integer> odd = new PriorityQueue<>(Comparator.reverseOrder());
        
        PriorityQueue<Integer> even = new PriorityQueue<>();
        
        for(int n:arr)
        {
            if(n%2==0) even.offer(n);
            else odd.offer(n);
        }
        
        int i=0;
        
        while(!odd.isEmpty())
        {
            arr[i++]=odd.poll();
        }
        
        while(i<arr.length)
        {
            arr[i++]=even.poll();
        }
    }
}


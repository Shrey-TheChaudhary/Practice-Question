//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            int[] nums = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                nums[i] = Integer.parseInt(parts[i]);
            }
            Solution ob = new Solution();
            ArrayList<Double> ans = ob.getMedian(nums);
            for (double i : ans) {
                System.out.printf("%.1f ", i);
            }
            System.out.println();
            System.out.println("~");
        }
        sc.close();
    }
}

// } Driver Code Ends

class MedianFinder {
     PriorityQueue<Integer> q1= new PriorityQueue<>((a,b)->b-a);
     PriorityQueue<Integer> q2= new PriorityQueue();
    MedianFinder() {
        
    }
    
    void addNum(int num) {
        
        if(q1.isEmpty() || q1.peek()>num)
        {
            q1.add(num);
        }
        else
            q2.add(num);
        
        if(q1.size()>q2.size()+1)
        {
            q2.add(q1.peek());
            q1.remove();
        }
        
         if(q2.size()>q1.size()+1)
        {
            q1.add(q2.peek());
            q2.remove();
        }
        
    }
    
    double findMedian() {
        
         if(q2.size()==q1.size())
         {    
             return (q1.peek()+q2.peek())/2.0;
         }
         if(q2.size()>q1.size())
         {
             return q2.peek(); 
         }
        else
            return q1.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder* obj = new MedianFinder();
 * obj->addNum(num);
 * double param_2 = obj->findMedian();
 */
class Solution {
    public ArrayList<Double> getMedian(int[] arr) {
        MedianFinder md=new MedianFinder();
        ArrayList<Double> ans= new ArrayList<>();
        for(int a:arr){
            md.addNum(a);
            ans.add(md.findMedian());
        }
        
        return ans;
    }
}
//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}

class GFG {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t-- > 0){
		    int n = sc.nextInt();
		    Node head = null, tail = null;
		    
		    char head_c = sc.next().charAt(0);
		    head = new Node(head_c);
		    tail = head;
		    
		    while(n-- > 1){
		        tail.next = new Node(sc.next().charAt(0));
		        tail = tail.next;
		    }
		    
		    Solution obj = new Solution();
		    //show(head);
		    show(obj.arrangeCV(head));
		    
		}
	}
	
	public static void po(Object o){
	    System.out.println(o);
	}
	
	public static void show(Node head){
        while(head != null){
            System.out.print(head.data+" ");
            head = head.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/*
Structure of node class is:
class Node {
    char data;
    Node next;
    
    public Node(char data){
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    
    public Node arrangeCV(Node head){
        //write code here and return the head of changed linked list
        ArrayList<Character> v = new ArrayList<>();
        ArrayList<Character> C = new ArrayList<>();
        Node temp = head;
        while(temp !=null){
            char ch1 = temp.data;
            if(isVowel(ch1)){
                v.add(ch1);
            }else{
                C.add(ch1);
            }
            temp = temp.next;
        }
        Node tem = head;
        int n1 = v.size();
        int n2 = C.size();
        for(int i =0; i< n1; i++){
            tem.data = v.get(i);
            tem = tem.next;
        }
        for(int i =0; i< n2; i++){
            tem.data = C.get(i);
            tem = tem.next;
        }
        return head;
    }
    private  boolean isVowel(char ch){
        if(ch =='a'|| ch=='e' || ch == 'i' || ch == 'o' || ch == 'u' ){
            return true;
        }else{
            return false;
        }
    }
}
//{ Driver Code Starts
import java.util.Scanner;

// Node Class
class Node {
    int data;
    Node next;

    Node(int val) {
        data = val;
        next = null;
    }
}

// Linked List Class
class LinkedList {
    Node head;
    Node tail;

    LinkedList() {
        head = null;
        tail = null;
    }

    // creates a new node with given value and appends it at the end of the linked list
    void insert(int val) {
        if (head == null) {
            head = new Node(val);
            tail = head;
        } else {
            tail.next = new Node(val);
            tail = tail.next;
        }
    }
}


public class Main {
    static void printList(Node n) 
    {
        while (n != null) {
            System.out.print(n.data);
            n = n.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; ++i) {
            int n = sc.nextInt();
            LinkedList LL1 = new LinkedList();
            String l1 = sc.next();
            for (int j = 0; j < n; ++j) {
                int x = Character.getNumericValue(l1.charAt(j));
                LL1.insert(x);
            }

            int m = sc.nextInt();
            LinkedList LL2 = new LinkedList();
            String l2 = sc.next();
            for (int j = 0; j < m; ++j) {
                int x = Character.getNumericValue(l2.charAt(j));
                LL2.insert(x);
            }

            Solution ob = new Solution();
            Node res = ob.subLinkedList(LL1.head, LL2.head);
            printList(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next;

    Node(int x){
        data = x;
        next = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution
{
   static Node removeLeadingZeros(Node a)
  {
      if (a != null && a.data == 0)
          return removeLeadingZeros(a.next);
      else
          return a;
  }

  static Node reverse(Node head)
  {
      Node prev = null, curr = head, ptr = null;
      while(curr!=null)
      {
          ptr = curr.next;
          curr.next = prev;
          prev = curr;
          curr = ptr;
      }
      return prev;
  }
  
  static int length (Node head){
      int count = 0;
      while(head != null){
          count ++;
          head = head.next;
          
      }
      return count;
      
  }
  
  static Node findlarger (Node l1, int len1, Node l2, int len2){
      
       Node temp1 = l1;
       Node temp2 = l2;

       if(len1>len2)
       {
          temp1 = l1;
          temp2 = l2;
      }
      else if(len1<len2)
      {
          temp1 = l2;
          temp2 = l1;
      }
      else // if both have equal length
      {
          while (temp1 != null && temp2 != null)
          {
              if (temp1.data > temp2.data)
              {
                  temp1 = l1;
                  temp2 = l2;
                  break;
              }
              else if(temp1.data < temp2.data)
              {
                  temp1 = l2;
                  temp2 = l1;
                  break;
              }
              temp1 = temp1.next;
              temp2 = temp2.next;
          }
          
          if(temp1==null && temp2==null) // both represents equal number
          {
              return new Node(0);
              
          }
      }
      return subtract(temp1, temp2);
      
  }

  static Node subtract(Node n1, Node n2){

           Node l1 = n1;
           Node l2 = n2;

           l1 = reverse(l1);
           l2 = reverse(l2);

           Node res = new Node(-1);
           Node temp = res;

           int borrow = 0;
           int diff = 0;

           while(l1 != null){

               diff = borrow + l1.data - ((l2 != null)?l2.data:0);

               if(diff < 0){
                   borrow = -1;
                   diff = 10 + diff;
               }else {
                   borrow = 0;
                   //diff = 0;
               }

               temp.next = new Node(diff);
               temp = temp.next;

               if(l1 != null){
                   l1=l1.next;
               }
               if(l2 != null){
                   l2=l2.next;
               }

           }
           res = reverse(res.next);
           res = removeLeadingZeros(res);
           return res;
       }

 static Node subLinkedList(Node l1, Node l2)
       {
           l1 = removeLeadingZeros(l1);
           l2 = removeLeadingZeros(l2);
           
           int len1 = length(l1);
           int len2 = length(l2);
           
           if(len1 == 1 && l1.data == 0){
               return l2;
           }
           if(len2 == 1 && l2.data == 0){
               return l1;
           }
           
           return findlarger(l1, len1, l2, len2);

       }
}   

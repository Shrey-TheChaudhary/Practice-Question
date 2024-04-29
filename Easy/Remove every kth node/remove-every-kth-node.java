//{ Driver Code Starts
import java.util.*;
class Node
{
	Node next;
	int data;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
}
class Delete_Kth_Node
{
	Node head;
	Node tail;
	
	void addToTheLast(Node node){
		if(head == null){
		head = node;
		tail = node;
		}
		else
		{
		    tail.next = node;
		    tail = tail.next ;
		}
	}	
	public static void main(String args[])
    {
         Scanner sc = new Scanner(System.in);
		 int t=sc.nextInt();		 
		 while(t>0)
         {
			int n = sc.nextInt();
			Delete_Kth_Node list = new Delete_Kth_Node();
			//int n=Integer.parseInt(br.readLine());
			int a1=sc.nextInt();
			Node head= new Node(a1);
            list.addToTheLast(head);
            for (int i = 1; i < n; i++) 
			{
				int a = sc.nextInt(); 
				list.addToTheLast(new Node(a));
			}
			int k = sc.nextInt();					  
			//System.out.println(list.head.data+" "+ k);
			list.head = new Solution().delete(list.head,k); 
			Node temp = list.head;
			while(temp!=null)
			{
				System.out.print(temp.data+ " ");
			    temp = temp.next;
			}
			System.out.println();
			t--;
		}
	}
}
// } Driver Code Ends


/* Link list Node
class Node
{
	Node next;
	int data;
	Node(int d)
	{
		data = d;
		next = null;
	}
}*/
class Solution
{
    Node delete(Node head, int k)
    {
// Your code here
    int sz=0; //CALCULATE THE SIZE 
    Node temp=head;
    while(temp!=null){
        sz++;
        temp=temp.next;
    }
    if(k>sz){  // IN THIS CASE NO NODE WILL DELETE 
        return head;
    }
    if(k==1){ //IN THIS CASE ALL NODE GET DELETED 
        return null;
    }
    temp=head;
    int n=k;
    k=k-1; //NOW WE ARE SKIPING K-1 TIMES TILL THE VALUE OF K==1
    while(temp!=null && temp.next!=null){
        if(k==1){
            temp.next=temp.next.next; //WHEN K==1 WE SKIP OUR NODE
            k=n;
        }
        temp=temp.next;
        k--; //SKIPING ELEMENT
    }
    return head;
    }
}
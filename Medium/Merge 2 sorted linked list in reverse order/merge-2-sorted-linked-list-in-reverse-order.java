//{ Driver Code Starts
import java.util.*;
import java.io.*;

class Node
{
    int data;
    Node next;

    Node(int d)
    {
        data = d;
        next = null;
    }
}


public class MainClass {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int t=scanner.nextInt();
        while(t-->0)
        {
            int N = scanner.nextInt();
            int M = scanner.nextInt();

            Node node1 = null;
            Node temp1 = null;
            for (int i = 0; i < N; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node1 == null) {
                    node1 = newNode;
                    temp1 = node1;
                } else {
                    temp1.next = newNode;
                    temp1 = temp1.next;
                }
            }
    
            Node node2 = null;
            Node temp2 = null;
            for (int i = 0; i < M; i++) {
                int value = scanner.nextInt();
                Node newNode = new Node(value);
                if (node2 == null) {
                    node2 = newNode;
                    temp2 = node2;
                } else {
                    temp2.next = newNode;
                    temp2 = temp2.next;
                }
            }
    
            GfG gfg = new GfG();
            Node result = gfg.mergeResult(node1, node2);
    
            printList(result);
        }
    }

    static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

// } Driver Code Ends


/* Structure of the node*/
/* class Node
{
	int data;
	Node next;
	
	Node(int d)
	{
		data = d;
		next = null;
	}
} */

class GfG
{
    Node mergeResult(Node node1, Node node2)
    {
	Node res = new Node(0);
        Node temp = res;
        Node curr1 = node1;
        Node curr2 = node2;
         
        while(curr1 != null && curr2 != null){
            if(curr1.data < curr2.data){
                Node newNode = new Node(curr1.data);
                newNode.next = temp.next;
                temp.next = newNode;
                curr1 = curr1.next;
            }else{
                Node newNode = new Node(curr2.data);
                newNode.next = temp.next;
                temp.next = newNode;
                curr2 = curr2.next;
            }
        }
        while(curr1 != null){
            Node newNode = new Node(curr1.data);
            newNode.next = temp.next;
            temp.next = newNode;
            curr1 = curr1.next;
        }
        while(curr2 != null){
            Node newNode = new Node(curr2.data);
            newNode.next = temp.next;
            temp.next = newNode;
            curr2 = curr2.next;
        }
        return res.next;
    }
}

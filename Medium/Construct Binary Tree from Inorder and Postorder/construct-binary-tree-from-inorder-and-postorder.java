//{ Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node left;
    Node right;

    Node(int value) {
        data = value;
        left = null;
        right = null;
    }
}

class InorderPostorderToTree {
    public void preOrder(Node root) {
        if (root == null) return;

        System.out.print(root.data + " ");
        preOrder(root.left);

        preOrder(root.right);
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        InorderPostorderToTree ip = new InorderPostorderToTree();
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int inorder[] = new int[n];
            int postorder[] = new int[n];
            for (int i = 0; i < n; i++) inorder[i] = sc.nextInt();
            for (int i = 0; i < n; i++) postorder[i] = sc.nextInt();
            GfG g = new GfG();
            Node root = g.buildTree(inorder, postorder, n);
            ip.preOrder(root);
            System.out.println();

            T--;
        }
    }
}

// } Driver Code Ends


/* Tree node structure
class Node
{
    int data;
    Node left;
    Node right;

        Node(int value)
    {
        data = value;
        left = null;
        right = null;
    }
}*/


class GfG
{    
    Node tree(int is, int ie, int in[], int ps, int pe, int post[], HashMap<Integer, Integer> mp) 
    {
        if(is > ie || ps > pe)
            return null;
            
        Node root = new Node(post[pe]);
        int inroot = mp.get(root.data);
        int numsLeft = inroot - is;
        
        root.left = tree(is, inroot - 1, in, ps, ps + numsLeft - 1, post, mp);
        root.right = tree(inroot + 1, ie, in, ps + numsLeft, pe - 1, post, mp);
        
        return root;
    }

    Node buildTree(int in[], int post[], int n)
    {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i = 0; i < n; i++)
            mp.put(in[i], i);
        
        return tree(0, n - 1, in, 0, n - 1, post, mp);
    }
}
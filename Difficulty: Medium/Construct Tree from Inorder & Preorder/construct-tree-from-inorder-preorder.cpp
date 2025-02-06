//{ Driver Code Starts
#include <bits/stdc++.h>
using namespace std;

// Definition of the Node class
class Node {
  public:
    int data;
    Node *left;
    Node *right;

    Node(int x) {
        data = x;
        left = NULL;
        right = NULL;
    }
};

// Function to print the tree in postorder traversal
void printPostOrder(Node *root) {
    if (root == NULL)
        return;
    printPostOrder(root->left);
    printPostOrder(root->right);
    cout << root->data << " ";
}


// } Driver Code Ends
// Class that contains the logic to build the binary tree
/*
Definition of the Node class
class Node {
public:
    int data;
    Node *left;
    Node *right;

    Node(int x) {
        data = x;
        left = NULL;
        right = NULL;
    }
};
*/
class Solution {
  public:
  int searchvalue(vector<int>& inorder , int value , int s , int e){
      for(int i = s ; i<= e ; i++){
          if(inorder[i] == value){
              return i;
          }
      }
      return -1;
  }
  Node* buildtree(vector<int>& inorder , vector<int> & preorder , int &preindex , int s , int e){
      if(s > e){
          return NULL;
      }
      
      Node* root = new Node(preorder[preindex]);
      preindex++;
      
      int index = searchvalue(inorder , preorder[preindex -1] , s , e);
      
      root->left = buildtree(inorder , preorder , preindex , s , index -1);
      root->right = buildtree(inorder , preorder , preindex , index +1 , e);
      
      return root;
  }
    Node *buildTree(vector<int> &inorder, vector<int> &preorder) {
       int n = preorder.size();
       int preindex =0;
      Node* root = buildtree(inorder , preorder , preindex , 0 , n-1);
      
      return root;
    }
};

//{ Driver Code Starts.

// Main function where the test cases are handled
int main() {
    int t;
    cin >> t;
    cin.ignore();

    while (t--) {
        vector<int> inorder, preorder;

        // Input the inorder traversal
        string input;
        getline(cin, input);
        stringstream ss1(input);
        int num;
        while (ss1 >> num)
            inorder.push_back(num);

        // Input the preorder traversal
        getline(cin, input);
        stringstream ss2(input);
        while (ss2 >> num)
            preorder.push_back(num);

        // Create Solution object and build the tree
        Solution obj;
        Node *root = obj.buildTree(inorder, preorder);

        // Print the postorder traversal of the constructed tree
        printPostOrder(root);
        cout << endl;
        cout << "~" << endl;
    }
    return 0;
}

// } Driver Code Ends
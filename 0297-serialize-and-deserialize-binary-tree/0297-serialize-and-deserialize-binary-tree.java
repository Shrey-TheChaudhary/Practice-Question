/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        
        if (root == null) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        // Use a queue for level-order traversal
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // Perform level-order traversal
        while (!q.isEmpty()) {
            TreeNode curNode = q.poll();
            
            if (curNode == null) 
                sb.append("#,");
         else
         {
                sb.append(curNode.val).append(",");
                q.offer(curNode.left);
                q.offer(curNode.right);
            }
        }
        return sb.toString();
    }

    public TreeNode deserialize(String data) {
        // Check if the serialized data is empty
        if (data.isEmpty()) {
            return null;
        }

        // Use a StringBuilder to tokenize the serialized data
        StringBuilder s = new StringBuilder(data);
        // Read the root value from the serialized data
        int commaIndex = s.indexOf(",");
        String str = s.substring(0, commaIndex);
        s.delete(0, commaIndex + 1);
        TreeNode root = new TreeNode(Integer.parseInt(str));

        // Use a queue for level-order traversal
        Queue<TreeNode> q = new LinkedList<>();
        // Start with the root node
        q.offer(root);

        // Perform level-order traversal to reconstruct the tree
        while (!q.isEmpty()) {
            // Get the front node in the queue
            TreeNode node = q.poll();

            // Read the value of the left child from the serialized data
            commaIndex = s.indexOf(",");
            str = s.substring(0, commaIndex);
            s.delete(0, commaIndex + 1);
            // If the value is not "#", create a new left child and push it to the queue
            if (!str.equals("#")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(str));
                node.left = leftNode;
                q.offer(leftNode);
            }

            // Read the value of the right child from the serialized data
            commaIndex = s.indexOf(",");
            str = s.substring(0, commaIndex);
            s.delete(0, commaIndex + 1);
            // If the value is not "#", create a new right child and push it to the queue
            if (!str.equals("#")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(str));
                node.right = rightNode;
                q.offer(rightNode);
            }
        }
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));
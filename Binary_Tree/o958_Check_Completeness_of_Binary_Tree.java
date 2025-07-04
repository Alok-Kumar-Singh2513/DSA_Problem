public class o958_Check_Completeness_of_Binary_Tree {
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
            left = right = null;
        }
    }

   public static boolean isCompleteTree(Node root) {
        if (root == null) {
            return true;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        boolean past = false;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current == null) {
                past = true; // Once we encounter a null, all subsequent nodes must also be null
            } else {
                if (past) {
                    return false; // If we have already seen a null node, but now we see a non-null node
                }
                queue.add(current.left);  // Add left child to the queue
                queue.add(current.right); // Add right child to the queue
            }

        }


        return true;
    }
}

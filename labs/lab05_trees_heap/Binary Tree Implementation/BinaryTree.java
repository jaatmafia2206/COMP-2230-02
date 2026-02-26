// Node class
class Node {
    int data;
    Node left, right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

// BinaryTree class
public class BinaryTree {
    Node root;

    public BinaryTree() {
        root = null;
    }

    // In-order traversal
    void inOrderTraversal(Node node) {
        if (node == null) return;
        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    // Pre-order traversal
    void preOrderTraversal(Node node) {
        if (node == null) return;
        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    // Post-order traversal
    void postOrderTraversal(Node node) {
        if (node == null) return;
        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    // Level-order traversal (BFS)
    void levelOrderTraversal(Node node) {
        if (node == null) return;
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            System.out.print(current.data + " ");
            if (current.left != null) queue.add(current.left);
            if (current.right != null) queue.add(current.right);
        }
    }

    // Insert (for simplicity, insert as leftmost empty spot in level order)
    void insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return;
        }

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            if (temp.left == null) {
                temp.left = newNode;
                break;
            } else {
                queue.add(temp.left);
            }
            if (temp.right == null) {
                temp.right = newNode;
                break;
            } else {
                queue.add(temp.right);
            }
        }
    }

    // Delete a node by value (replace with deepest rightmost node)
    void delete(int key) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            if (root.data == key) root = null;
            return;
        }

        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);

        Node keyNode = null;
        Node temp = null;
        Node last = null;

        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.data == key) keyNode = temp;
            if (temp.left != null) queue.add(temp.left);
            if (temp.right != null) queue.add(temp.right);
            last = temp;
        }

        if (keyNode != null) {
            keyNode.data = last.data; // replace with deepest node
            removeDeepest(last);
        }
    }

    void removeDeepest(Node delNode) {
        java.util.Queue<Node> queue = new java.util.LinkedList<>();
        queue.add(root);
        Node temp;
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.left != null) {
                if (temp.left == delNode) {
                    temp.left = null;
                    return;
                } else {
                    queue.add(temp.left);
                }
            }
            if (temp.right != null) {
                if (temp.right == delNode) {
                    temp.right = null;
                    return;
                } else {
                    queue.add(temp.right);
                }
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(1);
        tree.insert(2);
        tree.insert(3);
        tree.insert(4);
        tree.insert(5);

        System.out.print("In-order traversal: ");
        tree.inOrderTraversal(tree.root);
        System.out.println();

        System.out.print("Pre-order traversal: ");
        tree.preOrderTraversal(tree.root);
        System.out.println();

        System.out.print("Post-order traversal: ");
        tree.postOrderTraversal(tree.root);
        System.out.println();

        System.out.print("Level-order traversal: ");
        tree.levelOrderTraversal(tree.root);
        System.out.println();

        System.out.println("\nDeleting node 3");
        tree.delete(3);
        System.out.print("Level-order after deletion: ");
        tree.levelOrderTraversal(tree.root);
    }
}

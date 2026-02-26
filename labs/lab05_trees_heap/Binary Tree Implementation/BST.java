class Node {
    int data;
    Node left, right;

    public Node(int value) {
        data = value;
        left = right = null;
    }
}

public class BST {
    Node root;

    public BST() {
        root = null;
    }

    // Insert node
    Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }

        if (key < node.data) {
            node.left = insert(node.left, key);
        } else if (key > node.data) {
            node.right = insert(node.right, key);
        }
        // if key == node.data, ignore duplicate
        return node;
    }

    // Search node
    boolean search(Node node, int key) {
        if (node == null) return false;
        if (node.data == key) return true;
        if (key < node.data) return search(node.left, key);
        return search(node.right, key);
    }

    // In-order traversal (sorted order)
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

    // Delete node
    Node delete(Node root, int key) {
        if (root == null) return null;

        if (key < root.data) {
            root.left = delete(root.left, key);
        } else if (key > root.data) {
            root.right = delete(root.right, key);
        } else {
            // Node found
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node with two children: get inorder successor
            root.data = minValue(root.right);

            // Delete the inorder successor
            root.right = delete(root.right, root.data);
        }
        return root;
    }

    int minValue(Node node) {
        int minv = node.data;
        while (node.left != null) {
            node = node.left;
            minv = node.data;
        }
        return minv;
    }

    public static void main(String[] args) {
        BST tree = new BST();

        /* Construct BST */
        int[] keys = {50, 30, 20, 40, 70, 60, 80};
        for (int key : keys) {
            tree.root = tree.insert(tree.root, key);
        }

        System.out.print("In-order traversal: ");
        tree.inOrderTraversal(tree.root);
        System.out.println();

        System.out.print("Pre-order traversal: ");
        tree.preOrderTraversal(tree.root);
        System.out.println();

        System.out.print("Post-order traversal: ");
        tree.postOrderTraversal(tree.root);
        System.out.println();

        System.out.println("\nSearching 40: " + tree.search(tree.root, 40));
        System.out.println("Searching 100: " + tree.search(tree.root, 100));

        System.out.println("\nDeleting 20");
        tree.root = tree.delete(tree.root, 20);
        System.out.print("In-order after deletion: ");
        tree.inOrderTraversal(tree.root);
        System.out.println();

        System.out.println("Deleting 30");
        tree.root = tree.delete(tree.root, 30);
        System.out.print("In-order after deletion: ");
        tree.inOrderTraversal(tree.root);
        System.out.println();

        System.out.println("Deleting 50");
        tree.root = tree.delete(tree.root, 50);
        System.out.print("In-order after deletion: ");
        tree.inOrderTraversal(tree.root);
        System.out.println();
    }
}

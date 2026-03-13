import java.util.*;

/**
 * Binary Search Tree Implementation
 *
 * A binary search tree is a binary tree data structure where each node has at most two children,
 * and for each node, all elements in its left subtree are less than the node,
 * and all elements in its right subtree are greater than the node.
 *
 * Time Complexity:
 * - Search: O(h) where h is height of tree
 * - Insert: O(h)
 * - Delete: O(h)
 * - Average case: O(log n) for balanced tree
 * - Worst case: O(n) for skewed tree
 *
 * Space Complexity: O(n)
 */
public class BinarySearchTree {
    private Node root;
    private int size;

    // Node class for BST
    private static class Node {
        int key;
        Node left, right;

        Node(int key) {
            this.key = key;
            left = right = null;
        }
    }

    public BinarySearchTreeSolution() {
        root = null;
        size = 0;
    }

    /**
     * Insert a key into the BST
     * @param key The key to insert
     */
    public void insert(int key) {
        root = insertRec(root, key);
        size++;
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }

        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        // If key already exists, do nothing (no duplicates)
        return root;
    }

    /**
     * Search for a key in the BST
     * @param key The key to search for
     * @return true if key exists, false otherwise
     */
    public boolean search(int key) {
        return searchRec(root, key);
    }

    private boolean searchRec(Node root, int key) {
        if (root == null) {
            return false;
        }

        if (key == root.key) {
            return true;
        } else if (key < root.key) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

    /**
     * Delete a key from the BST
     * @param key The key to delete
     * @return true if key was deleted, false if not found
     */
    public boolean delete(int key) {
        if (!search(key)) {
            return false;
        }

        root = deleteRec(root, key);
        size--;
        return true;
    }

    private Node deleteRec(Node root, int key) {
        if (root == null) {
            return root;
        }

        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else {
            // Node with only one child or no child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // Node with two children: Get inorder successor
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }

        return root;
    }

    private int minValue(Node root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    /**
     * Get the height of the tree
     * @return height of the tree (-1 for empty tree)
     */
    public int getHeight() {
        return getHeightRec(root);
    }

    private int getHeightRec(Node node) {
        if (node == null) {
            return -1;
        }
        return 1 + Math.max(getHeightRec(node.left), getHeightRec(node.right));
    }

    /**
     * Get the number of nodes in the tree
     * @return size of the tree
     */
    public int getSize() {
        return size;
    }

    /**
     * Inorder traversal of the tree
     */
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.key + " ");
            inorderRec(root.right);
        }
    }

    /**
     * Preorder traversal of the tree
     */
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node root) {
        if (root != null) {
            System.out.print(root.key + " ");
            preorderRec(root.left);
            preorderRec(root.right);
        }
    }

    /**
     * Postorder traversal of the tree
     */
    public void postorder() {
        postorderRec(root);
        System.out.println();
    }

    private void postorderRec(Node root) {
        if (root != null) {
            postorderRec(root.left);
            postorderRec(root.right);
            System.out.print(root.key + " ");
        }
    }

    /**
     * Level order traversal (breadth-first)
     */
    public void levelOrder() {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            System.out.print(node.key + " ");

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {

    // TODO: Create a BinarySearchTree object
    BinarySearchTree bst = new BinarySearchTree();

    // TODO: Create an array with the following values
    // 50, 30, 70, 20, 40, 60, 80
    int[] values = { };

    // TODO:
    // Loop through the array and insert each value into the BST
    // After each insertion print:
    // "Inserted <value> - Height: <height> Size: <size>"

    System.out.println("Inserting values:");

    // TODO: Print inorder traversal
    System.out.println("\nInorder traversal:");
    

    // TODO: Print preorder traversal
    System.out.println("Preorder traversal:");
    

    // TODO: Print postorder traversal
    System.out.println("Postorder traversal:");
    

    // TODO: Print level order traversal
    System.out.println("Level order traversal:");
    
    // TODO:
    // Search for the following values and print the result
    // Search 40
    // Search 100

    System.out.println("\nSearching for values:");

    // TODO:
    // Delete the value 30 from the tree
    // Print updated height and size

    System.out.println("\nDeleting 30:");

    // TODO: Print inorder traversal after deletion
    System.out.println("Inorder after deletion:");
    
    }
}
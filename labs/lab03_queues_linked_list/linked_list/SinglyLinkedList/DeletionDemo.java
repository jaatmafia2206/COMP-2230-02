/**
 * Deletion Operations Demo
 * Compile: javac Node.java DeletionDemo.java
 * Run: java DeletionDemo
 */

public class DeletionDemo {
    Node head;
    
    /**
     * Delete at Beginning - Time Complexity: O(1)
     * Removing the first node (head) of the list by updating head to second node.
     */
    public void deleteBeginning() {
        if (head == null) {
            System.out.println("List is empty - nothing to delete");
            return;
        }
        Node temp = head;
        head = head.next;
        temp.next = null;  // Optional: helps garbage collection
        // Note: In Java, no explicit delete needed - GC handles it
    }
    
    /**
     * Delete at End - Time Complexity: O(n)
     * Traverse to second-last node, update its next to null.
     */
    public void deleteEnd() {
        if (head == null) {
            System.out.println("List is empty - nothing to delete");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }
    
    /**
     * Delete at Position - Time Complexity: O(n)
     * Delete node at given position (0-indexed).
     */
    public void deleteAtPosition(int position) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        if (position == 0) {
            head = head.next;
            return;
        }
        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null || temp.next == null) {
            System.out.println("Position out of bounds");
            return;
        }
        Node nodeToDelete = temp.next;
        temp.next = nodeToDelete.next;
        nodeToDelete.next = null;  // Optional: helps garbage collection
    }
    
    public void display() {
        Node temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    
    public static void main(String[] args) {
        DeletionDemo demo = new DeletionDemo();
        // Build test list: 1 -> 2 -> 3 -> NULL
        demo.head = new Node(1);
        demo.head.next = new Node(2);
        demo.head.next.next = new Node(3);
        demo.head.next.next.next = new Node(10);

        
        System.out.println("Original list:");
        demo.display();
        
        demo.deleteBeginning();
        System.out.println("After delete beginning:");
        demo.display();  // 2 -> 3 -> NULL
        
        demo.deleteEnd();
        System.out.println("After delete end:");
        demo.display();  // 2 -> NULL
        
        demo.deleteAtPosition(0);
        System.out.println("After delete position 0:");
        demo.display();  // NULL
    }
}

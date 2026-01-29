/**
 * Insertion Operations Demo
 * Compile: javac Node.java InsertionDemo.java
 * Run: java InsertionDemo
 */

public class InsertionDemo {
    Node head;
    
    /**
     * Insert at Beginning - Time Complexity: O(1)
     */
    public void insertBeginning(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }
    
    /**
     * Insert at End - Time Complexity: O(n)
     */
    public void insertEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    
    /**
     * Insert After Position - Time Complexity: O(n)
     */
    public void insertAfterPosition(int position, int data) {
        if (position < 0) {
            System.out.println("Invalid position");
            return;
        }
        Node newNode = new Node(data);
        if (position == 0) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node temp = head;
        for (int i = 0; i < position - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Position out of bounds");
            return;
        }
        newNode.next = temp.next;
        temp.next = newNode;
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
        InsertionDemo demo = new InsertionDemo();
        demo.insertBeginning(1);
        demo.insertEnd(3);
        demo.insertAfterPosition(1, 2);
        demo.display();  // Output: List: 1 -> 2 -> 3 -> NULL
    }
}

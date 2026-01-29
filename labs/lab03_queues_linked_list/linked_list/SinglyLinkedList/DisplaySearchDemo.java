/**
 * Display and Search Operations Demo
 * Compile: javac Node.java DisplaySearchDemo.java
 * Run: java DisplaySearchDemo
 */

public class DisplaySearchDemo {
    Node head;
    
    /**
     * Display/Traverse List - Time Complexity: O(n)
     * Start from head, print each node's data until NULL.
     */
    public void display() {
        if (head == null) {
            System.out.println("List: NULL");
            return;
        }
        Node temp = head;
        System.out.print("List: ");
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
    
    /**
     * Search by Value - Time Complexity: O(n)
     * Traverse list, return position (0-indexed) of first match or -1.
     */
    public int search(int key) {
        Node temp = head;
        int position = 0;
        while (temp != null) {
            if (temp.data == key) {
                System.out.println("Found " + key + " at position " + position);
                return position;
            }
            temp = temp.next;
            position++;
        }
        System.out.println(key + " not found in list");
        return -1;
    }
    
    /**
     * Count Occurrences - Time Complexity: O(n)
     * Count how many times key appears in list.
     */
    public int countOccurrences(int key) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            if (temp.data == key) {
                count++;
            }
            temp = temp.next;
        }
        System.out.println(key + " appears " + count + " time(s)");
        return count;
    }
    
    public static void main(String[] args) {
        DisplaySearchDemo demo = new DisplayDemo();
        // Build test list: 1 -> 2 -> 2 -> 3 -> NULL
        demo.head = new Node(1);
        demo.head.next = new Node(2);
        demo.head.next.next = new Node(2);
        demo.head.next.next.next = new Node(3);
        
        System.out.println("--- DISPLAY ---");
        demo.display();
        
        System.out.println("\n--- SEARCH ---");
        demo.search(2);   // Found 2 at position 1
        demo.search(99);  // 99 not found
        
        System.out.println("\n--- COUNT ---");
        demo.countOccurrences(2);  // 2 appears 2 time(s)
        demo.countOccurrences(1);  // 1 appears 1 time(s)
    }
}

// Simple Hash Set for unique first names using chaining
// COMP 2230 – Hash Tables (as in lecture)

public class SimpleHashSet {

    // Fixed table size = 10 buckets (as assumed in slides)
    private static final int TABLE_SIZE = 10;

    // Each bucket is the head of a linked list of nodes (chaining)
    private Node[] buckets;

    // Node for the linked list in each bucket
    private static class Node {
        String name;   // the key (unique first name)
        Node next;

        Node(String name) {
            this.name = name;
        }
    }

    public SimpleHashSet() {
        buckets = new Node[TABLE_SIZE];
    }

    // STEP 2: Hash function using sum of Unicode values % 10
    private int hashFunction(String value) {
        int sumOfChars = 0;
        for (int i = 0; i < value.length(); i++) {
            sumOfChars += (int) value.charAt(i);
        }
        return sumOfChars % TABLE_SIZE;  // index between 0–9
    }

    // INSERT: add a unique name to the set
    public void add(String name) {
        int index = hashFunction(name);

        // Check if the name already exists in this bucket (no duplicates)
        Node current = buckets[index];
        while (current != null) {
            if (current.name.equals(name)) {
                // Name already present, do not insert duplicate
                return;
            }
            current = current.next;
        }

        // Insert at head of linked list in this bucket (chaining)
        Node newNode = new Node(name);
        newNode.next = buckets[index];
        buckets[index] = newNode;
    }

    // SEARCH: check if a name exists in the set
    public boolean contains(String name) {
        int index = hashFunction(name);
        Node current = buckets[index];

        while (current != null) {
            if (current.name.equals(name)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    // DELETE: remove a name from the set
    public void remove(String name) {
        int index = hashFunction(name);
        Node current = buckets[index];
        Node prev = null;

        while (current != null) {
            if (current.name.equals(name)) {
                // Remove this node from the linked list
                if (prev == null) {
                    // First node in the bucket
                    buckets[index] = current.next;
                } else {
                    prev.next = current.next;
                }
                return;
            }
            prev = current;
            current = current.next;
        }
    }

    // Utility: print all buckets to visualize collisions/chaining
    public void printTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print("Bucket " + i + ": ");
            Node current = buckets[i];
            while (current != null) {
                System.out.print(current.name + " -> ");
                current = current.next;
            }
            System.out.println("null");
        }
    }

    // Simple demo similar to the names used in the slides
    public static void main(String[] args) {
        SimpleHashSet set = new SimpleHashSet();

        set.add("Pete");
        set.add("Jones");
        set.add("Lisa");
        set.add("Bob");
        set.add("Siri");
        set.add("Stuart");   // may collide with an existing name
        
        System.out.println("Contains 'Pete'? " + set.contains("Pete"));
        System.out.println("Contains 'Stuart'? " + set.contains("Stuart"));
        System.out.println("Contains 'Alice'? " + set.contains("Alice"));

        System.out.println("\nHash table buckets:");
        set.printTable();

        System.out.println("\nRemoving 'Lisa'...");
        set.remove("Lisa");
        set.printTable();
    }
}

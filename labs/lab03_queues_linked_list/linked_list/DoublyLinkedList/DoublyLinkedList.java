public class DoublyLinkedList {
    Node head;

    public void append(int data) {
        Node newNode = new Node(data);
        Node last = head;

        if (head == null) {
            head = newNode;
            return;
        }

        while (last.next != null) {
            last = last.next;
        }

        last.next = newNode;
        newNode.prev = last;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.append(10);
        dll.append(20);
        dll.append(30);
        dll.printList();  // Output: 10 20 30
        System.out.println(dll.head.next.data);
    }
}

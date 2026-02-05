import java.util.LinkedList;

class HashTable {
    private class Node {
        String key;
        int value;
        Node(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int TABLE_SIZE = 10;
    private LinkedList<Node>[] table;

    public HashTable() {
        table = new LinkedList[TABLE_SIZE];
        for (int i = 0; i < TABLE_SIZE; i++) {
            table[i] = new LinkedList<>();
        }
    }

    private int hashFunction(String key) {
        return Math.abs(key.hashCode()) % TABLE_SIZE;
    }

    public void insert(String key, int value) {
        int index = hashFunction(key);
        for (Node node : table[index]) {
            if (node.key.equals(key)) {
                node.value = value;
                return;
            }
        }
        table[index].add(new Node(key, value));
    }

    public Integer search(String key) {
        int index = hashFunction(key);
        for (Node node : table[index]) {
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null; // Key not found
    }

    public void delete(String key) {
        int index = hashFunction(key);
        table[index].removeIf(node -> node.key.equals(key));
    }

    public void printTable() {
        for (int i = 0; i < TABLE_SIZE; i++) {
            System.out.print("[" + i + "]: ");
            for (Node node : table[i]) {
                System.out.print("(" + node.key + ", " + node.value + ") -> ");
            }
            System.out.println("NULL");
        }
    }

    public static void main(String[] args) {
        HashTable ht = new HashTable();

        ht.insert("apple", 1);
        ht.insert("banana", 2);
        ht.insert("orange", 3);

        ht.printTable();

        System.out.println("Search for 'apple': " + ht.search("apple"));
        System.out.println("Search for 'grape': " + ht.search("grape"));

        ht.delete("banana");
        ht.printTable();
    }
}

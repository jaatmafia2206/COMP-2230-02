/**
 * Complete Queue Operations Demo
 * Array-based + LinkedList implementations
 * Compile: javac QueueDemo.java
 * Run: java QueueDemo
 */

import java.util.LinkedList;
import java.util.Queue;

class ArrayQueue {
    private int[] arr;
    private int front, rear, size;
    private static final int CAPACITY = 5;
    
    public ArrayQueue() {
        arr = new int[CAPACITY];
        front = rear = size = 0;
    }
    
    // Enqueue (Insert/offer) - O(1) amortized
    public boolean enqueue(int data) {
        if (size == CAPACITY) {
            System.out.println("Queue overflow");
            return false;
        }
        arr[rear] = data;
        rear = (rear + 1) % CAPACITY;
        size++;
        return true;
    }
    
    // Dequeue (Remove/poll) - O(1)
    public Integer dequeue() {
        if (size == 0) {
            System.out.println("Queue underflow");
            return null;
        }
        int data = arr[front];
        front = (front + 1) % CAPACITY;
        size--;
        return data;
    }
    
    // Peek/Front/Seek - O(1)
    public Integer peek() {
        if (size == 0) {
            System.out.println("Queue empty");
            return null;
        }
        return arr[front];
    }
    
    // Size - O(1)
    public int size() {
        return size;
    }
    
    // Is Empty - O(1)
    public boolean isEmpty() {
        return size == 0;
    }
}

public class QueueDemo {
    public static void main(String[] args) {
        System.out.println("=== ARRAY QUEUE (Circular) ===");
        ArrayQueue aq = new ArrayQueue();
        aq.enqueue(10); aq.enqueue(20); aq.enqueue(30);
        System.out.println("Enqueued: peek=" + aq.peek() + ", size=" + aq.size());
        System.out.println("Dequeue: " + aq.dequeue());  // 10
        System.out.println("Now: " + aq.peek());         // 20
        
        System.out.println("\n=== LINKEDLIST QUEUE (Java Util) ===");
        Queue<Integer> lq = new LinkedList<>();
        lq.add(1); lq.add(2); lq.add(3);  // Enqueue
        System.out.println("Queue: " + lq);           // [1, 2, 3]
        System.out.println("poll(): " + lq.poll());   // 1 (remove)
        System.out.println("peek(): " + lq.peek());   // 2 (seek)
        System.out.println("size(): " + lq.size());   // 2
        System.out.println("Final: " + lq);           // [2, 3]
        
        System.out.println("\n=== ALL OPERATIONS SUMMARY ===");
        System.out.println("FIFO: First In First Out");
        System.out.println("Time: Enqueue/Dequeue/Peek all O(1)");
    }
}

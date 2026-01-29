import java.util.LinkedList;
import java.util.Queue;

public class SimpleQueue{
    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.remove();
        System.out.println(queue);  // Output: [2, 3]
    }
}

import java.util.LinkedList;
import java.util.Queue;

/**
 * Demonstrates using a queue of integers as a repeating key
 * to encode and decode a message.
 */
public class MessageCodes {

    /**
     * Encode and decode a message using a key of values stored in a queue.
     */
    public static void main(String[] args) {
        int[] key = {5, 12, -3, 8, -9, 4, 10};
        Integer keyValue;
        String encoded = "";
        String decoded = "";

        String message = "All programmers are playwrights and all " + "computers are lousy actors.";

        Queue<Integer> encodingQueue = new LinkedList<Integer>();
        Queue<Integer> decodingQueue = new LinkedList<Integer>();

        // load key queues
        for (int i = 0; i < key.length; i++) {
            encodingQueue.add(key[i]);
            decodingQueue.add(key[i]);
        }

        // encode message
        for (int i = 0; i < message.length(); i++) {
            keyValue = encodingQueue.remove();
            encoded += (char) (message.charAt(i) + keyValue);
            encodingQueue.add(keyValue);
        }

        System.out.println("Encoded Message:");
        System.out.println(encoded);
        System.out.println();

        // decode message
        for (int i = 0; i < encoded.length(); i++) {
            keyValue = decodingQueue.remove();
            decoded += (char) (encoded.charAt(i) - keyValue);
            decodingQueue.add(keyValue);
        }

        System.out.println("Decoded Message:");
        System.out.println(decoded);
    }
}

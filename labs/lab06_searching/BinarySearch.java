import java.util.Arrays;

/**
 * Binary Search implementation.
 * Requirement: The input array MUST be sorted.
 * Time Complexity: O(log n)
 */

public class BinarySearch {
    public static void main(String[] args) {
        // Binary search requires a sorted array
        int[] ints = {1, 2, 4, 5, 7, 9, 11};
        
        // Testing our manual implementation
        System.out.println("Manual Binary Search (looking for 8): " + binarySearch(ints, 8)); // Expected: -1
        
        // Testing Java's built-in library method
        System.out.println("Java Library Binary Search (looking for 9): " + Arrays.binarySearch(ints, 9)); // Expected: 5
    }

    private static int binarySearch(int[] numbers, int numberToFind) {
        int low = 0;
        int high = numbers.length - 1;

        while (low <= high) {
            // Find the index of the middle element
            int middlePosition = (low + high) / 2;
            int middleNumber = numbers[middlePosition];

            // Scenario 1: We found the number
            if (numberToFind == middleNumber) {
                return middlePosition;
            }

            // Scenario 2: Target is smaller than the middle; search left half
            if (numberToFind < middleNumber) {
                high = middlePosition - 1;
            } 
            // Scenario 3: Target is larger than the middle; search right half
            else {
                low = middlePosition + 1;
            }
        }

        // Return -1 if the loop finishes and the number wasn't found
        return -1;
    }
}
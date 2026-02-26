/**
 * Linear Search implementation.
 * Requirement: None (Works on sorted or unsorted arrays).
 * Time Complexity: O(n)
 */
public class LinearSearch {
    public static void main(String[] args) {
        // Linear search works on unsorted data
        int[] data = {10, 5, 20, 8, 15};
        int target = 8;

        int result = linearSearch(data, target);

        if (result != -1) {
            System.out.println("Linear Search: Found " + target + " at index " + result);
        } else {
            System.out.println("Linear Search: " + target + " was not found.");
        }
    }

    /**
     * Checks every element in the array one by one.
     */
    private static int linearSearch(int[] numbers, int numberToFind) {
        // Standard loop to visit every index
        for (int i = 0; i < numbers.length; i++) {
            // Check if current element is our target
            if (numbers[i] == numberToFind) {
                return i; // Return the index as soon as it's found
            }
        }

        // If we reach the end of the loop, the element doesn't exist
        return -1;
    }
}
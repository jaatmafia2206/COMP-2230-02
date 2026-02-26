import java.util.Arrays;
import java.util.Random;

public class PerformanceComparison {
    public static void main(String[] args) {
        // 1. Create a large array of 1 million elements
        int size = 1000000;
        int[] data = new int[size];
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(2000000); // Random numbers up to 2 million
        }

        // 2. Binary search MUST be sorted. 
        // We sort once and use this for both tests to be fair.
        Arrays.sort(data);

        int target = data[size - 1]; // Let's look for the last element (worst case for Linear)

        System.out.println("--- Starting Performance Test (Array Size: " + size + ") ---");

        // --- Test Linear Search ---
        long startLinear = System.nanoTime();
        int linearIndex = linearSearch(data, target);
        long endLinear = System.nanoTime();
        long linearDuration = endLinear - startLinear;

        // --- Test Binary Search ---
        long startBinary = System.nanoTime();
        int binaryIndex = binarySearch(data, target);
        long endBinary = System.nanoTime();
        long binaryDuration = endBinary - startBinary;

        // 3. Print Results
        System.out.println("Linear Search Index: " + linearIndex + " | Time: " + linearDuration + " ns");
        System.out.println("Binary Search Index: " + binaryIndex + " | Time: " + binaryDuration + " ns");
        System.out.println("\nBinary Search was " + (linearDuration / binaryDuration) + "x faster!");
    }

    private static int linearSearch(int[] numbers, int numberToFind) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == numberToFind) return i;
        }
        return -1;
    }

    private static int binarySearch(int[] numbers, int numberToFind) {
        int low = 0;
        int high = numbers.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (numbers[mid] == numberToFind) return mid;
            if (numbers[mid] < numberToFind) low = mid + 1;
            else high = mid - 1;
        }
        return -1;
    }
}
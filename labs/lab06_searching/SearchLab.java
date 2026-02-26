public class SearchLab {

    // Counts the number of comparisons (for analysis)
    public static int comparisons = 0;

    // TODO: Implement Linear Search
    public static int linearSearch(int[] arr, int target) {
        comparisons = 0;
        // Your code here
        return -1;
    }

    // TODO: Implement Binary Search
    public static int binarySearch(int[] arr, int target) {
        comparisons = 0;
        // Your code here
        return -1;
    }

    public static void main(String[] args) {
        int[] numbers = new int[100];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        int target = 73;

        int result = linearSearch(numbers, target);
        System.out.println("Linear Search Index: " + result);
        System.out.println("Comparisons: " + comparisons);

        result = binarySearch(numbers, target);
        System.out.println("Binary Search Index: " + result);
        System.out.println("Comparisons: " + comparisons);
    }
}

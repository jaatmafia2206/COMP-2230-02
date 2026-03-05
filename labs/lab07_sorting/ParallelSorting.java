import java.util.Arrays;
 
public class ParallelSorting {
    public static void main(String[] args) {
        int[] largeArray = new int[1000000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = (int) (Math.random() * 1000000);
        }
        Arrays.parallelSort(largeArray);

        //TO DO:  Add code here to verify IF the array IS SORTED
    }
}
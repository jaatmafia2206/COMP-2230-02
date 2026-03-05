import java.util.Arrays;
import java.util.Comparator;
 
public class CustomSorting {
    public static void main(String[] args) {
        Integer[] numbers = {5, 3, 8, 1, 2};
        Arrays.sort(numbers, new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return b - a; // Sort in descending order
            }
        });
        for (int num : numbers) {
            System.out.print(num + " ");
        }

        // TO DO TRY WITH OTHER EXAMPLE AND SORT IN ASCENDING ORDER.
        String[] words = {"banana", "apple", "grape", "orange"};
        // TO DO USE COMPARATOR TO SORT IN ASCENDING ORDER.
         
        

        for (String word : words) {
            System.out.print(word + " ");
        }
    }
}
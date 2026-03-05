/* Arrays.sort() Method
The simplest way to sort elements in Java is using the Arrays.sort() method:
*/

import java.util.Arrays;

public class BasicSorting {
    public static void main(String[] args) {
        // Integer array sorting
        int[] numbers = {5, 2, 9, 1, 7};
        Arrays.sort(numbers);

        // String array sorting
        String[] fruits = {"Apple", "Banana", "Cherry"};
        Arrays.sort(fruits);

        // Output sorted arrays
        System.out.println("Sorted numbers: " + Arrays.toString(numbers));
        System.out.println("Sorted fruits: " + Arrays.toString(fruits));

        // TO DO - Sort an array of custom objects (e.g., Student) 
        // based on a specific attribute (e.g., name or grade)


        // TO DO - PRINT THE SORTED ARRAY OF CUSTOM OBJECTS

    }

    

}


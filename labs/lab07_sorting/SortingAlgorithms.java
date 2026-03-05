public class SortingAlgorithms {

    /** Bubble Sort - Stable */
    public static void bubbleSort(int[] arr) {
        // TODO: Add iteration counter and comparison counter
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                // TODO: Increment comparison counter here
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
                // TODO: Increment iteration counter here
            }
        }
    }

    /** Selection Sort */
    public static void selectionSort(int[] arr) {
        // TODO: Add iteration counter and comparison counter
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                // TODO: Increment comparison counter here
                if (arr[j] < arr[min]) min = j;
                // TODO: Increment iteration counter here
            }
            int temp = arr[min];
            arr[min] = arr[i];
            arr[i] = temp;
        }
    }

    /** Insertion Sort - Stable */
    public static void insertionSort(int[] arr) {
        // TODO: Add iteration counter and comparison counter
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                // TODO: Increment comparison counter here
                arr[j + 1] = arr[j];
                j--;
                // TODO: Increment iteration counter here
            }
            arr[j + 1] = key;
        }
    }

    /** Merge Sort - Recursive, Stable */
    public static void mergeSort(int[] arr, int l, int r) {
        // TODO: Add comparison counter to merge() method
        if (l < r) {
            int mid = l + (r - l) / 2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;
        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++) L[i] = arr[l + i];
        for (int i = 0; i < n2; i++) R[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            // TODO: Increment comparison counter here
            if (L[i] <= R[j]) arr[k++] = L[i++];
            else arr[k++] = R[j++];
        }
        while (i < n1) arr[k++] = L[i++];
        while (j < n2) arr[k++] = R[j++];
    }

    /** Quick Sort - Divide and Conquer */
    public static void quickSort(int[] arr) {
        // TODO: Add iteration counter and comparison counter
        if (arr == null || arr.length == 0) {
            return;
        }
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            // TODO: Increment comparison counter here
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
            // TODO: Increment iteration counter here
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}

/* 
Run the code with the following test cases:

int[] arr1 = {64, 34, 25, 12, 22, 11, 90};
bubbleSort(arr1);
System.out.println("Bubble Sorted: " + Arrays.toString(arr1));

int[] arr2 = {64, 25, 12, 22, 11};
selectionSort(arr2);
System.out.println("Selection Sorted: " + Arrays.toString(arr2));

int[] arr3 = {12, 11, 13, 5, 6};
insertionSort(arr3);
System.out.println("Insertion Sorted: " + Arrays.toString(arr3));

int[] arr4 = {38, 27, 43, 3, 9, 82, 10};
mergeSort(arr4, 0, arr4.length - 1);
System.out.println("Merge Sorted: " + Arrays.toString(arr4));

int[] arr5 = {64, 34, 25, 12, 22, 11, 90};
quickSort(arr5);
System.out.println("Quick Sorted: " + Arrays.toString(arr5));
*/
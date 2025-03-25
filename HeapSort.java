import java.util.Arrays;

public class HeapSort {
    // Function to perform Heap Sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // Step 1: Build Max Heap (Rearrange array)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // Step 2: Extract elements from heap one by one
        for (int i = n - 1; i > 0; i--) {
            // Swap root (largest) with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Heapify the reduced heap
            heapify(arr, i, 0);
        }
    }

    // Heapify function to maintain the heap property
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;  // Assume root is largest
        int left = 2 * i + 1;  // Left child index
        int right = 2 * i + 2; // Right child index

        // Check if left child is larger
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check if right child is larger
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // If largest is not root, swap and continue heapifying
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            // Recursively heapify the affected subtree
            heapify(arr, n, largest);
        }
    }

    public static void main(String[] args) {
        int[] salaries = {50000, 70000, 40000, 60000, 90000, 30000};

        System.out.println("Original Salaries: " + Arrays.toString(salaries));

        heapSort(salaries); // Call Heap Sort

        System.out.println("Sorted Salaries: " + Arrays.toString(salaries));
    }
}
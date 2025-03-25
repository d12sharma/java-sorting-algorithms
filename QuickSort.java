
import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    // Quick Sort function
    public static void quickSort(double[] prices, int low, int high) {
        if (low < high) {
            // Partition the array and get the pivot index
            int pivotIndex = partition(prices, low, high);

            // Recursively sort elements before and after partition
            quickSort(prices, low, pivotIndex - 1);
            quickSort(prices, pivotIndex + 1, high);
        }
    }

    // Partition function to place pivot in the correct position
    public static int partition(double[] prices, int low, int high) {
        double pivot = prices[high]; // Choosing the last element as pivot
        int i = low - 1; // Pointer for smaller elements

        System.out.println("Pivot: " + pivot);

        for (int j = low; j < high; j++) {
            if (prices[j] <= pivot) {
                i++;
                // Swap prices[i] and prices[j]
                double temp = prices[i];
                prices[i] = prices[j];
                prices[j] = temp;
                System.out.println("  Swapped: " + Arrays.toString(prices));
            }
        }

        // Place the pivot in its correct position
        double temp = prices[i + 1];
        prices[i + 1] = prices[high];
        prices[high] = temp;
        System.out.println("  Pivot placed: " + Arrays.toString(prices));

        return i + 1; // Return pivot index
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for product prices
        System.out.print("Enter the number of products: ");
        int numProducts = scanner.nextInt();
        double[] prices = new double[numProducts];

        System.out.println("Enter the product prices:");
        for (int i = 0; i < numProducts; i++) {
            prices[i] = scanner.nextDouble(); // Read each product's price
        }

        // Sorting the product prices using Quick Sort
        quickSort(prices, 0, prices.length - 1);

        // Display the sorted product prices
        System.out.println("Sorted product prices in ascending order: " + Arrays.toString(prices));

        scanner.close(); // Closing the scanner
    }
}
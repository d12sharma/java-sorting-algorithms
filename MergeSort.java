import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    // Merge Sort function
    public static void mergeSort(double[] prices, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2; // Find the middle index

            // Recursively sort first and second halves
            mergeSort(prices, left, mid);
            mergeSort(prices, mid + 1, right);

            // Merge the sorted halves
            merge(prices, left, mid, right);
        }
    }

    // Merge two sorted halves
    public static void merge(double[] prices, int left, int mid, int right) {
        // Sizes of temporary arrays
        int n1 = mid - left + 1;
        int n2 = right - mid;

        // Create temporary arrays
        double[] leftArray = new double[n1];
        double[] rightArray = new double[n2];

        // Copy data to temporary arrays
        for (int i = 0; i < n1; i++)
            leftArray[i] = prices[left + i];
        for (int j = 0; j < n2; j++)
            rightArray[j] = prices[mid + 1 + j];

        System.out.println("Merging: " + Arrays.toString(leftArray) + " and " + Arrays.toString(rightArray));

        // Merge the temporary arrays
        int i = 0, j = 0, k = left;
        while (i < n1 && j < n2) {
            if (leftArray[i] <= rightArray[j]) {
                prices[k] = leftArray[i];
                i++;
            } else {
                prices[k] = rightArray[j];
                j++;
            }
            k++;
        }

        // Copy any remaining elements of leftArray
        while (i < n1) {
            prices[k] = leftArray[i];
            i++;
            k++;
        }

        // Copy any remaining elements of rightArray
        while (j < n2) {
            prices[k] = rightArray[j];
            j++;
            k++;
        }

        System.out.println("Merged: " + Arrays.toString(Arrays.copyOfRange(prices, left, right + 1)));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for book prices
        System.out.print("Enter the number of books: ");
        int numBooks = scanner.nextInt();
        double[] prices = new double[numBooks];

        System.out.println("Enter the book prices:");
        for (int i = 0; i < numBooks; i++) {
            prices[i] = scanner.nextDouble(); // Read each book's price
        }

        // Sorting the book prices using Merge Sort
        mergeSort(prices, 0, prices.length - 1);

        // Display the sorted book prices
        System.out.println("Sorted book prices in ascending order: " + Arrays.toString(prices));

        scanner.close(); // Closing the scanner
    }
}
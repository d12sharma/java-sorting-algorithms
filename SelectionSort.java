import java.util.Arrays;
import java.util.Scanner;

public class SelectionSort {
    // Selection Sort function
    public static void selectionSort(int[] scores) {
        int n = scores.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i; // Assume the first element is the minimum

            // Find the minimum element in the remaining unsorted array
            for (int j = i + 1; j < n; j++) {
                if (scores[j] < scores[minIndex]) {
                    minIndex = j; // Update minIndex if a smaller element is found
                }
            }

            // Swap the found minimum element with the first element of the unsorted part
            int temp = scores[minIndex];
            scores[minIndex] = scores[i];
            scores[i] = temp;

            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(scores));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking user input for exam scores
        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        int[] scores = new int[numStudents];

        System.out.println("Enter the exam scores:");
        for (int i = 0; i < numStudents; i++) {
            scores[i] = scanner.nextInt(); // Read each student's score
        }

        // Sorting the exam scores using Selection Sort
        selectionSort(scores);

        // Display the sorted exam scores
        System.out.println("Sorted exam scores in ascending order: " + Arrays.toString(scores));

        scanner.close(); // Closing the scanner
    }
}
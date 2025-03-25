import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

    public static void insertionSort(int[] ids) {
        int n = ids.length;


        for (int i = 1; i < n; i++) {
            int key = ids[i];
            int j = i - 1;

            System.out.println("Pass " + i + ": Inserting " + key);


            while (j >= 0 && ids[j] > key) {
                ids[j + 1] = ids[j];
                j--;
                System.out.println("  Shifted " + ids[j + 1] + ": " + Arrays.toString(ids));
            }


            ids[j + 1] = key;
            System.out.println("  Inserted " + key + ": " + Arrays.toString(ids));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the number of employees: ");
        int numEmployees = scanner.nextInt();
        int[] ids = new int[numEmployees];

        System.out.println("Enter the Employee IDs:");
        for (int i = 0; i < numEmployees; i++) {
            ids[i] = scanner.nextInt();
        }


        insertionSort(ids);


        System.out.println("Sorted Employee IDs in ascending order: " + Arrays.toString(ids));


    }
}
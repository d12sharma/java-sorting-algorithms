import java.util.Scanner;
public class BubbleSort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Enter the number of students: ");
        int numStudents = scanner.nextInt();
        int[] marks = new int[numStudents];

        System.out.println("Enter the marks of students:");
        for (int i = 0; i < numStudents; i++) {
            marks[i] = scanner.nextInt();
        }


        int[] result = Sort(marks);
        System.out.println("Marks After Sorting :");
        for(int i=0;i<marks.length;i++){

            System.out.print(marks[i]+" ");
        }



    }


    public static int[] Sort(int[] marks) {
        boolean swapped;
        int n = marks.length;


        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return marks;
    }
}
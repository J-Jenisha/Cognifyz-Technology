import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Student Grade Calculator!");
        System.out.print("Enter the number of grades: ");
        int numGrades = scanner.nextInt();

        if (numGrades <= 0) {
            System.out.println("Invalid number of grades.");
            return;
        }

        int[] grades = new int[numGrades];
        int total = 0;

        for (int i = 0; i < numGrades; i++) {
            System.out.print("Enter grade " + (i + 1) + ": ");
            grades[i] = scanner.nextInt();
            total += grades[i];
        }

        double average = (double) total / numGrades;
        System.out.println("Average grade: " + average);

        scanner.close();
    }
}

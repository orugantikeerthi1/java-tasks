import java.util.Scanner;

public class markscalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of subjects: ");
        int numSubjects = scanner.nextInt();
        
        double totalMarks = 0;
        
        
        for (int i = 1; i <= numSubjects; i++) {
            System.out.print("Enter marks obtained in subject " + i + " (out of 100): ");
            double marks = scanner.nextDouble();
            
            
            while (marks < 0 || marks > 100) {
                System.out.print("Invalid marks! Enter marks between 0 and 100: ");
                marks = scanner.nextDouble();
            }
            
            totalMarks += marks;
        }
        
        
        double averagePercentage = totalMarks / numSubjects;
        
        String grade;
        if (averagePercentage >= 90) {
            grade = "A";
        } else if (averagePercentage >= 75) {
            grade = "B";
        } else if (averagePercentage >= 60) {
            grade = "C";
        } else if (averagePercentage >= 40) {
            grade = "D";
        } else {
            grade = "F";
        }
        
        System.out.println("\n========== Results ==========");
        System.out.println("Total Marks: " + totalMarks);
        System.out.println("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
        System.out.println("Grade: " + grade);
        System.out.println("=============================");
        
        scanner.close();
    }
}
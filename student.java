import java.util.ArrayList;
import java.util.Scanner;

/**
 * Intermediate Java: Focuses on Object-Oriented Principles, 
 * List Collections, and basic Input Validation.
 */
class Student {
    private String name;
    private double score;

    public Student(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public String getName() { return name; }
    public double getScore() { return score; }

    // Logic to determine pass/fail
    public String getStatus() {
        return (score >= 50.0) ? "Passed" : "Failed";
    }
}

public class StudentSystem {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> students = new ArrayList<>();
        
        System.out.println("=== Student Record System ===");
        System.out.print("How many students to enter? ");
        
        // Basic check to ensure the user enters a number
        if (!input.hasNextInt()) {
            System.out.println("Invalid input. Please enter a whole number.");
            return;
        }
        
        int count = input.nextInt();
        input.nextLine(); // Consume newline left over

        for (int i = 0; i < count; i++) {
            System.out.println("\nStudent #" + (i + 1));
            System.out.print("Enter name: ");
            String name = input.nextLine();
            
            System.out.print("Enter score (0-100): ");
            double score = input.nextDouble();
            input.nextLine(); // Consume newline

            students.add(new Student(name, score));
        }

        // Displaying results using a simplified Table format
        System.out.println("\n-------------------------------------------");
        System.out.printf("%-15s | %-10s | %-10s\n", "NAME", "SCORE", "STATUS");
        System.out.println("-------------------------------------------");

        double totalScore = 0;
        for (Student s : students) {
            System.out.printf("%-15s | %-10.2f | %-10s\n", 
                              s.getName(), s.getScore(), s.getStatus());
            totalScore += s.getScore();
        }

        if (count > 0) {
            double average = totalScore / count;
            System.out.println("-------------------------------------------");
            System.out.printf("Class Average: %.2f\n", average);
        }
        
        input.close();
    }
}

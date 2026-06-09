import java.util.Random;
import java.util.Scanner;

public class randomnumber {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int score = 0;
        int rounds = 0;
        String playAgain;

        do {
            rounds++;

            int number = random.nextInt(100) + 1; // Random number 1-100
            int maxAttempts = 7;
            int attempts = 0;
            boolean guessedCorrectly = false;

            System.out.println("\n=== Round " + rounds + " ===");
            System.out.println("Guess a number between 1 and 100");
            System.out.println("You have " + maxAttempts + " attempts.");

            while (attempts < maxAttempts) {

                System.out.print("Enter your guess: ");
                int guess = sc.nextInt();

                attempts++;

                if (guess == number) {
                    System.out.println(" Correct! You guessed the number.");

                    int points = maxAttempts - attempts + 1;
                    score += points;

                    System.out.println("You earned " + points + " points.");
                    guessedCorrectly = true;
                    break;

                } else if (guess < number) {
                    System.out.println(" Too low!");

                } else {
                    System.out.println(" Too high!");
                }

                System.out.println("Attempts left: " + (maxAttempts - attempts));
            }

            if (!guessedCorrectly) {
                System.out.println(" Out of attempts!");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("Current Score: " + score);

            System.out.print("Do you want to play again? (yes/no): ");
            playAgain = sc.next();

        } while (playAgain.equalsIgnoreCase("yes"));

        System.out.println("\n=== Game Over ===");
        System.out.println("Total Rounds Played: " + rounds);
        System.out.println("Final Score: " + score);

        sc.close();
    }
}
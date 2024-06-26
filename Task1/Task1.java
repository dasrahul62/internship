import java.util.Random;
import java.util.Scanner;

public class Task1 {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int rounds = 0;
        int totalScore = 0;
        boolean playAgain;

        System.out.println("Welcome to the Number Guessing Game!");

        do {
            rounds++;
            int numberToGuess = random.nextInt(100) + 1;
            int attempts = 0;
            int maxAttempts = 10;
            boolean guessedCorrectly = false;

            System.out.println("\nRound " + rounds);
            System.out.println("I have generated a number between 1 and 100.");
            System.out.println("You have " + maxAttempts + " attempts to guess it.");

            while (attempts < maxAttempts) {
                System.out.print("Enter your guess: ");
                int guess = scanner.nextInt();
                attempts++;

                if (guess < numberToGuess) {
                    System.out.println("Too low!");
                } else if (guess > numberToGuess) {
                    System.out.println("Too high!");
                } else {
                    System.out.println("Correct! You've guessed the number.");
                    guessedCorrectly = true;
                    break;
                }
            }

            if (!guessedCorrectly) {
                System.out.println("Sorry, you've used all " + maxAttempts + " attempts. The number was " + numberToGuess + ".");
            }

            int score = guessedCorrectly ? maxAttempts - attempts + 1 : 0;
            totalScore += score;
            System.out.println("Your score for this round: " + score);
            System.out.println("Total score: " + totalScore);

            System.out.print("Do you want to play another round? (yes/no): ");
            playAgain = scanner.next().equalsIgnoreCase("yes");
        } while (playAgain);

        System.out.println("\nThank you for playing the Number Guessing Game!");
        System.out.println("Total rounds played: " + rounds);
        System.out.println("Final score: " + totalScore);

        scanner.close();
    }
}

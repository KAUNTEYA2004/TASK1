package PROJECTS;
import java.util.*;
public class task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        final int MIN = 1;
        final int MAX = 100;
        final int MAX_ATTEMPTS = 7;
        int totalRounds = 0;
        int roundsWon = 0;

        System.out.println("🎯 Welcome to the Number Guessing Game!");

        boolean playAgain;
        do {
            int numberToGuess = random.nextInt(MAX - MIN + 1) + MIN;
            int attemptsLeft = MAX_ATTEMPTS;
            boolean guessedCorrectly = false;

            System.out.println("\n🔢 I'm thinking of a number between " + MIN + " and " + MAX + ".");
            System.out.println("💡 You have " + MAX_ATTEMPTS + " attempts to guess it.");

            while (attemptsLeft > 0) {
                System.out.print("👉 Enter your guess: ");
                int userGuess;
                while (!scanner.hasNextInt()) {
                    System.out.print("❌ Invalid input. Please enter an integer: ");
                    scanner.next();
                }
                userGuess = scanner.nextInt();
                if (userGuess < MIN || userGuess > MAX) {
                    System.out.println("⚠️ Guess must be between " + MIN + " and " + MAX + ".");
                    continue;
                }
                if (userGuess == numberToGuess) {
                    System.out.println("🎉 Correct! You guessed the number!");
                    guessedCorrectly = true;
                    roundsWon++;
                    break;
                } else if (userGuess < numberToGuess) {
                    System.out.println("⬆️ Too low!");
                } else {
                    System.out.println("⬇️ Too high!");
                }
                attemptsLeft--;
                if (attemptsLeft > 0) {
                    System.out.println("🕒 Attempts left: " + attemptsLeft);
                } else {
                    System.out.println("❌ Out of attempts! The number was: " + numberToGuess);
                }
            }

            totalRounds++;

            System.out.print("\n🔁 Do you want to play another round? (yes/no): ");
            scanner.nextLine(); // consume leftover newline
            String response = scanner.nextLine().trim().toLowerCase();
            playAgain = response.equals("yes") || response.equals("y");

        } while (playAgain);

        System.out.println("\n🏁 Game Over!");
        System.out.println("📊 Total Rounds Played: " + totalRounds);
        System.out.println("🏆 Rounds Won: " + roundsWon);
    }
}

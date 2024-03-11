import java.util.Random;
import java.util.Scanner;

public class RandomNumGen {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Random random = new Random();
		int minRange = 1;
		int maxRange = 100;
		int attemptsLimit = 10;
		int rounds = 0;
		int score = 0;

		System.out.println("Welcome to the Number Guessing Game!");

		boolean playAgain = true;
		while (playAgain) {
			int randomNumber = random.nextInt(maxRange - minRange + 1) + minRange;
			int attempts = 0;
			boolean guessed = false;

			System.out.println("\nRound " + (++rounds));

			while (!guessed && attempts < attemptsLimit) {
				System.out.print("Guess the number between " + minRange + " and " + maxRange + ": ");
				int userGuess = scanner.nextInt();
				attempts++;

				if (userGuess == randomNumber) {
					System.out.println("Congratulations! You guessed the number (" + randomNumber + ") correctly in "
							+ attempts + " attempts.");
					score++;
					guessed = true;
				} else if (userGuess < randomNumber) {
					System.out.println("Too low! Try again.");
				} else {
					System.out.println("Too high! Try again.");
				}
			}

			if (!guessed) {
				System.out.println("Sorry, you've reached the maximum number of attempts. The correct number was: "
						+ randomNumber);
			}

			System.out.print("\nDo you want to play again? (yes/no): ");
			String playChoice = scanner.next().toLowerCase();

			if (!playChoice.equals("yes")) {
				playAgain = false;
			}
		}

		System.out.println("\nGame Over!");
		System.out.println("Total rounds played: " + rounds);
		System.out.println("Your score: " + score);

		scanner.close();
	}
}
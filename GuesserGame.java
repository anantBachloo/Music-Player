package Project;
import java.util.Scanner;
import java.util.Random;

class Guesser {
    int guessNumber(Scanner input) {
        System.out.print("Enter the Guesser Number: ");
        return input.nextInt();
    }

    int generateRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(min, max + 1);
    }

    int generateRandomNumber() {
        Random random = new Random();
        return random.nextInt(Integer.MAX_VALUE);
    }
}

class Player {
    int chooseNumber(Scanner input, int playerNumber) {
        int num;
        while (true) {
            System.out.print("Player_" + playerNumber + " Number: ");
            num = input.nextInt();
            if (num >= 0) break;
            System.out.println("Invalid input! Please enter a non-negative number.");
        }
        return num;
    }
}

class Umpire {
    private int guesserNum;
    private int num1, num2, num3;

    void getPlayerGuesses(Scanner input) {
        Player player = new Player();
        num1 = player.chooseNumber(input, 1);
        num2 = player.chooseNumber(input, 2);
        num3 = player.chooseNumber(input, 3);
    }

    void checkWinner() {
        System.out.println();
        if (guesserNum == num1 && guesserNum == num2 && guesserNum == num3) {
            System.out.println("|| Player 1, Player 2, and Player 3 Win ||");
        } else if (guesserNum == num1 && guesserNum == num2) {
            System.out.println("|| Player 1 and Player 2 Win ||");
        } else if (guesserNum == num2 && guesserNum == num3) {
            System.out.println("|| Player 2 and Player 3 Win ||");
        } else if (guesserNum == num1 && guesserNum == num3) {
            System.out.println("|| Player 1 and Player 3 Win ||");
        } else if (guesserNum == num1) {
            System.out.println("|| Player 1 Wins ||");
        } else if (guesserNum == num2) {
            System.out.println("|| Player 2 Wins ||");
        } else if (guesserNum == num3) {
            System.out.println("|| Player 3 Wins ||");
        } else {
            System.out.println("|| NO ONE WINS! The number was: " + guesserNum + " ||");
        }
    }

    void playWithGuesserInput(Scanner input) {
        Guesser guesser = new Guesser();
        guesserNum = guesser.guessNumber(input);
        getPlayerGuesses(input);
        checkWinner();
    }

    void playWithRandomNumber(Scanner input) {
        Guesser guesser = new Guesser();
        guesserNum = guesser.generateRandomNumber();
        getPlayerGuesses(input);
        checkWinner();
    }

    void playWithRandomRange(Scanner input) {
        int min, max;
        while (true) {
            System.out.print("Enter the minimum number: ");
            min = input.nextInt();
            System.out.print("Enter the maximum number: ");
            max = input.nextInt();

            if (min <= max) break;
            System.out.println("Invalid range! Minimum should be less than or equal to maximum.");
        }

        Guesser guesser = new Guesser();
        guesserNum = guesser.generateRandomNumber(min, max);
        getPlayerGuesses(input);
        checkWinner();
    }
}

public class GuesserGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Umpire umpire = new Umpire();

        System.out.println("------ GAME STARTS ------");

        while (true) {
            System.out.println("\n1. Use a randomly generated number.");
            System.out.println("2. Use a number chosen by the host.");
            System.out.println("3. Exit.");
            System.out.print("\nEnter choice: ");

            int choice = input.nextInt();
            input.nextLine();  // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Do you want the number in a given range? (YES or NO): ");
                    String response = input.nextLine().trim();

                    if (response.equalsIgnoreCase("YES")) {
                        umpire.playWithRandomRange(input);
                    } else if (response.equalsIgnoreCase("NO")) {
                        umpire.playWithRandomNumber(input);
                    } else {
                        System.out.println("Invalid response! Please enter YES or NO.");
                    }
                    break;

                case 2:
                    umpire.playWithGuesserInput(input);
                    break;

                case 3:
                    System.out.println("\n------ GAME OVER ------");
                    input.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
            System.out.println("=================================");
        }
    }
}

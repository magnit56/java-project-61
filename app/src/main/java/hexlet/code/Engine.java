package hexlet.code;

import hexlet.code.games.Game;
import hexlet.code.games.GcdGame;
import hexlet.code.games.CalcGame;
import hexlet.code.games.ProgressionGame;
import hexlet.code.games.PrimeGame;
import hexlet.code.games.EvenGame;

import java.util.Scanner;

public class Engine {
    public static final int ROUNDS_COUNT = 3;

    public static void play() {
        var choose = Engine.choose();
        var name = Engine.greeting();
        Class<? extends Game> gameClass;
        switch (choose) {
            case "2":
                gameClass = EvenGame.class;
                break;
            case "3":
                gameClass = CalcGame.class;
                break;
            case "4":
                gameClass = GcdGame.class;
                break;
            case "5":
                gameClass = ProgressionGame.class;
                break;
            case "6":
                gameClass = PrimeGame.class;
                break;
            default:
            case "0":
            case "1":
                return;
        }

        try {
            System.out.println(gameClass.getDeclaredMethod("getGreeting").invoke(null));
        } catch (Exception e) {
            e.printStackTrace();
        }

        for (int i = 0; i < ROUNDS_COUNT; i++) {
            try {
                Game game = gameClass.getDeclaredConstructor().newInstance();
                var question = game.getQuestion();
                System.out.println("Question: " + question);
                System.out.print("Your answer: ");
                Scanner scanner = new Scanner(System.in);
                String answer = scanner.nextLine();
                var isCorrect = game.isCorrectAnswer(answer);
                if (isCorrect) {
                    System.out.println("Correct!");
                } else {
                    System.out.println("'" + answer + "' is wrong answer ;(. Correct answer was '"
                            + game.getCorrectAnswer() + "'.");
                    System.out.println("Let's try again, " + name + "!");
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println("Congratulations, " + name + "!");
    }

    public static String greeting() {
        System.out.println("Welcome to the Brain Games!");

        System.out.print("May I have your name? ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        System.out.println("Hello, " + input + "!");

        return input;
    }

    public static String choose() {
        System.out.println("Please enter the game number and press Enter.");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");
        System.out.print("Your choice: ");

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println();
        return input;
    }
}

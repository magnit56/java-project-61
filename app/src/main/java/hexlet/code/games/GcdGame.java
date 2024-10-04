package hexlet.code.games;

import java.util.Random;

public class GcdGame implements Game {
    private final String question;

    private final String correctAnswer;

    private static final int MAX_NUMBER = 101;

    public GcdGame() {
        Random random = new Random();
        int randomNumber1 = random.nextInt(MAX_NUMBER);
        int randomNumber2 = random.nextInt(MAX_NUMBER);
        this.question = Integer.toString(randomNumber1) + " " + Integer.toString(randomNumber2);
        this.correctAnswer = Integer.toString(gcd(randomNumber1, randomNumber2));
    }

    /**
     * Gets a greeting to the user before the game starts.
     *
     * @return A string which is a greeting to the user.
     */
    public static String getGreeting() {
        return "Find the greatest common divisor of given numbers.";
    }

    /**
     * Gets a question from the game.
     *
     * @return A string which is a question for the user.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Gets the correct answer for the question.
     *
     * @return A string which is a correct answer for the question.
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Checks if the given answer is correct.
     *
     * @param answer The user's answer.
     * @return {@code true} if the answer is correct, {@code false} otherwise.
     */
    public boolean isCorrectAnswer(String answer) {
        return correctAnswer.equals(answer);
    }

    /**
     * Computes the greatest common divisor of two given numbers.
     *
     * The greatest common divisor (GCD) of two numbers is the largest
     * number that divides both of them without a remainder.
     *
     * @param a The first number.
     * @param b The second number.
     * @return The GCD of the given numbers.
     */
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

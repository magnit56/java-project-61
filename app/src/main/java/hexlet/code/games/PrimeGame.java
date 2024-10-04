package hexlet.code.games;

import java.util.Random;

public class PrimeGame implements Game {
    protected final String question;

    protected final String correctAnswer;

    private static final int MAX_NUMBER = 101;

    public PrimeGame() {
        Random random = new Random();
        int randomNumber = random.nextInt(MAX_NUMBER);
        this.question = Integer.toString(randomNumber);
        this.correctAnswer = isPrime(randomNumber) ? "yes" : "no";
    }

    /**
     * Gets a greeting for the prime game.
     *
     * @return A greeting for the prime game.
     */
    public static String getGreeting() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
    }

    /**
     * Gets a question for the prime game.
     *
     * @return A question for the prime game.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Gets the correct answer to the question.
     *
     * @return A string which is the correct answer.
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
     * Checks if the given number is prime.
     *
     * @param number The number to be checked.
     * @return {@code true} if the number is prime, {@code false} otherwise.
     */
    public static boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}

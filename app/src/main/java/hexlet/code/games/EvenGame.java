package hexlet.code.games;

import java.util.Random;

public class EvenGame implements Game {
    protected final String question;

    protected final String correctAnswer;

    private static final int MAX_NUMBER = 101;

    public EvenGame() {
        Random random = new Random();
        int randomNumber = random.nextInt(MAX_NUMBER);
        this.question = Integer.toString(randomNumber);
        this.correctAnswer = (Integer.parseInt(this.question) % 2 == 0) ? "yes" : "no";
    }

    /**
     * Gets the greeting for this game.
     *
     * @return The greeting for this game.
     */
    public static String getGreeting() {
        return "Answer 'yes' if the number is even, otherwise answer 'no'.";
    }

    /**
     * Gets the question for this game.
     *
     * @return The question for this game.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Gets the correct answer to the question.
     *
     * @return The correct answer to the question.
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Checks if the given answer is correct.
     *
     * @param answer The answer given by the user.
     * @return {@code true} if the answer is correct, {@code false} otherwise.
     */
    public boolean isCorrectAnswer(String answer) {
        return correctAnswer.equals(answer);
    }
}

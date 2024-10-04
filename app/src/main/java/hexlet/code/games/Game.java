package hexlet.code.games;

public interface Game {
    /**
     * Get a question from the game.
     *
     * @return A string which is question for the user.
     */
    String getQuestion();

    /**
     * Get the correct answer to the question.
     *
     * @return A string which is the correct answer.
     */
    String getCorrectAnswer();

    /**
     * Checks if the given answer is correct.
     *
     * @param answer The user's answer.
     * @return {@code true} if the answer is correct, {@code false} otherwise.
     */
    boolean isCorrectAnswer(String answer);
}

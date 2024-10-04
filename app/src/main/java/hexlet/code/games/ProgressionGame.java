package hexlet.code.games;

import java.util.Random;

public class ProgressionGame implements Game {
    private final String question;

    private final String correctAnswer;

    private static final int MAX_NUMBER = 50;
    private static final int STEP = 50;
    private static final int PROGRESSION_LENGTH = 10;

    public ProgressionGame() {
        Random random = new Random();
        int firstNumber = random.nextInt(MAX_NUMBER);
        int step = random.nextInt(STEP) + 1;
        int hiddenIndex = random.nextInt(PROGRESSION_LENGTH);
        int[] progression = new int[PROGRESSION_LENGTH];
        progression[0] = firstNumber;
        for (int i = 1; i < PROGRESSION_LENGTH; i++) {
            progression[i] = progression[i - 1] + step;
        }
        int hiddenNumber = progression[hiddenIndex];
        StringBuilder questionBuilder = new StringBuilder();
        for (int num : progression) {
            if (num == hiddenNumber) {
                questionBuilder.append(".. ");
            } else {
                questionBuilder.append(num).append(" ");
            }
        }
        this.question = questionBuilder.toString().trim();
        this.correctAnswer = Integer.toString(hiddenNumber);
    }

    /**
     * Gets the greeting for this game.
     *
     * @return The greeting as a string.
     */
    public static String getGreeting() {
        return "What number is missing in the progression?";
    }

    /**
     * Gets the question for this game.
     *
     * @return The question as a string.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Gets the correct answer to the question.
     *
     * @return The correct answer as a string.
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
}

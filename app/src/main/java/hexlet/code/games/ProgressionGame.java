package hexlet.code.games;

import java.util.Random;

public class ProgressionGame implements Game {
    protected final String question;

    protected final String correctAnswer;

    private static final int MAX_NUMBER = 50;
    private static final int STEP = 50;

    public ProgressionGame() {
        Random random = new Random();
        int firstNumber = random.nextInt(MAX_NUMBER);
        int step = random.nextInt(STEP) + 1;
        int progressionLength = 10;
        int hiddenIndex = random.nextInt(progressionLength);
        int[] progression = new int[progressionLength];
        progression[0] = firstNumber;
        for (int i = 1; i < progressionLength; i++) {
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

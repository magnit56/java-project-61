package hexlet.code.games;

import java.util.Random;

public class CalcGame implements Game {
    protected final String question;

    protected final String correctAnswer;

    private static final int MAX_NUMBER = 101;

    public CalcGame() {
        Random random = new Random();
        int randomNumber1 = random.nextInt(MAX_NUMBER);
        int randomNumber2 = random.nextInt(MAX_NUMBER);
        String[] operations = {"+", "-", "*"};
        int randomIndex = random.nextInt(operations.length);
        String operation = operations[randomIndex];

        this.question = Integer.toString(randomNumber1) + " " + operation + " " + Integer.toString(randomNumber2);
        switch (operation) {
            case "+":
                this.correctAnswer = Integer.toString(randomNumber1 + randomNumber2);
                break;
            case "-":
                this.correctAnswer = Integer.toString(randomNumber1 - randomNumber2);
                break;
            default:
            case "*":
                this.correctAnswer = Integer.toString(randomNumber1 * randomNumber2);
                break;
        }
    }

    /**
     * Gets the greeting of the game.
     * @return The greeting.
     */
    public static String getGreeting() {
        return "What is the result of the expression?";
    }

    /**
     * Gets the question of the game.
     * @return The question.
     */
    public String getQuestion() {
        return question;
    }

    /**
     * Gets the correct answer for the question.
     * @return The correct answer.
     */
    public String getCorrectAnswer() {
        return correctAnswer;
    }

    /**
     * Checks if the given answer is correct.
     * @param answer The user's answer.
     * @return {@code true} if the answer is correct, {@code false} otherwise.
     */
    public boolean isCorrectAnswer(String answer) {
        return correctAnswer.equals(answer);
    }
}

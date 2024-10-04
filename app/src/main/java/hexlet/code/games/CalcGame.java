package hexlet.code.games;

import java.util.Random;

public class CalcGame implements Game {
    protected final String question;

    protected final String correctAnswer;

    public CalcGame() {
        Random random = new Random();
        int randomNumber1 = random.nextInt(101);
        int randomNumber2 = random.nextInt(101);
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

    public static String getGreeting() {
        return "What is the result of the expression?";
    }

    public String getQuestion() {
        return question;
    }

    public String getCorrectAnswer() {
        return correctAnswer;
    }

    public boolean isCorrectAnswer(String answer) {
        return correctAnswer.equals(answer);
    }
}

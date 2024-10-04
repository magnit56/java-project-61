package hexlet.code.games;

import java.util.Random;

public class GcdGame implements Game {
    protected final String question;

    protected final String correctAnswer;

    public GcdGame() {
        Random random = new Random();
        int randomNumber1 = random.nextInt(101);
        int randomNumber2 = random.nextInt(101);
        this.question = Integer.toString(randomNumber1) + " " + Integer.toString(randomNumber2);
        this.correctAnswer = Integer.toString(gcd(randomNumber1, randomNumber2));
    }

    public static String getGreeting() {
        return "Find the greatest common divisor of given numbers.";
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

    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

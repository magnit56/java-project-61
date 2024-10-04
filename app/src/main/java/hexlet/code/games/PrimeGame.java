package hexlet.code.games;

import java.util.Random;

public class PrimeGame implements Game {
    protected final String question;

    protected final String correctAnswer;

    public PrimeGame() {
        Random random = new Random();
        int randomNumber = random.nextInt(101);
        this.question = Integer.toString(randomNumber);
        this.correctAnswer = isPrime(randomNumber) ? "yes" : "no";
    }

    public static String getGreeting() {
        return "Answer 'yes' if given number is prime. Otherwise answer 'no'.";
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

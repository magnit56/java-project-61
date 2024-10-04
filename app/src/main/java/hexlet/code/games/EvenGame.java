package hexlet.code.games;

import java.util.Random;

public class EvenGame implements Game {
    protected final String question;

    protected final String correctAnswer;

    public EvenGame() {
        Random random = new Random();
        int randomNumber = random.nextInt(101);
        this.question = Integer.toString(randomNumber);
        this.correctAnswer = (Integer.parseInt(this.question) % 2 == 0) ? "yes" : "no";
    }

    public static String getGreeting() {
        return "Answer \"yes\" if the number is even, otherwise answer \"no\".";
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

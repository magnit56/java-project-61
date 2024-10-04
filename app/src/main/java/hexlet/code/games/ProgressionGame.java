package hexlet.code.games;

import java.util.Random;

public class ProgressionGame implements Game {
    protected final String question;

    protected final String correctAnswer;

    public ProgressionGame() {
        Random random = new Random();
        int firstNumber = random.nextInt(50);
        int step = random.nextInt(5) + 1;
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

    public static String getGreeting() {
        return "What number is missing in the progression?";
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

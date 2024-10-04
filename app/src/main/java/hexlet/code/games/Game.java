package hexlet.code.games;

public interface Game {
    String getQuestion();

    String getCorrectAnswer();

    boolean isCorrectAnswer(String answer);
}

package org.project.player;

import org.project.abstracts.Question;
import org.project.abstracts.Quiz;
import org.project.interfaces.QuizProperties;

import java.util.function.Supplier;


public class LoadedQuiz extends Quiz implements QuizProperties {

    public LoadedQuiz(String title, String description) {
        super(title, description);
    }

    @Override
    public void addQuestion(Question question) {
        if (doesQuestionExists(question)) {
           System.out.println("Question already exists...");
        } else {
            this.questions.add(question);
        }
    }

    @Override
    public String printScore() {
        calculateScore();
        return "You solved: " + calculateScore() + " out of " + this.questions.size() + " questions correct.";
    }

    private int calculateScore() {
        int score = 0;
        for (Question question : this.questions) {
            if (question.isPass()) {
                score++;
            }
        }

        return score;
    }

    private boolean doesQuestionExists(Question q) {
        for (Question question : this.questions) {
            if (question.equals(q)) {
                return true;
            }
        }
        return false;
    }

    public boolean isQuizEmpty() {
        return this.questions.isEmpty();
    }
}

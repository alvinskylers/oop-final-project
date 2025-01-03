package org.project.player;

import org.project.abstracts.Question;
import org.project.abstracts.Quiz;

import java.util.ArrayList;

public class QuizEntity extends Quiz {
    private String question;
    private String description;
    private ArrayList<Question> questions;

    public QuizEntity(String question, String description) {
        super(question, description);
        this.questions = new ArrayList<>();
    }

    public boolean isQuizEmpty() {
        return questions.isEmpty();
    }

    public void addQuestion(Question question) {
        if (!doesQuestionExist(question)) {
            this.questions.add(question);
        }
    }

    private boolean doesQuestionExist(Question question) {
        return this.questions.contains(question);
    }

    @Override
    public String toString() {
        return "\n==== " + this.title +" ====\n" + this.description;
    }

    @Override
    public boolean equals(Object obj) {
        //TODO Complete compare method to compare quiz's
        for (Question question : this.questions) {
            if (!question.equals(((QuizEntity) obj).question)) {
                return false;
            }
        }
        return true;
    }
}

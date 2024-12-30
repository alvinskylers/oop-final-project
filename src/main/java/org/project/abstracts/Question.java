package org.project.abstracts;

public abstract class Question {

    protected String question;
    protected boolean isCorrect;

    public Question(String question) {
        this.question = question;
        this.isCorrect = false;
    }


    public abstract void answerQuestion(String answer);

    public abstract boolean isPass();
}

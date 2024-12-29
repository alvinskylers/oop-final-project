package org.project.entities;

import org.project.abstracts.Question;

public class MultipleChoiceQuestion extends Question {
    public String question;
    public String[] options;
    public int correctOption;

    public MultipleChoiceQuestion(String question, String[] options, int correctOption) {
        super(question);
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;

    }

    public boolean isPass() {
        return this.isCorrect;
    }

    private void setQuestionStatus(boolean status) {
        this.isCorrect = status;
    }

    @Override
    public void answerQuestion(String answer) {
        setQuestionStatus(Integer.parseInt(answer) == correctOption);
    }

    @Override
    public String toString() {
        String str = "";
        str += this.question;
        for (int i = 0; i < this.options.length; i++) {
            str += this.options[i] + "\n";
        }
        return str;
    }
}


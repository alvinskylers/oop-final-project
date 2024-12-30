package org.project.entities;

import org.project.abstracts.Question;

public class TrueOrFalseQuestion extends Question {

    boolean answer;

    public TrueOrFalseQuestion(String question, boolean answer) {
        super(question);
    }

    @Override
    public boolean isPass() {
        return this.isCorrect;
    }

    private void setQuestionStatus(boolean status) {
        this.isCorrect = status;
    }

    @Override
    public void answerQuestion(String answer) {
       switch (answer.toLowerCase()) {
           case "yes":
           case "true":
           case "y":
               setQuestionStatus(true);
               break;
           case "no":
           case "false":
           case "n":
               setQuestionStatus(false);
       }
    }

    @Override
    public String toString() {
        return "Statement: \n" + this.question;
    }

    @Override
    public boolean equals(Object obj) {
        if (this==obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return true;
        }

        Question other = (Question) obj;
        if (((TrueOrFalseQuestion) other).question.equals(this.question)) {
            return true;
        }

        return false;
    }

}

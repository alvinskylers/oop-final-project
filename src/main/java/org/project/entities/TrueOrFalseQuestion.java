package org.project.entities;

import org.project.abstracts.Question;

public class TrueOrFalseQuestion extends Question {

    boolean answer;

    public TrueOrFalseQuestion(String question, boolean answer) {
        super(question);
    }

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

}

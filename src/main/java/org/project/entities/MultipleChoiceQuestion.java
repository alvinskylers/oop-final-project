package org.project.entities;

import org.project.abstracts.Question;

public class MultipleChoiceQuestion extends Question {

    public String[] options;
    public int correctOption;

    public MultipleChoiceQuestion(String question, String[] options, int correctOption) {
        super(question);
        this.question = question;
        this.options = options;
        this.correctOption = correctOption;

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
        setQuestionStatus(Integer.parseInt(answer) == correctOption);
    }

    @Override
    public String toString() {
        String str = "Question: \n";
        str += this.question;
        for (int i = 0; i < this.options.length; i++) {
            str += this.options[i];
            if (i < this.options.length-1){
                str += "\n";
            }
        }
        return str;
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
        if (((MultipleChoiceQuestion) other).question.equals(this.question) ) {
            return true;
        }

        return false;
    }
}


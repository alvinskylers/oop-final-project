package entity;

import org.junit.jupiter.api.Test;
import org.project.abstracts.Question;
import org.project.entities.TrueOrFalseQuestion;

import static org.junit.jupiter.api.Assertions.*;

public class TrueOrFalseTest {

    String s = "Does being racist make you cool.";
    boolean b = true;
    TrueOrFalseQuestion question = new TrueOrFalseQuestion(s, b);

    boolean B = false;
    TrueOrFalseQuestion questionClone = new TrueOrFalseQuestion(s, B);

    @Test
    public void doesQuestionExists() {
        assertNotNull(question);
        assertInstanceOf(TrueOrFalseQuestion.class, question);
    }

    @Test
    public void areQuestionsEqual() {
        assertEquals(question, questionClone);
    }

    @Test
    public void answerQuestionRight() {
        question.answerQuestion("true");
        System.out.println(question.isPass());
    }

    @Test
    public void answerQuestionWrong() {
        question.answerQuestion("false");
        System.out.println(question.isPass());
    }

    @Test
    public void QuestionPass(){
        answerQuestionRight();
        assertEquals(true,question.isPass());
    }

    @Test
    public void QuestionNotPass(){
        answerQuestionWrong();
        assertEquals(false,question.isPass());
    }

    public void answerQuestion(String answer, Question question) {
        question.answerQuestion(answer);
    }
}

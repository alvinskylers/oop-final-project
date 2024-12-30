package entity;

import org.junit.jupiter.api.Test;
import org.project.entities.TrueOrFalseQuestion;

import static org.junit.jupiter.api.Assertions.*;

public class TrueOrFalseTest {

    String s = "Does being racist make you cool.";
    boolean b = true;
    TrueOrFalseQuestion question = new TrueOrFalseQuestion(s, b);

    @Test
    public void doesQuestionExists() {
        assertNotNull(question);
        assertInstanceOf(TrueOrFalseQuestion.class, question);
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
}

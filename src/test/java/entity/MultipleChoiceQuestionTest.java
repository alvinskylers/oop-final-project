package entity;

import org.junit.jupiter.api.Test;
import org.project.entities.MultipleChoiceQuestion;

import static org.junit.jupiter.api.Assertions.*;

public class MultipleChoiceQuestionTest {

    String q = "is being racist good?";
    String[] o = {"totally", "nope", "not sure"};
    int a = 1;
    MultipleChoiceQuestion question = new MultipleChoiceQuestion(q, o, a);

    @Test
    public void doesQuestionExist() {
       assertNotNull(question);
        assertInstanceOf(MultipleChoiceQuestion.class, question);
    }

    @Test
    public void answerQuestionRight() {
        question.answerQuestion("1");
    }

    @Test
    public void answerQuestionWrong(){
        question.answerQuestion("2");
    }

    @Test
    public void QuestionPass() {
        answerQuestionRight();
        assertTrue(question.isPass());
    }

    @Test
    public void QuestionNotPass() {
        answerQuestionWrong();
        assertFalse(question.isPass());
    }

}

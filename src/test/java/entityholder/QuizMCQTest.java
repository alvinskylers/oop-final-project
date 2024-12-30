package entityholder;

import entity.MultipleChoiceQuestionTest;
import org.junit.jupiter.api.Test;
import org.project.player.LoadedQuiz;
import org.project.entities.MultipleChoiceQuestion;

import static org.junit.jupiter.api.Assertions.*;

public class QuizMCQTest {

    String q1 = "is being racist good?";
    String[] o1 = {"totally", "nope", "not sure"};
    int a1 = 1;

    String q2 = "is sigma a cool guy?";
    String[] o2 = {"totally", "nope", "not sure"};
    int a2 = 1;

    String q3 = "is \"9/11\" a nine out of a eleven event?";
    String[] o3 = {"absolutely", "nope", "not sure"};
    int a3 = 1;

    MultipleChoiceQuestion question1 = new MultipleChoiceQuestion(q1,o1,1);
    MultipleChoiceQuestion question2 = new MultipleChoiceQuestion(q2,o2,1);
    MultipleChoiceQuestion question3 = new MultipleChoiceQuestion(q3,o3,1);

    LoadedQuiz quiz = new LoadedQuiz("Rad Quiz", "null atm don't worry will add later");
    MultipleChoiceQuestionTest questionTest = new MultipleChoiceQuestionTest();

    @Test
    public void addQuestionsTest() {
        quiz.addQuestion(question1);
        quiz.addQuestion(question2);
        quiz.addQuestion(question3);
        assertEquals(false, quiz.isQuizEmpty());
    }

    @Test
    public void scoreTest() {
        addQuestionsTest();
        questionTest.answerQuestion("1", question1);
        questionTest.answerQuestion("1", question2);
        questionTest.answerQuestion("1", question3);

        String str = quiz.printScore();
        assertEquals(str, "You solved: " + 3 + " out of " + 3 + " questions correct.");
    }

    @Test
    public void scoreTestWrong() {
        addQuestionsTest();
        questionTest.answerQuestion("1", question1);
        questionTest.answerQuestion("1", question2);
        questionTest.answerQuestion("2", question3);
        String str = quiz.printScore();
        assertEquals(str, "You solved: " + 2 + " out of " + 3 + " questions correct.");
    }
}


package entityholder;

import entity.TrueOrFalseTest;
import org.junit.jupiter.api.Test;
import org.project.entities.TrueOrFalseQuestion;
import org.project.player.LoadedQuiz;

import static org.junit.jupiter.api.Assertions.*;

public class QuizTOFTest {

    String s1 = "Does being racist make you cool.";
    boolean b1 = true;

    String s2 = "Does being a nerd make you cool.";
    boolean b2 = true;

    String s3 = "Does being a cat lover make you cool.";
    boolean b3 = true;

    TrueOrFalseQuestion question1 = new TrueOrFalseQuestion(s1,b1);
    TrueOrFalseQuestion question2 = new TrueOrFalseQuestion(s2,b2);
    TrueOrFalseQuestion question3 = new TrueOrFalseQuestion(s3,b3);

    LoadedQuiz quiz = new LoadedQuiz("Rad Quiz", "atm there is no description, so cope with it");
    TrueOrFalseTest question = new TrueOrFalseTest();

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
        question.answerQuestion("true", question1);
        question.answerQuestion("true", question2);
        question.answerQuestion("true", question3);
        String str = quiz.printScore();
        assertEquals(str, "You solved: " + 3 + " out of " + 3 + " questions correct.");
    }

    @Test
    public void scoreTestWrong() {
        addQuestionsTest();
        question.answerQuestion("true", question1);
        question.answerQuestion("true", question2);
        question.answerQuestion("false", question3);
        String str = quiz.printScore();
        assertEquals(str, "You solved: " + 2 + " out of " + 3 + " questions correct.");
    }

}

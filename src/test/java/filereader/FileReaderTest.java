package filereader;

import org.junit.jupiter.api.Test;
import org.project.abstracts.Question;
import org.project.entities.TrueOrFalseQuestion;
import org.project.player.FileManager;
import org.project.player.QuizEntity;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTest {



    @Test
    public void fileScanTest() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        FileManager fm = new FileManager();
        Method method = FileManager.class.getDeclaredMethod("scanDirectory");
        method.setAccessible(true);

        File[] files;
        files = (File[]) method.invoke(fm);
        assertNotNull(files);

        for (File file : files) {
            System.out.println(file.getName());
        }
    }

    @Test
    public void convertFilesToStringArray(){
        FileManager fm = new FileManager();
        String[] filenames =fm.getFileNames();

        //values may vary, check \questions dir to match
        String[] expected = {"questions.csv" ,"questions.txt", "statements.csv", "statements.txt"};

        for (String file : filenames) {
            System.out.println(file);
        }

        assertNotNull(filenames);
        assertArrayEquals(expected, filenames);
    }

    @Test
    public void quizComposingWorks() {
        FileManager fm = new FileManager();
        File file = fm.getFile(3);
        String[] metadata = fm.getQuizMetadata(file);
        ArrayList<Question> questions = fm.getQuizQuestions(file);

        QuizEntity quiz = new QuizEntity(metadata[0],metadata[1]);
        for (Question question : questions) {
            System.out.println(question);
            quiz.addQuestion(question);
        }
        assertNotNull(quiz);

        String title = "test quiz";
        String desc = "metadata here";
        ArrayList<Question> testQuestions = new ArrayList<>();
        TrueOrFalseQuestion q1 =new TrueOrFalseQuestion("being racist is cool",true);
        TrueOrFalseQuestion q2 =new TrueOrFalseQuestion("being a nerd is cool",true);
        testQuestions.add(q1);
        testQuestions.add(q2);

        QuizEntity quizTest = new QuizEntity(title, desc);
        for (Question question : testQuestions) {
            quizTest.addQuestion(question);
        }
        assertNotNull(quizTest);

        assertEquals(quizTest, quiz);
    }

}

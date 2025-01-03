package org.project.player;

import org.project.abstracts.Question;
import org.project.entities.MultipleChoiceQuestion;
import org.project.entities.TrueOrFalseQuestion;

import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileManager {
    private Scanner scanner;

    public FileManager() {
        this.scanner = new Scanner(System.in);
    }

    public File getFile(int index) {
        File[] files = getFiles();
        return files[index];
    }

    public File[] getFiles() {
        File[] files = scanDirectory();
        return files;
    }

    public String[] getFileNames() {
        ArrayList<String> files = new ArrayList<>();
        for (File file : getFiles()) {
            files.add(file.getName());
        }
        String[] filenames = files.toArray(new String[0]);
        return filenames;
    }

    public String[] getQuizMetadata(File file) {
        return extractMetadata(file);
    }

    public ArrayList<Question> getQuizQuestions(File file) {
        return extractQuestions(file);
    }

    private File[] scanDirectory() {
        Path filePath = Paths.get("./", "questions");
        String[] extensions = {".txt", ".csv"};
        File[] allFiles = filePath.toFile().listFiles();
        ArrayList<File> filteredFiles = new ArrayList<>();
        for (File file : allFiles) {
            if (file.getName().endsWith(extensions[0]) || file.getName().endsWith(extensions[1])) {
                filteredFiles.add(file);
            }
        }
        File[] files = filteredFiles.toArray(new File[0]);
        return files;
    }

    private ArrayList<Question> extractQuestions(File file) {
        ArrayList<Question> questions = new ArrayList<>();
        try (BufferedReader bureader = new BufferedReader(new FileReader(file))) {
            ArrayList<String> extractedData = new ArrayList<>();
            String line;
            while ((line = bureader.readLine()) != null) {
                extractedData.add(line);
                System.out.println(line);
            }
            extractedData.remove(0);
            for (String extracted : extractedData) {
                String[] data = extracted.split(",");
                if (data.length <= 2) {
                    questions.add(new TrueOrFalseQuestion(data[0], Boolean.parseBoolean(data[1])));
                } else if (data.length <= 6) {
                    String[] options = grabOptions(data);
                    questions.add(new MultipleChoiceQuestion(data[0], options, Integer.parseInt(data[5])));
                } else {
                    Throwable t = new Exception("invalid data format");
                    System.out.println(t.getMessage());
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException("file/resource missing");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return questions;
    }

    private String[] extractMetadata(File file) {
        try (BufferedReader bureader = new BufferedReader(new FileReader(file))) {
            String data = bureader.readLine();
            return data.split(",");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    private String[] grabOptions(String[] data) {
        String[] options = new String[3];
        for (int i = 1, j = 0; i < data.length - 1; i++, j++) {
            options[j] = data[i];
        }
        return options;
    }



}

package org.project.player;

import java.util.Scanner;

public class UserInterface {
    private Scanner scanner;

    private QuizEntity quiz;
    private String line = "\n============================\n";

    public UserInterface(Scanner scanner) {
        this.scanner = scanner;

    }

    public void start() {
        while (true) {
            printMenu();
            String input = scanner.nextLine();
            if (input.equals("1")) {
//                startQuiz();
            } else if (input.equals("2")) {
                printHelp();
            } else if (input.equals("3")) {
                System.out.println("See you next time!");
                System.exit(0);
            }
        }

    }

    private void printMenu() {
        System.out.println("\n====== CLI Quiz Program ======\n");
        System.out.println("[1] Start Quiz\n[2] Help Quiz\n[3] Exit");
        System.out.print("Enter your choice: ");
    }

    private void printHelp() {
        System.out.println("\n==== CLI Quiz Program ====\n");
        System.out.println(" === Quiz Types === ");
        System.out.println("There are only 2 kind of quiz types. Multiple Choice and True or False\n" +
                            "To answer Multiple Choice Questions, you only need to input the number of the corresponding choice.\n" +
                            "To answer True or False you can answer \"true\", \"yes\", \"false\" or \"no\" to the given statement.\n");

        System.out.println(" === Import Quiz === ");
        System.out.println("Yes, you can import your own quiz. The first line of the file is the header. " +
                            "\nIt contains the quiz title & description ex: (Quiz Title), (Quiz Desc)" +
                            "\nTo import multiple question choice you must provide the following fields:\n" +
                            "question, option1, option2, option3, option4, answer(option number)\n ");

        System.out.println("for True or False, you can follow the following format: \n" +
                            "statement, answer (boolean only)\n" +
                            "there is no limit of how many questions you can import\n" +
                            "but do keep in mind to make sure all of the questions \n" +
                            "follow this format or else the program will not import them!" + line);

    }

//    private void startQuiz() {
//        System.out.println("Scanning questions directory...");
//        String[] files = fileUtility.grabCurrentFiles();
//        if (files==null) {
//            Throwable e = new Throwable("question directory is empty or no supported file extension");
//            System.out.println("error: " + e.getMessage());
//        } else {
//            System.out.println("files found..." + line);
//            System.out.println("choose a question source: ");
//            int i = 1;
//            for (String file : files) {
//                System.out.println("[" +i + "] " + file);
//                i++;
//            }
//            while (true) {
//                System.out.print("question source number: ");
//                String input = scanner.nextLine();
//                try {
//                    int choice = Integer.parseInt(input);
//                    if (choice < files.length) {
//
//                    }
//                } catch (NumberFormatException e) {
//                    System.out.println("not a valid option.");
//                }
//            }
//        }
//    }





}

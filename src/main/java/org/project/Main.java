package org.project;

import org.project.player.UserInterface;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");

        Scanner input = new Scanner(System.in);
        UserInterface ui = new UserInterface(input);

        ui.start();
    }
}
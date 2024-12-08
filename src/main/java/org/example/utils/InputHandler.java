package org.example.utils;

import java.util.Scanner;

public class InputHandler {
    private final Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput(String prompt) {
        System.out.println(prompt);
        return scanner.nextLine();
    }
}

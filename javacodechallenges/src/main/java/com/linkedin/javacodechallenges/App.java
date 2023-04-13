package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("What file would you like to " +
                "read information from?");
        String fileName = scanner.nextLine();

        TicketUtils.parseCSVfile(fileName);

        scanner.close();
    }
}

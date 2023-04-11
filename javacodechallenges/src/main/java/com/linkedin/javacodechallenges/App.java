package com.linkedin.javacodechallenges;

import java.util.Scanner;
import java.util.regex.Pattern;

public class App {

    public static boolean isPasswordComplex(String password) {
        Pattern pattern = Pattern.compile("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$");

        return pattern.matcher(password).matches();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a password: ");
        String userInput = scanner.nextLine();
        System.out.println("Is the password complex? "
                + isPasswordComplex(userInput));

        scanner.close();
    }
}

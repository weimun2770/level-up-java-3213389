package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class DoubleOrNothing {

  private int startingPoint = 10;
  private Scanner scanner = new Scanner(System.in);
  private boolean isContinue = false;

  public void playGame() {
    // TODO: Implement method

    printWelcome();
    askUserToContinue();

    while (isContinue) {
      int randomNum = (int) (Math.random() * (10 - 1 + 1) + 1);

      startingPoint = randomNum % 2 == 0 ? startingPoint * 2 : 0;

      printResult();
      askUserToContinue();
    }

    printGoodbye();
    scanner.close();
  }

  private void printWelcome() {
    System.out.println("Welcoem to Double Or Nothing."
        + "\nYou have " + startingPoint + " starting points");
  }

  private void printResult() {
    if (startingPoint == 0) {
      System.out.println("Too bad, you lose all your points.");
    } else {
      System.out.println("Congratulation, you have " + startingPoint + " points now.");
    }
  }

  private void askUserToContinue() {
    if (startingPoint == 0) {
      System.out.println("Do you want to restart and double your points? (Y/N) : ");
      isContinue = scanner.nextLine().equalsIgnoreCase("Y");
      if (isContinue) {
        startingPoint = 10;
        System.out.println("Ok, you have " + startingPoint + " points now, and the game started.");
      }
    } else {
      System.out.println("Do you want to double your points? (Y/N) : ");
      isContinue = scanner.nextLine().equalsIgnoreCase("Y");
    }
  }

  private void printGoodbye() {
    System.out.println("Goodbye. You have " + startingPoint + " point(s).");
    System.out.println("Hope to see you again.");
  }
}
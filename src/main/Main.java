package main;

import checker.Checker;
import database.Database;

/**
 * Class used to run the code
 */
public final class Main {

  private Main() {
    ///constructor for checkstyle
  }

  /**
   * This method is used to call the checker which calculates the score
   *
   * @param args the arguments used to call the main method
   */
  public static void main(final String[] args) {
    Database database = new Database();
    database.readInput("1");
    Checker.calculateScore();
  }
}

package strategy;

import database.Child;

public class BabyStrategy implements NiceScoreStrategy {

  @Override
  public Double getAverageNiceScore(Child child) {
    return 10.0;
  }
}

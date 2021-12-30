package factory;

import database.Child;
import strategy.BabyStrategy;
import strategy.KidStrategy;
import strategy.NiceScoreStrategy;
import strategy.TeenStrategy;

public final class StrategyFactory {

  public static NiceScoreStrategy getStrategy(Child child) {
    if (child.getAge() < 5) {
      return new BabyStrategy();
    }
    if (child.getAge() >= 5 && child.getAge() < 12) {
      return new KidStrategy();
    }
    if (child.getAge() >= 12 && child.getAge() <= 18) {
      return new TeenStrategy();
    }
    return null;
  }
}

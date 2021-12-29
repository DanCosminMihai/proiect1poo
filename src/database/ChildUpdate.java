package database;

import java.util.ArrayList;

public class ChildUpdate {

  private int id;
  private Double niceScore;
  private ArrayList<String> giftPreferences;

  public ChildUpdate(int id, Double niceScore, ArrayList<String> giftPreferences) {
    this.id = id;
    this.niceScore = niceScore;
    this.giftPreferences = giftPreferences;
  }

  public int getId() {
    return id;
  }

  public Double getNiceScore() {
    return niceScore;
  }

  public ArrayList<String> getGiftPreferences() {
    return giftPreferences;
  }
}

package database;

import java.util.ArrayList;

public class ChildUpdate {

  private int id;
  private String niceScore;
  private ArrayList<String> giftPreferences;

  public ChildUpdate(int id, String niceScore, ArrayList<String> giftPreferences) {
    this.id = id;
    this.niceScore = niceScore;
    this.giftPreferences = giftPreferences;
  }

  public int getId() {
    return id;
  }

  public String getNiceScore() {
    return niceScore;
  }

  public ArrayList<String> getGiftPreferences() {
    return giftPreferences;
  }

  @Override
  public String toString() {
    return "ChildUpdate{" +
        "id=" + id +
        ", niceScore=" + niceScore +
        ", giftPreferences=" + giftPreferences +
        '}';
  }
}

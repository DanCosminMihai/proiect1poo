package database;

import java.util.ArrayList;

public final class Child {

  private int id;
  private String lastName;
  private String firstName;
  private String city;
  private int age;
  private ArrayList<String> giftsPreferences;
  private Double averageScore;
  private ArrayList<Double> niceScoreHistory;
  private Double assignedBudget;
  private ArrayList<Gift> receivedGifts;

  public Child(int id, String lastName, String firstName, int age, String city,
      Double niceScore, ArrayList<String> giftsPreferences) {
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
    this.age = age;
    this.city = city;
    this.averageScore = niceScore;
    this.giftsPreferences = giftsPreferences;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public int getAge() {
    return age;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  public ArrayList<String> getGiftsPreferences() {
    return giftsPreferences;
  }

  public void setGiftsPreferences(ArrayList<String> giftsPreferences) {
    this.giftsPreferences = giftsPreferences;
  }

  public ArrayList<Double> getNiceScoreHistory() {
    return niceScoreHistory;
  }

  public void setNiceScoreHistory(ArrayList<Double> niceScoreHistory) {
    this.niceScoreHistory = niceScoreHistory;
  }

  public Double getAverageScore() {
    return averageScore;
  }

  public void setAverageScore(Double averageScore) {
    this.averageScore = averageScore;
  }

  public Double getAssignedBudget() {
    return assignedBudget;
  }

  public void setAssignedBudget(Double assignedBudget) {
    this.assignedBudget = assignedBudget;
  }

  public ArrayList<Gift> getReceivedGifts() {
    return receivedGifts;
  }

  public void setReceivedGifts(ArrayList<Gift> receivedGifts) {
    this.receivedGifts = receivedGifts;
  }

  @Override
  public String toString() {
    return "Child{" +
        "id=" + id +
        ", lastName='" + lastName + '\'' +
        ", firstName='" + firstName + '\'' +
        ", city='" + city + '\'' +
        ", age=" + age +
        ", giftsPreference=" + giftsPreferences +
        ", averageScore=" + averageScore +
        ", niceScoreHistory=" + niceScoreHistory +
        ", assignedBudget=" + assignedBudget +
        ", receivedGifts=" + receivedGifts +
        '}';
  }


}

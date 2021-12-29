package database;

import java.util.ArrayList;

public final class Child {

  private int id;
  private String lastName;
  private String firstName;
  private int age;
  private String city;
  private Double niceScore;
  private ArrayList<String> giftsPreference;

  public Child(int id, String lastName, String firstName, int age, String city,
      Double niceScore, ArrayList<String> giftsPreference) {
    this.id = id;
    this.lastName = lastName;
    this.firstName = firstName;
    this.age = age;
    this.city = city;
    this.niceScore = niceScore;
    this.giftsPreference = giftsPreference;
  }

  public int getId() {
    return id;
  }

  public String getLastName() {
    return lastName;
  }

  public String getFirstName() {
    return firstName;
  }

  public int getAge() {
    return age;
  }

  public String getCity() {
    return city;
  }

  public Double getNiceScore() {
    return niceScore;
  }

  public ArrayList<String> getGiftsPreference() {
    return giftsPreference;
  }

  @Override
  public String toString() {
    return "Child{" +
        "id=" + id +
        ", lastName='" + lastName + '\'' +
        ", firstName='" + firstName + '\'' +
        ", age=" + age +
        ", city=" + city +
        ", niceScore=" + niceScore +
        ", giftsPreference=" + giftsPreference +
        '}';
  }
}

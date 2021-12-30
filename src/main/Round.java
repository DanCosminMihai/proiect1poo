package main;

import database.Child;
import database.Database;
import database.Gift;
import factory.StrategyFactory;
import java.util.ArrayList;
import strategy.NiceScoreStrategy;

public class Round {

  public void newRound(int roundNumber, Database database) {
    if (roundNumber > 0) {
      //update budget
      database.setSantaBudget(database.getAnnualChanges().get(roundNumber - 1).getNewSantaBudget());
      //increment kids age
      database.getChildren().forEach((child) -> child.setAge(child.getAge() + 1));

      //remove if adult
      database.getChildren().removeIf((child) -> child.getAge() > 18);

      //add new kids
      database.getChildren()
          .addAll(database.getAnnualChanges().get(roundNumber - 1).getNewChildren());
      database.getChildren().forEach((c) -> {
        if (c.getNiceScoreHistory() == null) {
          c.setNiceScoreHistory(new ArrayList<Double>());
          c.getNiceScoreHistory().add(c.getAverageScore());
        }
      });

      //add new gifts
      database.getSantaGiftsList()
          .addAll(database.getAnnualChanges().get(roundNumber - 1).getNewGifts());

      //update kids
      database.getAnnualChanges().get(roundNumber - 1).getChildrenUpdates().forEach((update) -> {
        Child child = Database.getChildById(update.getId(), database);
        if (child != null) {
          //add score to history
          if (!update.getNiceScore().equals("null")) {
            child.getNiceScoreHistory().add(Double.parseDouble(update.getNiceScore()));
          }
          //add prefs
          //make prefs unique
          ArrayList<String> newprefs = update.getGiftPreferences();
          for (String oldpref : child.getGiftsPreferences()) {
            if (!newprefs.contains(oldpref)) {
              newprefs.add(oldpref);
            }
          }
          ArrayList<String> p = new ArrayList<String>();
          for(String pref : newprefs) {
            if(!p.contains(pref)){
              p.add(pref);
            }
          }
          child.setGiftsPreferences(p);
        }
      });

      //sort kids
      database.getChildren().sort((c1, c2) -> c1.getId() - c2.getId());
    }
    database.getChildren().removeIf((child) -> child.getAge() > 18);
    database.getChildren().forEach((child) -> {
      if (roundNumber == 0) {
        child.setNiceScoreHistory(new ArrayList<Double>());
        child.getNiceScoreHistory().add(child.getAverageScore());
      }
      NiceScoreStrategy strategy = StrategyFactory.getStrategy(child);
      if (strategy == null) {
        System.out.println(child);
      }
      child.setAverageScore(strategy.getAverageNiceScore(child));
    });

    Double sum = 0.0;
    for (int i = 0; i < database.getChildren().size(); i++) {
      sum += database.getChildren().get(i).getAverageScore();
    }
    Double budgetUnit = database.getSantaBudget() / sum;
    database.getChildren()
        .forEach((child) -> child.setAssignedBudget(child.getAverageScore() * budgetUnit));

    for (Child child : database.getChildren()) {
      Double budget = child.getAssignedBudget();
      child.setReceivedGifts(new ArrayList<Gift>());
      for (String pref : child.getGiftsPreferences()) {
        ArrayList<Gift> giftArrayList = new ArrayList<>(database.getSantaGiftsList());
        giftArrayList.removeIf((gift) -> !gift.getCategory().equals(pref));
        if (giftArrayList.size() != 0) {
          giftArrayList.sort((g1, g2) -> g1.getPrice().compareTo(g2.getPrice()));
          int i = 0;
          while (i < giftArrayList.size() && giftArrayList.get(i).getPrice() > budget) {
            i++;
          }
          if (i < giftArrayList.size() && giftArrayList.get(i).getPrice() < budget) {
            child.getReceivedGifts().add(giftArrayList.get(i));
            budget -= giftArrayList.get(i).getPrice();
          }
        }
      }
    }
  }
}

package database;

import java.util.ArrayList;

public class AnnualChange {

  private Double newSantaBudget;
  private ArrayList<Gift> newGifts;
  private ArrayList<Child> newChildren;
  private ArrayList<ChildUpdate> childrenUpdates;

  public AnnualChange(Double newSantaBudget, ArrayList<Gift> newGifts,
      ArrayList<Child> newChildren, ArrayList<ChildUpdate> childrenUpdates) {
    this.newSantaBudget = newSantaBudget;
    this.newGifts = newGifts;
    this.newChildren = newChildren;
    this.childrenUpdates = childrenUpdates;
  }

  public Double getNewSantaBudget() {
    return newSantaBudget;
  }

  public ArrayList<Gift> getNewGifts() {
    return newGifts;
  }

  public ArrayList<Child> getNewChildren() {
    return newChildren;
  }

  public ArrayList<ChildUpdate> getChildrenUpdates() {
    return childrenUpdates;
  }

  @Override
  public String toString() {
    return "AnnualChange{" +
        "newSantaBudget=" + newSantaBudget +
        ", newGifts=" + newGifts +
        ", newChildren=" + newChildren +
        ", childrenUpdates=" + childrenUpdates +
        '}';
  }
}

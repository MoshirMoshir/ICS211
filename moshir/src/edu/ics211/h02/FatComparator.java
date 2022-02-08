package edu.ics211.h02;

import java.util.Comparator;

/**
 * Represents a FatComparator.
 * @author Alexander Moshir
 */
public class FatComparator implements Comparator<Cheese> {

  /**
   * Compares fat percentages of two cheeses and returns 1,0,-1 accordingly.
   * @param o1 First Cheese
   * @param o2 Second Cheese
   * @return 1, 0, -1
   */
  @Override
  public int compare(Cheese o1, Cheese o2) {
    if (o1.getFatPercentage() < o2.getFatPercentage()) {
      return -1;
    } else if (o1.getFatPercentage() > o2.getFatPercentage()) {
      return 1;
    } else {
      return 0;
    }
  }

}

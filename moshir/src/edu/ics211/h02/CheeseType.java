package edu.ics211.h02;

import java.util.Random;

/**
 * Represents a CheeseType.
 *
 * @author Cam Moore
 *
 */
public enum CheeseType {
  FRESH, SOFT, FIRM;

  /**
   * Returns a random CheeseType.
   *
   * @return a random CheeseType.
   */
  public static CheeseType getRandomCheeseType() {
    Random random = new Random();
    return values()[random.nextInt(values().length)];
  }
}

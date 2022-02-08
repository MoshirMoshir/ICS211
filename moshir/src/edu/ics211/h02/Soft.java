package edu.ics211.h02;

/**
 * Represents a Soft type cheese.
 * @author Alexander Moshir
 */
public abstract class Soft extends Cheese {
  
  /**
   * Creates a new Soft cheese.
   * @param name the name of this cheese.
   * @param type the type of this cheese.
   * @param fatPercentage the fat percentage of this cheese.
   */
  protected Soft(String name, CheeseType type, Double fatPercentage) {
    super(name, type, fatPercentage);
  }
  
}
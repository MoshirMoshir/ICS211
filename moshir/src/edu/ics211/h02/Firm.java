package edu.ics211.h02;

/**
 * Represents a Firm type cheese.
 * @author Alexander Moshir
 */
public abstract class Firm extends Cheese {
  
  /**
   * Creates a new Firm cheese.
   * @param name the name of this cheese.
   * @param type the type of this cheese.
   * @param fatPercentage the fat percentage of this cheese.
   */
  protected Firm(String name, CheeseType type, Double fatPercentage) {
    super(name, type, fatPercentage);
  }
  
}
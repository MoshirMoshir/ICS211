package edu.ics211.h02;

/**
 * Represents a Fresh type cheese.
 * @author Alexander Moshir
 */
public abstract class Fresh extends Cheese {
  
  /**
   * Creates a new Fresh cheese.
   * @param name the name of this cheese.
   * @param type the type of this cheese.
   * @param fatPercentage the fat percentage of this cheese.
   */
  protected Fresh(String name, CheeseType type, Double fatPercentage) {
    super(name, type, fatPercentage);
  }

}
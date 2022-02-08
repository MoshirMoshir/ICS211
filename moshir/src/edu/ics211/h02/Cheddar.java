package edu.ics211.h02;

/**
 * Represents a Cheddar Cheese.
 * @author Alexander Moshir
 */
public class Cheddar extends Firm {
  
  /**
   * Creates a new Cheddar.
   * @param name the name of this cheese.
   * @param fatPercentage the fat percentage of this cheese.
   */
  public Cheddar(String name, Double fatPercentage) {
    super(name, CheeseType.FIRM, fatPercentage);
  }
  
  /**
   * Creates a new Cheddar.
   * @param name the name of this cheese.
   */
  public Cheddar(String name) {
    super(name, CheeseType.FIRM, Math.random() * .55 + 0.5);
  }
    
  /**
   * Returns String of Cheddar parameters.
   * @return String
   */
  @Override
  public String toString() {
    return "Cheddar [getName()=" + getName() + ", getType()=" + getType() + ", getFatPercentage()="
        + getFatPercentage() + "]";
  }
    
}

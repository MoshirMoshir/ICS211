package edu.ics211.h02;

/**
 * Represents a Parmesan Cheese.
 * @author Alexander Moshir
 */
public class Parmesan extends Firm {
  
  /**
   * Creates a new Parmesan.
   * @param name the name of this cheese.
   * @param fatPercentage the fat percentage of this cheese.
   */
  public Parmesan(String name, Double fatPercentage) {
    super(name, CheeseType.FIRM, fatPercentage);
  }
  
  /**
   * Creates a new Parmesan.
   * @param name the name of this cheese.
   */
  public Parmesan(String name) {
    super(name, CheeseType.FIRM, Math.random() * .55 + 0.5);
  }
    
  /**
   * Returns String of Parmesan parameters.
   * @return String
   */
  @Override
  public String toString() {
    return "Parmesan [getName()=" + getName() + ", getType()=" + getType() + ", getFatPercentage()="
        + getFatPercentage() + "]";
  }
    
}

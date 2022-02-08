package edu.ics211.h02;

/**
 * Represents a Mozzarella Cheese.
 * @author Alexander Moshir
 */
public class Mozzarella extends Fresh {

  /**
   * Creates a new Mozzarella.
   * @param name the name of this cheese.
   * @param fatPercentage the fat percentage of this cheese.
   */
  public Mozzarella(String name, Double fatPercentage) {
    super(name, CheeseType.FRESH, fatPercentage);
  }
  
  /**
   * Creates a new Mozzarella.
   * @param name the name of this cheese.
   */
  public Mozzarella(String name) {
    super(name, CheeseType.FRESH, Math.random() * .55 + 0.5);
  }

  /**
   * Returns String of Mozzarella parameters.
   * @return String
   */
  @Override
  public String toString() {
    return "Mozzarella [getName()=" + getName() + ", getType()=" + getType() + ", "
        + "getFatPercentage()=" + getFatPercentage() + "]";
  }
    
    
}

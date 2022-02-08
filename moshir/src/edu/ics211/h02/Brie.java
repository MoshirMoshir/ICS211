package edu.ics211.h02;

/**
 * Represents a Brie Cheese.
 * @author Alexander Moshir
 */
public class Brie extends Soft {

  /**
   * Creates a new Brie.
   * @param name the name of this cheese.
   * @param fatPercentage the fat percentage of this cheese.
   */
  public Brie(String name, Double fatPercentage) {
    super(name, CheeseType.SOFT, fatPercentage);
  }
  
  /**
   * Creates a new Brie.
   * @param name the name of this cheese.
   */
  public Brie(String name) {
    super(name, CheeseType.SOFT, Math.random() * .55 + 0.5);
  }
    
  /**
   * Returns String of Brie parameters.
   * @return String
   */
  @Override
  public String toString() {
    return "Brie [getName()=" + getName() + ", getType()=" + getType() + ", getFatPercentage()="
        + getFatPercentage() + "]";
  }
    
}

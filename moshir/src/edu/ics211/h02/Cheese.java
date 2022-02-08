package edu.ics211.h02;

/**
 * Represents a Cheese.
 * @author Alexander Moshir
 */
public abstract class Cheese implements Comparable<Cheese> {
  private String name;
  private CheeseType type;
  private Double fatPercentage;
  
  /**
   * Creates a new Cheese.
   * found from https://courses.ics.hawaii.edu/ics211s22/morea/030.oop/experience-H02-cheese.html
   * @param name the name of this cheese.
   * @param type the type of this cheese.
   * @param fatPercentage the fat percentage of this cheese.
   */
  protected Cheese(String name, CheeseType type, Double fatPercentage) {
    super();
    this.name = name;
    this.type = type;
    this.fatPercentage = fatPercentage;
  }
  
  /**
   * Returns the name of cheese.
   * @return name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the name of cheese.
   * @param name name of cheese
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Returns the type of cheese.
   * @return type
   */
  public CheeseType getType() {
    return type;
  }

  /**
   * Returns fat percentage of cheese.
   * @return fatPercentage
   */
  public Double getFatPercentage() {
    return fatPercentage;
  }

  /**
   * Returns result of comparing cheese names.
   * @param o Cheese 2
   * @return compareTo()
   */
  @Override
  public int compareTo(Cheese o) {
    return this.getName().compareTo(o.getName());
  }

  /**
   * Returns a String of Cheese parameters.
   * @return String
   */
  @Override
  public String toString() {
    return "Cheese [name=" + name + ", type=" + type + ", fatPercentage=" + fatPercentage + "]";
  }

}


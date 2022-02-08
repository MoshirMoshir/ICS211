package edu.ics211.h02;

/**
 * Represents a ManoaCheeseFromager.
 * @author Alexander Moshir
 *
 */
public class ManoaCheeseFromager implements CheeseFromager {
  private static ManoaCheeseFromager instance;
  
  /**
   * Returns instance of ManoaCheeseFromager.
   * @return ManoaCheeseFromager instance
   */
  public static ManoaCheeseFromager getInstance() {
    if (instance == null) {
      instance = new ManoaCheeseFromager();
    }
    return instance;
  }

  /**
   * Creates a new ManoaCheeseFromager.
   */
  private ManoaCheeseFromager() {
  }
  
  /**
   * Creates new Cheese with parameters.
   * @param name the name of cheese
   * @param type the type of cheese
   * @param fatPercentage the percentage of fat
   * @return Cheese
   */
  @Override
  public Cheese makeCheese(String name, CheeseType type, Double fatPercentage) {
    // based upon the type, return a new concrete cheese.
    if (type == CheeseType.FRESH) {
      return new Mozzarella(name, fatPercentage);
    } else if (type == CheeseType.SOFT) {
      return new Brie(name, fatPercentage);
    } else if (name.equals("Cheddar")) {
      return new Cheddar(name, fatPercentage);
    } else {
      return new Parmesan(name, fatPercentage);
    }
  }

  /**
   * Creates new Cheese with parameters and default fat%.
   * @param name the name of cheese
   * @param type the type of cheese
   * @return Cheese
   */
  @Override
  public Cheese makeCheese(String name, CheeseType type) {
    if (type == CheeseType.FRESH) {
      return new Mozzarella(name);
    } else if (type == CheeseType.SOFT) {
      return new Brie(name);
    } else if (name.equals("Cheddar")) {
      return new Cheddar(name);
    } else {
      return new Parmesan(name);
    }
  }

  /**
   * Creates new Mozzarella with parameters.
   * @param name the name of cheese
   * @param fatPercentage the percentage of fat
   * @return Mozzarella
   */
  @Override
  public Cheese makeMozzarella(String name, Double fatPercentage) {
    return new Mozzarella(name, fatPercentage);
  }

  /**
   * Creates new Mozzarella with name and generated fat%.
   * @param name the name of cheese
   * @return Mozzarella
   */
  @Override
  public Cheese makeMozzarella(String name) {
    return new Mozzarella(name);
  }

  /**
   * Creates new Brie with parameters.
   * @param name the name of cheese
   * @param fatPercentage the percentage of fat
   * @return Brie
   */
  @Override
  public Cheese makeBrie(String name, Double fatPercentage) {
    return new Brie(name, fatPercentage);
  }

  /**
   * Creates new Brie with name and generated fat%.
   * @param name the name of cheese
   * @return Brie
   */
  @Override
  public Cheese makeBrie(String name) {
    return new Brie(name);
  }

  /**
   * Creates new Cheddar with parameters.
   * @param name the name of cheese
   * @param fatPercentage the percentage of fat
   * @return Cheddar
   */
  @Override
  public Cheese makeCheddar(String name, Double fatPercentage) {
    return new Cheddar(name, fatPercentage);
  }

  /**
   * Creates new Cheddar with name and generated fat%.
   * @param name the name of cheese
   * @return Cheddar
   */
  @Override
  public Cheese makeCheddar(String name) {
    return new Cheddar(name);
  }

  /**
   * Creates new Parmesan with parameters.
   * @param name the name of cheese
   * @param fatPercentage the percentage of fat
   * @return Parmesan
   */
  @Override
  public Cheese makeParmesan(String name, Double fatPercentage) {
    return new Parmesan(name, fatPercentage);
  }

  /**
   * Creates new Parmesan with name and generated fat%.
   * @param name the name of cheese
   * @return Parmesan
   */
  @Override
  public Cheese makeParmesan(String name) {
    return new Parmesan(name);
  }

}

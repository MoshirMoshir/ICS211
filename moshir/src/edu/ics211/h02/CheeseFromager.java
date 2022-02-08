package edu.ics211.h02;

/**
 * Represents a CheeseFromager.
 *
 * @author Cam Moore
 *
 */
public interface CheeseFromager {

  /**
   * Makes a Cheese with the given name, type and fat percentage.
   *
   * @param name the name of the cheese.
   * @param type the type of the cheese.
   * @param fatPercentage the fat percentage of the cheese.
   * @return a new instance of Cheese.
   */
  Cheese makeCheese(String name, CheeseType type, Double fatPercentage);


  /**
   * Makes a Cheese with the given name, type and a random fat percentage.
   *
   * @param name the name of the cheese.
   * @param type the type of the cheese.
   * @return a new instance of Cheese.
   */
  Cheese makeCheese(String name, CheeseType type);


  /**
   * Makes a Mozzarella with the given name and fat percentage.
   *
   * @param name the name of the mozzarella.
   * @param fatPercentage the fat percentage
   * @return a new instance of Mozzarella.
   */
  Cheese makeMozzarella(String name, Double fatPercentage);


  /**
   * Makes a Mozzarella with the given name and random fat percentage.
   *
   * @param name the name of the mozzarella.
   * @return a new instance of Mozzarella.
   */
  Cheese makeMozzarella(String name);


  /**
   * Makes a Brie with the given name and fat percentage.
   *
   * @param name the name of the brie.
   * @param fatPercentage the fat percentage
   * @return a new instance of Brie.
   */
  Cheese makeBrie(String name, Double fatPercentage);


  /**
   * Makes a Brie with the given name and random fat percentage.
   *
   * @param name the name of the brie.
   * @return a new instance of Brie.
   */
  Cheese makeBrie(String name);


  /**
   * Makes a Cheddar with the given name and fat percentage.
   *
   * @param name the name of the cheddar.
   * @param fatPercentage the fat percentage
   * @return a new instance of Cheddar.
   */
  Cheese makeCheddar(String name, Double fatPercentage);


  /**
   * Makes a Cheddar with the given name and random fat percentage.
   *
   * @param name the name of the cheddar.
   * @return a new instance of Cheddar.
   */
  Cheese makeCheddar(String name);


  /**
   * Makes a Parmesan with the given name and fat percentage.
   *
   * @param name the name of the parmesan.
   * @param fatPercentage the fat percentage
   * @return a new instance of Parmesan.
   */
  Cheese makeParmesan(String name, Double fatPercentage);


  /**
   * Makes a Parmesan with the given name and random fat percentage.
   *
   * @param name the name of the parmesan.
   * @return a new instance of Parmesan.
   */
  Cheese makeParmesan(String name);

}

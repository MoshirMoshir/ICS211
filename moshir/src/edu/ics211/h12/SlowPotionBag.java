package edu.ics211.h12;

import java.util.ArrayList;

/**
 * SlowPotionBag potionbag with O(n).
 * Uses an array
 * @author Alexander Moshir
 *
 */
public class SlowPotionBag implements PotionBag {
   
  //Declare variables
  ArrayList<Potion> array;
  long start;
  long end;

  /**
   * initializes variables.
   */
  public SlowPotionBag() {
    array = new ArrayList<Potion>();
  }

  /**
   * Stores the given Potion in the PotionBag.
   *
   * @param p the Potion to store.
   */
  @Override
  public void store(Potion p) {
    array.add(p);
  }

  /**
   * Returns the number of nanoseconds it took to store a potion.
   *
   * @param p the potion to store.
   * @return the duration in nanoseconds it took to store a potion.
   */
  @Override
  public long timedStore(Potion p) {
    start = System.nanoTime();
    this.store(p);
    end = System.nanoTime();
    return end - start;
  }

  /**
   * Retrieves the Potion from the bag.
   *
   * @param p the Potion to retrieve.
   * @return the Potion or null if the Potion was not in the bag.
   */
  @Override
  public Potion retrieve(Potion p) {
    if (array.remove(p)) {
      return p;
    } else {
      return null;
    }
  }

  /**
   * Returns the number of nanoseconds to takes to retrieve a potion.
   *
   * @param p the potion to retrieve.
   * @return the number of nanoseconds it takes to retrieve a potion.
   */
  @Override
  public long timedRetrieve(Potion p) {
    start = System.nanoTime();
    this.retrieve(p);
    end = System.nanoTime();
    return end - start;
  }

  /**
   * Returns the number of Potions in the bag.
   *
   * @return the number of Potions in the bag.
   */
  @Override
  public int size() {
    return array.size();
  }
  
  /**
   * getInstance returns itself.
   * @return itself.
   */
  public static SlowPotionBag getInstance() {
    return new SlowPotionBag();
  }

}

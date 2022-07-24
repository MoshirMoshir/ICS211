package edu.ics211.h12;

import java.util.Hashtable;

/**
 * QuickPotionBag potionbag with O(1).
 * Uses a hashtable
 * @author Alexander Moshir
 *
 */
public class QuickPotionBag implements PotionBag {
   
  //Declare variables
  Hashtable<Potion, Potion> table;
  long start;
  long end;

  /**
   * initializes variables.
   */
  public QuickPotionBag() {
    table = new Hashtable<>();
  }

  /**
   * Stores the given Potion in the PotionBag.
   *
   * @param p the Potion to store.
   */
  @Override
  public void store(Potion p) {
    table.put(p, p);
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
    Potion tmp = table.get(p);
    table.remove(p);
    return tmp;
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
    return table.size();
  }
  
  /**
   * getInstance returns itself.
   * @return itself.
   */
  public static QuickPotionBag getInstance() {
    return new QuickPotionBag();
  }
  
  
}

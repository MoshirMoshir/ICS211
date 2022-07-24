package edu.ics211.h12;

import edu.ics211.h10.BinarySearchTree;
import java.util.Comparator;

/**
 * MediumPotionBag potionbag with O(1).
 * Uses a binary tree
 * @author Alexander Moshir
 *
 */
public class MediumPotionBag implements PotionBag {
   
  //Declare variables
  BinarySearchTree<Potion> tree;
  Comparator<Potion> comp = new Comparator<Potion>() {
      /**
       * Comparator for binary tree.
       * @param p1 first potion
       * @param p2 second potion
       * @return 0 if equal, 1 or -1 for hash size difference respectivly 
       */
      public int compare(Potion p1, Potion p2) {
        if (p1.hashCode() == p2.hashCode()) {
          return 0;
        } else if (p1.hashCode() > p2.hashCode()) {
          return 1;
        } else {
          return -1;
        }
      }
  };
  long start;
  long end;

  /**
   * initializes variables.
   */
  public MediumPotionBag() {

    tree = new BinarySearchTree<Potion>(comp);
  }

  /**
   * Stores the given Potion in the PotionBag.
   *
   * @param p the Potion to store.
   */
  @Override
  public void store(Potion p) {
    tree.add(p);
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
    Potion tmp = tree.find(p);
    tree.remove(p);
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
    return tree.size();
  }
  
  /**
   * getInstance returns itself.
   * @return itself.
   */
  public static MediumPotionBag getInstance() {
    return new MediumPotionBag();
  }
  
}

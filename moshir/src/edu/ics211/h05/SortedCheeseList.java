package edu.ics211.h05;

import edu.ics211.h02.Cheese;
import java.util.Comparator;


/**
 * Represents a SortableCheeseList.
 *
 * @author Alexander Moshir
 *
 */
public class SortedCheeseList implements IList211<Cheese> {

  // Declare.
  private SortableList<Cheese> theCheeses;
  private Comparator<Cheese> comp;


  /**
   * Creates a new SortableCheeseList.
   * @param c comparator of cheeses
   */
  public SortedCheeseList(Comparator<Cheese> c) {
    // initialize the variables
    theCheeses = new SortableList<Cheese>();
    comp = c;
  }

  /**
   * Gets the Cheese at index.
   * @param index index of cheese you want to get
   * @return returns the cheese at index
   */
  @Override
  public Cheese get(int index) {
    return theCheeses.get(index);
  }

  /**
   * Sets the Cheese at index.
   * @param index index of where Cheese should be set
   * @param element the Cheese to be set
   * @return returns the Cheese replaced
   */
  @Override
  public Cheese set(int index, Cheese element) {
    return theCheeses.set(index, element);

  }

  /**
   * gets the index of obj/Cheese.
   * @param obj obj of index to be found
   * @return returns the index of obj or -1 if not found
   */
  @Override
  public int indexOf(Object obj) {
    
    return theCheeses.indexOf(obj);
  }

  /**
   * gets the size of theCheeses list.
   * @return the size of theCheeses list
   */
  @Override
  public int size() {
    return theCheeses.size();
  }

  /**
   * adds a cheese to the end of the list.
   * @param e cheese to be added
   * @return returns true if added
   */
  @Override
  public boolean add(Cheese e) {
    boolean temp = theCheeses.add(e);
    theCheeses.insertionSort(comp);
    return temp;
  }

  /**
   * adds a cheese at index specified.
   * @param index index of where cheese should be added
   * @param element cheese to be added
   */
  @Override
  public void add(int index, Cheese element) {
    theCheeses.add(index, element);
    theCheeses.selectionSort(comp);
  }

  /**
   * removes a cheese at index.
   * @param index index of where cheese that will be removed
   * @return cheese that was removed
   */
  @Override
  public Cheese remove(int index) {
    return theCheeses.remove(index);
  }

}

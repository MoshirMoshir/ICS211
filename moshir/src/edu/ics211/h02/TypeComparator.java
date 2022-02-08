package edu.ics211.h02;

import java.util.Comparator;

/**
 * Represents a TypeComparator.
 * @author Alexander Moshir
 */
public class TypeComparator implements Comparator<Cheese> {

  /**
   * Compares First cheese type with second cheese type.
   * @param o1 Cheese one
   * @param o2 Cheese two
   * @return compareTo()
   */
  @Override
  public int compare(Cheese o1, Cheese o2) {
    return o1.getType().compareTo(o2.getType());
  }
  
}

package edu.ics211.h04;

import java.util.Comparator;

/**
 * Represents a StringComparator.
 * 
 * @author Alexander Moshir
 *
 */
public class StringComparator implements Comparator<String> {

  @Override
  public int compare(String o1, String o2) {
    return o1.compareTo(o2);
  }

}

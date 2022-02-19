package edu.ics211.h06;

import edu.ics211.h02.Cheese;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

/**
 * Represents a JosephusCheesePlate.
 * @author Alexander Moshir
 *
 */
public class JosephusCheesePlate implements ICheeseTasting {
    
  List<Cheese> plate;
  Cheese[] array;

  /**
   * Represents a JosephusCheesPlate.
   * @param e array of cheeses
   */
  public JosephusCheesePlate(Cheese[] e) {
    array = e;
  }

  @Override
  public List<Cheese> tasteCheeses(int start, int step, boolean isClockwise) {
      
    CircularDoublyLinkedList<Cheese> linkedList = new CircularDoublyLinkedList<Cheese>();
    ListIterator<Cheese> it = (ListIterator<Cheese>) plate.iterator();
    
    if (isClockwise) {
      for (int i = 0; i < plate.size(); i++) {
        it.next();
        plate.add(it.next());
        it.remove();
      }
    } else {
      for (int i = 0; i < plate.size(); i++) {
        it.previous();
        plate.add(it.next());
        it.remove();
      }
    }
    return plate;
  }

}

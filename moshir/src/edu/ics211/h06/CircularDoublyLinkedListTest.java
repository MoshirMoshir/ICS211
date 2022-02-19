package edu.ics211.h06;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import edu.ics211.h02.Cheese;
import edu.ics211.h02.CheeseType;
import edu.ics211.h02.ManoaCheeseFromager;
import java.util.Iterator;
import java.util.ListIterator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CircularDoublyLinkedListTest {
  private ManoaCheeseFromager fromager;
  private Cheese[] cheeses;
  private static final int NUM_CHEESES = 13;

  @BeforeEach
  public void setUp() throws Exception {
    this.fromager = ManoaCheeseFromager.getInstance();
    this.cheeses = new Cheese[NUM_CHEESES];
    for (int i = 0; i < NUM_CHEESES; i++) {
      cheeses[i] = fromager.makeCheese("Cheese " + i, CheeseType.getRandomCheeseType());
    }
  }


  @Test
  void testCircularDoublyLinkedList() {
    CircularDoublyLinkedList<Cheese> list = new CircularDoublyLinkedList<Cheese>();
    assertNotNull(list);
    assertEquals(0, list.size());
  }

  @Test
  void testCircularDoublyLinkedListEArray() {
    CircularDoublyLinkedList<Cheese> list = new CircularDoublyLinkedList<Cheese>(cheeses);
    assertNotNull(list);
    assertEquals(NUM_CHEESES, list.size());
  }


  @Test
  void testIterator() {
    CircularDoublyLinkedList<Cheese> list = new CircularDoublyLinkedList<Cheese>();
    Iterator<Cheese> iter = list.iterator();
    assertNotNull(iter);
    assertFalse(iter.hasNext());
    try {
      iter.next();
      fail("Shouldn't be able to call next.");
    } catch (Exception e) {
      // expected
    }
    ListIterator<Cheese> listIter = null;
    try {
      listIter = (ListIterator<Cheese>) iter;
    } catch (ClassCastException cce) {
      fail("Iterator is the wrong type.");
    }
    for (int i = 0; i < NUM_CHEESES; i++) {
      list.add(cheeses[i]);
    }
    listIter = (ListIterator<Cheese>) list.iterator();
    assertTrue(listIter.hasNext());
    assertTrue(listIter.hasPrevious());
    for (int i = 0; i < NUM_CHEESES; i++) {
      assertEquals(cheeses[i], listIter.next());
      assertEquals(i, listIter.previousIndex());
    }
    assertEquals(0, listIter.nextIndex());
    assertEquals(NUM_CHEESES - 1, listIter.previousIndex());
    for (int i = NUM_CHEESES - 1; i >= 0; i--) {
      assertEquals(cheeses[i], listIter.previous());
      assertEquals(i, listIter.nextIndex());
    }
  }


  @Test
  void testGet() {
    CircularDoublyLinkedList<Cheese> list = new CircularDoublyLinkedList<Cheese>();
    try {
      list.get(-1);
      fail("-1 is invalid index.");
    } catch (IndexOutOfBoundsException ioobe) {
      // expected
    }
    try {
      list.get(list.size());
      fail("size is invalid index.");
    } catch (IndexOutOfBoundsException ioobe) {
      // expected
    }
    for (int i = 0; i < NUM_CHEESES; i++) {
      list.add(cheeses[i]);
    }
    assertEquals(cheeses[0], list.get(0));
    assertEquals(cheeses[NUM_CHEESES - 1], list.get(NUM_CHEESES - 1));
  }


  @Test
  void testSet() {
    CircularDoublyLinkedList<Cheese> list = new CircularDoublyLinkedList<Cheese>();
    for (int i = 0; i < NUM_CHEESES; i++) {
      list.add(cheeses[i]);
    }
    Cheese c = fromager.makeCheese("new", CheeseType.getRandomCheeseType());
    assertEquals(cheeses[0], list.set(0, c));
    assertEquals(c, list.get(0));
    assertEquals(cheeses[NUM_CHEESES - 1], list.set(NUM_CHEESES - 1, c));
    assertEquals(c, list.get(NUM_CHEESES - 1));
    try {
      list.set(-1, c);
      fail("-1 is invalid index.");
    } catch (IndexOutOfBoundsException ioobe) {
      // expected
    }
    try {
      list.set(list.size(), c);
      fail("size is invalid index.");
    } catch (IndexOutOfBoundsException ioobe) {
      // expected
    }
  }


  @Test
  void testIndexOf() {
    CircularDoublyLinkedList<Cheese> list = new CircularDoublyLinkedList<Cheese>();
    for (int i = 0; i < NUM_CHEESES; i++) {
      list.add(cheeses[i]);
    }
    Cheese c = fromager.makeCheese("new", CheeseType.getRandomCheeseType());
    assertEquals(0, list.indexOf(cheeses[0]));
    assertEquals(NUM_CHEESES - 1, list.indexOf(cheeses[NUM_CHEESES - 1]));
    assertEquals(-1, list.indexOf(c));
  }


  @Test
  void testSize() {
    CircularDoublyLinkedList<Cheese> list = new CircularDoublyLinkedList<Cheese>();
    assertEquals(0, list.size());
    for (int i = 0; i < NUM_CHEESES; i++) {
      list.add(cheeses[i]);
      assertEquals(i + 1, list.size());
    }
  }


  @Test
  void testAddE() {
    CircularDoublyLinkedList<Cheese> list = new CircularDoublyLinkedList<Cheese>();
    assertEquals(0, list.size());
    for (int i = 0; i < NUM_CHEESES; i++) {
      list.add(cheeses[i]);
      assertEquals(i + 1, list.size());
    }
  }


  @Test
  void testAddIntE() {
    CircularDoublyLinkedList<Cheese> list = new CircularDoublyLinkedList<Cheese>();
    assertEquals(0, list.size());
    for (int i = 0; i < NUM_CHEESES; i++) {
      list.add(cheeses[i]);
      assertEquals(i + 1, list.size());
    }
    Cheese c = fromager.makeCheese("new", CheeseType.getRandomCheeseType());
    list.add(0, c);
    assertEquals(c, list.get(0));
    try {
      list.add(-1, c);
      fail("-1 is invalid index.");
    } catch (IndexOutOfBoundsException ioobe) {
      // expected
    }
    try {
      list.add(list.size() + 1, c);
      fail("size + 1 is invalid index.");
    } catch (IndexOutOfBoundsException ioobe) {
      // expected
    }
  }

  @Test
  void testRemove() {
    CircularDoublyLinkedList<Cheese> list = new CircularDoublyLinkedList<Cheese>();
    for (int i = 0; i < NUM_CHEESES; i++) {
      list.add(cheeses[i]);
    }
    assertEquals(cheeses[0], list.remove(0));
    assertEquals(cheeses[1], list.get(0));
    assertEquals(cheeses[NUM_CHEESES - 1], list.get(NUM_CHEESES - 2));
    try {
      list.remove(-1);
      fail("-1 is invalid index.");
    } catch (IndexOutOfBoundsException ioobe) {
      // expected
    }
    try {
      list.remove(list.size());
      fail("size is invalid index.");
    } catch (IndexOutOfBoundsException ioobe) {
      // expected
    }
  }

}

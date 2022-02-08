package edu.ics211.h02;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Represents a CheeseCopmaratorTest.
 *
 * @author Cam Moore
 *
 */
public class CheeseComparatorTest {

  /**
   * Tests the FatComparator.
   */
  @Test
  public void testFatComparator() {
    Cheese c1 = ManoaCheeseFromager.getInstance().makeBrie("brie1", 50.0);
    Cheese c2 = ManoaCheeseFromager.getInstance().makeMozzarella("mozz1", 40.0);
    FatComparator fatC = new FatComparator();
    assertTrue("Wrong fat comparator", fatC.compare(c1, c2) > 0);
    assertTrue("Wrong fat comparator", fatC.compare(c2, c2) == 0);
    assertTrue("Wrong fat comparator", fatC.compare(c2, c1) < 0);
  }

  /**
   * Tests the TypeComparator.
   */
  @Test
  public void testTypeComparator() {
    Cheese c1 = ManoaCheeseFromager.getInstance().makeBrie("brie1", 50.0);
    Cheese c2 = ManoaCheeseFromager.getInstance().makeMozzarella("mozz1", 40.0);
    TypeComparator typeC = new TypeComparator();
    assertTrue("Wrong type comparator", typeC.compare(c1, c2) > 0);
    assertTrue("Wrong type comparator", typeC.compare(c2, c2) == 0);
    assertTrue("Wrong type comparator", typeC.compare(c2, c1) < 0);
  }

  /**
   * Tests the Cheese.compareTo method.
   */
  @Test
  public void testComparable() {
    Cheese c1 = ManoaCheeseFromager.getInstance().makeBrie("brie1", 50.0);
    Cheese c2 = ManoaCheeseFromager.getInstance().makeMozzarella("mozz1", 40.0);
    assertTrue("Wrong comparable", c1.compareTo(c2) < 0);
    assertTrue("Wrong comparable", c1.compareTo(c1) == 0);
    assertTrue("Wrong comparable", c2.compareTo(c1) > 0);
  }
}

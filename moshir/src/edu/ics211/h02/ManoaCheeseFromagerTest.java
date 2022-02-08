package edu.ics211.h02;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Represents a ManoaCheeseFromagerTest.
 *
 * @author Cam Moore
 *
 */
public class ManoaCheeseFromagerTest {

  /**
   * Test method for {@link edu.ics211.h02.ManoaCheeseFromager#getInstance()}.
   */
  @Test
  public void testGetInstance() {
    assertNotNull("Didn't get the singleton.", ManoaCheeseFromager.getInstance());
    assertTrue("Created more than one instance.",
        ManoaCheeseFromager.getInstance() == ManoaCheeseFromager.getInstance());
  }


  /**
   * Test method for {@link edu.ics211.h02.ManoaCheeseFromager#makeCheese(java.lang.String,
   *  edu.ics211.h02.CheeseType, java.lang.Double)}.
   */
  @Test
  public void testMakeCheeseStringCheeseTypeDouble() {
    Double fatPercent = 45.0;
    Cheese c = ManoaCheeseFromager.getInstance().makeCheese("test1", CheeseType.FRESH, fatPercent);
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FRESH == c.getType());
    assertEquals("Wrong fat percentage", fatPercent, c.getFatPercentage(), 0.0001);
    assertEquals("Wrong name", "test1", c.getName());
    assertTrue("Wrong cheese", c instanceof Mozzarella);
    fatPercent = 25.5;
    c = ManoaCheeseFromager.getInstance().makeCheese("test2", CheeseType.SOFT, fatPercent);
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.SOFT == c.getType());
    assertEquals("Wrong fat percentage", fatPercent, c.getFatPercentage(), 0.0001);
    assertEquals("Wrong name", "test2", c.getName());
    assertTrue("Wrong cheese", c instanceof Brie);
    fatPercent = 15.5;
    c = ManoaCheeseFromager.getInstance().makeCheese("test3", CheeseType.FIRM, fatPercent);
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FIRM == c.getType());
    assertEquals("Wrong fat percentage", fatPercent, c.getFatPercentage(), 0.0001);
    assertEquals("Wrong name", "test3", c.getName());
    assertTrue("Wrong cheese", c instanceof Parmesan || c instanceof Cheddar);
  }


  /**
   * Test method for {@link edu.ics211.h02.ManoaCheeseFromager#makeCheese(java.lang.String,
   *  edu.ics211.h02.CheeseType)}.
   */
  @Test
  public void testMakeCheeseStringCheeseType() {
    Cheese c = ManoaCheeseFromager.getInstance().makeCheese("test1", CheeseType.FRESH);
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FRESH == c.getType());
    assertEquals("Wrong name", "test1", c.getName());
    assertTrue("Wrong fat percentage", c.getFatPercentage() > 0.0 && c.getFatPercentage() < 100.0);
    assertTrue("Wrong cheese", c instanceof Mozzarella);
    c = ManoaCheeseFromager.getInstance().makeCheese("test2", CheeseType.SOFT);
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.SOFT == c.getType());
    assertEquals("Wrong name", "test2", c.getName());
    assertTrue("Wrong fat percentage", c.getFatPercentage() > 0.0 && c.getFatPercentage() < 100.0);
    assertTrue("Wrong cheese", c instanceof Brie);
    c = ManoaCheeseFromager.getInstance().makeCheese("test3", CheeseType.FIRM);
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FIRM == c.getType());
    assertTrue("Wrong fat percentage", c.getFatPercentage() > 0.0 && c.getFatPercentage() < 100.0);
    assertEquals("Wrong name", "test3", c.getName());
    assertTrue("Wrong cheese", c instanceof Parmesan || c instanceof Cheddar);
  }


  /**
   * Test method for {@link edu.ics211.h02.ManoaCheeseFromager#makeMozzarella(java.lang.String,
   *  java.lang.Double)}.
   */
  @Test
  public void testMakeMozzarellaStringDouble() {
    Double fatPercent = 45.0;
    Cheese c = ManoaCheeseFromager.getInstance().makeMozzarella("test1", fatPercent);
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FRESH == c.getType());
    assertEquals("Wrong fat percentage", fatPercent, c.getFatPercentage(), 0.0001);
    assertEquals("Wrong name", "test1", c.getName());
    assertTrue("Wrong cheese", c instanceof Mozzarella);
    fatPercent = 25.5;
    c = ManoaCheeseFromager.getInstance().makeMozzarella("test2", fatPercent);
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FRESH == c.getType());
    assertEquals("Wrong fat percentage", fatPercent, c.getFatPercentage(), 0.0001);
    assertEquals("Wrong name", "test2", c.getName());
    assertTrue("Wrong cheese", c instanceof Mozzarella);
    fatPercent = 15.5;
    c = ManoaCheeseFromager.getInstance().makeMozzarella("test3", fatPercent);
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FRESH == c.getType());
    assertEquals("Wrong fat percentage", fatPercent, c.getFatPercentage(), 0.0001);
    assertEquals("Wrong name", "test3", c.getName());
    assertTrue("Wrong cheese", c instanceof Mozzarella);
    
  }


  /**
   * Test method for {@link edu.ics211.h02.ManoaCheeseFromager#makeMozzarella(java.lang.String)}.
   */
  @Test
  public void testMakeMozzarellaString() {
    Cheese c = ManoaCheeseFromager.getInstance().makeMozzarella("test1");
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FRESH == c.getType());
    assertTrue("Wrong fat percentage", c.getFatPercentage() > 0.0 && c.getFatPercentage() < 100.0);
    assertEquals("Wrong name", "test1", c.getName());
    assertTrue("Wrong cheese", c instanceof Mozzarella);
    c = ManoaCheeseFromager.getInstance().makeMozzarella("test2");
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FRESH == c.getType());
    assertTrue("Wrong fat percentage", c.getFatPercentage() > 0.0 && c.getFatPercentage() < 100.0);
    assertEquals("Wrong name", "test2", c.getName());
    assertTrue("Wrong cheese", c instanceof Mozzarella);
    c = ManoaCheeseFromager.getInstance().makeMozzarella("test3");
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FRESH == c.getType());
    assertTrue("Wrong fat percentage", c.getFatPercentage() > 0.0 && c.getFatPercentage() < 100.0);
    assertEquals("Wrong name", "test3", c.getName());
    assertTrue("Wrong cheese", c instanceof Mozzarella);
  }


  /**
   * Test method for {@link edu.ics211.h02.ManoaCheeseFromager#makeBrie(java.lang.String,
   *  java.lang.Double)}.
   */
  @Test
  public void testMakeBrieStringDouble() {
    Double fatPercent = 45.0;
    Cheese c = ManoaCheeseFromager.getInstance().makeBrie("test1", fatPercent);
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.SOFT == c.getType());
    assertEquals("Wrong fat percentage", fatPercent, c.getFatPercentage(), 0.0001);
    assertEquals("Wrong name", "test1", c.getName());
    assertTrue("Wrong cheese", c instanceof Brie);
    fatPercent = 25.5;
    c = ManoaCheeseFromager.getInstance().makeBrie("test2", fatPercent);
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.SOFT == c.getType());
    assertEquals("Wrong fat percentage", fatPercent, c.getFatPercentage(), 0.0001);
    assertEquals("Wrong name", "test2", c.getName());
    assertTrue("Wrong cheese", c instanceof Brie);
    fatPercent = 15.5;
    c = ManoaCheeseFromager.getInstance().makeBrie("test3", fatPercent);
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.SOFT == c.getType());
    assertEquals("Wrong fat percentage", fatPercent, c.getFatPercentage(), 0.0001);
    assertEquals("Wrong name", "test3", c.getName());
    assertTrue("Wrong cheese", c instanceof Brie);
  }


  /**
   * Test method for {@link edu.ics211.h02.ManoaCheeseFromager#makeBrie(java.lang.String)}.
   */
  @Test
  public void testMakeBrieString() {
    Cheese c = ManoaCheeseFromager.getInstance().makeBrie("test1");
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.SOFT == c.getType());
    assertTrue("Wrong fat percentage", c.getFatPercentage() > 0.0 && c.getFatPercentage() < 100.0);
    assertEquals("Wrong name", "test1", c.getName());
    assertTrue("Wrong cheese", c instanceof Brie);
    c = ManoaCheeseFromager.getInstance().makeBrie("test2");
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.SOFT == c.getType());
    assertTrue("Wrong fat percentage", c.getFatPercentage() > 0.0 && c.getFatPercentage() < 100.0);
    assertEquals("Wrong name", "test2", c.getName());
    assertTrue("Wrong cheese", c instanceof Brie);
    c = ManoaCheeseFromager.getInstance().makeBrie("test3");
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.SOFT == c.getType());
    assertTrue("Wrong fat percentage", c.getFatPercentage() > 0.0 && c.getFatPercentage() < 100.0);
    assertEquals("Wrong name", "test3", c.getName());
    assertTrue("Wrong cheese", c instanceof Brie);
  }


  /**
   * Test method for {@link edu.ics211.h02.ManoaCheeseFromager#makeCheddar(java.lang.String,
   *  java.lang.Double)}.
   */
  @Test
  public void testMakeCheddarStringDouble() {
    Double fatPercent = 45.0;
    Cheese c = ManoaCheeseFromager.getInstance().makeCheddar("test1", fatPercent);
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FIRM == c.getType());
    assertEquals("Wrong fat percentage", fatPercent, c.getFatPercentage(), 0.0001);
    assertEquals("Wrong name", "test1", c.getName());
    assertTrue("Wrong cheese", c instanceof Cheddar);
    fatPercent = 25.5;
    c = ManoaCheeseFromager.getInstance().makeCheddar("test2", fatPercent);
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FIRM == c.getType());
    assertEquals("Wrong fat percentage", fatPercent, c.getFatPercentage(), 0.0001);
    assertEquals("Wrong name", "test2", c.getName());
    assertTrue("Wrong cheese", c instanceof Cheddar);
    fatPercent = 15.5;
    c = ManoaCheeseFromager.getInstance().makeCheddar("test3", fatPercent);
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FIRM == c.getType());
    assertEquals("Wrong fat percentage", fatPercent, c.getFatPercentage(), 0.0001);
    assertEquals("Wrong name", "test3", c.getName());
    assertTrue("Wrong cheese", c instanceof Cheddar);
  }


  /**
   * Test method for {@link edu.ics211.h02.ManoaCheeseFromager#makeCheddar(java.lang.String)}.
   */
  @Test
  public void testMakeCheddarString() {
    Cheese c = ManoaCheeseFromager.getInstance().makeCheddar("test1");
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FIRM == c.getType());
    assertTrue("Wrong fat percentage", c.getFatPercentage() > 0.0 && c.getFatPercentage() < 100.0);
    assertEquals("Wrong name", "test1", c.getName());
    assertTrue("Wrong cheese", c instanceof Cheddar);
    c = ManoaCheeseFromager.getInstance().makeCheddar("test2");
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FIRM == c.getType());
    assertTrue("Wrong fat percentage", c.getFatPercentage() > 0.0 && c.getFatPercentage() < 100.0);
    assertEquals("Wrong name", "test2", c.getName());
    assertTrue("Wrong cheese", c instanceof Cheddar);
    c = ManoaCheeseFromager.getInstance().makeCheddar("test3");
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FIRM == c.getType());
    assertTrue("Wrong fat percentage", c.getFatPercentage() > 0.0 && c.getFatPercentage() < 100.0);
    assertEquals("Wrong name", "test3", c.getName());
    assertTrue("Wrong cheese", c instanceof Cheddar);
  }


  /**
   * Test method for {@link edu.ics211.h02.ManoaCheeseFromager#makeParmesan(java.lang.String,
   *  java.lang.Double)}.
   */
  @Test
  public void testMakeParmesanStringDouble() {
    Double fatPercent = 45.0;
    Cheese c = ManoaCheeseFromager.getInstance().makeParmesan("test1", fatPercent);
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FIRM == c.getType());
    assertEquals("Wrong fat percentage", fatPercent, c.getFatPercentage(), 0.0001);
    assertEquals("Wrong name", "test1", c.getName());
    assertTrue("Wrong cheese", c instanceof Parmesan);
    fatPercent = 25.5;
    c = ManoaCheeseFromager.getInstance().makeParmesan("test2", fatPercent);
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FIRM == c.getType());
    assertEquals("Wrong fat percentage", fatPercent, c.getFatPercentage(), 0.0001);
    assertEquals("Wrong name", "test2", c.getName());
    assertTrue("Wrong cheese", c instanceof Parmesan);
    fatPercent = 15.5;
    c = ManoaCheeseFromager.getInstance().makeParmesan("test3", fatPercent);
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FIRM == c.getType());
    assertEquals("Wrong fat percentage", fatPercent, c.getFatPercentage(), 0.0001);
    assertEquals("Wrong name", "test3", c.getName());
    assertTrue("Wrong cheese", c instanceof Parmesan);
  }


  /**
   * Test method for {@link edu.ics211.h02.ManoaCheeseFromager#makeParmesan(java.lang.String)}.
   */
  @Test
  public void testMakeParmesanString() {
    Cheese c = ManoaCheeseFromager.getInstance().makeParmesan("test1");
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FIRM == c.getType());
    assertTrue("Wrong fat percentage", c.getFatPercentage() > 0.0 && c.getFatPercentage() < 100.0);
    assertEquals("Wrong name", "test1", c.getName());
    assertTrue("Wrong cheese", c instanceof Parmesan);
    c = ManoaCheeseFromager.getInstance().makeParmesan("test2");
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FIRM == c.getType());
    assertTrue("Wrong fat percentage", c.getFatPercentage() > 0.0 && c.getFatPercentage() < 100.0);
    assertEquals("Wrong name", "test2", c.getName());
    assertTrue("Wrong cheese", c instanceof Parmesan);
    c = ManoaCheeseFromager.getInstance().makeParmesan("test3");
    assertNotNull("Didn't get a cheese", c);
    assertTrue("Wrong type", CheeseType.FIRM == c.getType());
    assertTrue("Wrong fat percentage", c.getFatPercentage() > 0.0 && c.getFatPercentage() < 100.0);
    assertEquals("Wrong name", "test3", c.getName());
    assertTrue("Wrong cheese", c instanceof Parmesan);
  }

}
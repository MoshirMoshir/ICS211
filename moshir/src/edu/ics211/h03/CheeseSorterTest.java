package edu.ics211.h03;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import edu.ics211.h02.Cheese;
import edu.ics211.h02.CheeseType;
import edu.ics211.h02.FatComparator;
import edu.ics211.h02.ManoaCheeseFromager;
import edu.ics211.h02.TypeComparator;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;
import org.junit.Before;
import org.junit.Test;

/**
 * Represents a CheeseSorterTest.
 *
 * @author Cam Moore
 *
 */
public class CheeseSorterTest {
  private ArraySorter<Cheese> sorter;
  private ManoaCheeseFromager fromager;
  private Cheese[] shortCheeses;
  private Cheese[] mediumCheeses;
  private Cheese[] longCheeeses;
  private FatComparator fatC;
  private TypeComparator typeC;

  /**
   * Initializes the variables.
   *
   * @throws java.lang.Exception if there is a problem.
   */
  @Before
  public void setUp() throws Exception {
    // initialize the variables
    sorter = new ArraySorter<Cheese>();
    fromager = ManoaCheeseFromager.getInstance();
    fatC = new FatComparator();
    typeC = new TypeComparator();
    Random r = new Random();
    // create three arrays of cheese of different lengths
    shortCheeses = new Cheese[10];
    for (int i = 0; i < shortCheeses.length; i++) {
      shortCheeses[i] = fromager.makeCheese("Short Cheese " 
    + i, CheeseType.getRandomCheeseType(), r.nextDouble());
    }
    mediumCheeses = new Cheese[1000];
    for (int i = 0; i < mediumCheeses.length; i++) {
      mediumCheeses[i] = fromager.makeCheese("Medium Cheese " 
    + i, CheeseType.getRandomCheeseType(), r.nextDouble());
    }
    longCheeeses = new Cheese[10000]; // for fun change this to 100000
    for (int i = 0; i < longCheeeses.length; i++) {
      longCheeeses[i] = fromager.makeCheese("Long Cheese " 
    + i, CheeseType.getRandomCheeseType(), r.nextDouble());
    }
  }


  /**
   * Test method for {@link edu.ics211.h03.ArraySorter#insertionSort(java.util.Comparator, E[])}.
   */
  @Test
  public void testInsertionSort() {
    // Use a copy not the original arrays.
    Cheese[] copy = Arrays.copyOf(shortCheeses, shortCheeses.length);
    // sort the short array using FatComparator
    sorter.insertionSort(fatC, copy);
    // get the sort time for comparison later.
    final double shortTime = sorter.getSortTime();
    // check if it is sorted
    assertTrue("Insertion sort: Didn't sort the array", isSorted(copy, fatC));
    // sort the sorted array
    sorter.insertionSort(fatC, copy);
    // check the number of comparisons
    assertEquals("Insertion sort: Wrong number of comparisons",
        shortCheeses.length - 1, sorter.getNumberOfComparisons());
    // check the number of swaps
    assertEquals("Insertion sort: Wrong number of swaps", 0, sorter.getNumberOfSwaps());
    // sort the array using TypeComparator
    sorter.insertionSort(typeC, copy);
    // check that array is sorted
    assertTrue("Insertion sort: Didn't sort the array", isSorted(copy, typeC));
    // copy the medium array
    copy = Arrays.copyOf(mediumCheeses, mediumCheeses.length);
    // sort the array
    sorter.insertionSort(fatC, copy);
    final double mediumTime = sorter.getSortTime();
    assertTrue("Insertion sort: short time should be < medium time", shortTime < mediumTime);
    // copy the long array
    copy = Arrays.copyOf(longCheeeses, longCheeeses.length);
    // sort the array
    sorter.insertionSort(fatC, copy);
    final double longTime = sorter.getSortTime();
    assertTrue("Insertion sort: medium time should be < long time", mediumTime < longTime);
  }


  /**
   * Test method for {@link edu.ics211.h03.ArraySorter#bubbleSort(java.util.Comparator, E[])}.
   */
  @Test
  public void testBubbleSort() {
    // Use a copy not the original arrays.
    Cheese[] copy = Arrays.copyOf(shortCheeses, shortCheeses.length);
    // sort the short array using FatComparator
    sorter.bubbleSort(fatC, copy);
    // get the sort time for comparison later.
    final double shortTime = sorter.getSortTime();
    // check if it is sorted
    assertTrue("Bubble sort: Didn't sort the array", isSorted(copy, fatC));
    // sort the sorted array
    sorter.bubbleSort(fatC, copy);
    // check the number of comparisons
    assertEquals("Bubble sort: Wrong number of comparisons",
        shortCheeses.length - 1, sorter.getNumberOfComparisons());
    // check the number of swaps
    assertEquals("Bubble sort: Wrong number of swaps", 0, sorter.getNumberOfSwaps());
    // sort the array using TypeComparator
    sorter.bubbleSort(typeC, copy);
    // check that array is sorted
    assertTrue("Bubble sort: Didn't sort the array", isSorted(copy, typeC));
    // copy the medium array
    copy = Arrays.copyOf(mediumCheeses, mediumCheeses.length);
    // sort the array
    sorter.bubbleSort(fatC, copy);
    final double mediumTime = sorter.getSortTime();
    assertTrue("Bubble sort: short time should be < medium time", shortTime < mediumTime);
    // copy the long array
    copy = Arrays.copyOf(longCheeeses, longCheeeses.length);
    // sort the array
    sorter.bubbleSort(fatC, copy);
    final double longTime = sorter.getSortTime();
    assertTrue("Bubble sort: medium time should be < long time", mediumTime < longTime);
  }


  /**
   * Test method for {@link edu.ics211.h03.ArraySorter#selectionSort(java.util.Comparator, E[])}.
   */
  @Test
  public void testSelectionSort() {
    // Use a copy not the original arrays.
    Cheese[] copy = Arrays.copyOf(shortCheeses, shortCheeses.length);
    // sort the short array using FatComparator
    sorter.selectionSort(fatC, copy);
    // get the sort time for comparison later.
    final double shortTime = sorter.getSortTime();
    // check if it is sorted
    assertTrue("Selection sort: Didn't sort the array", isSorted(copy, fatC));
    // sort the sorted array
    sorter.selectionSort(fatC, copy);
    // check the number of comparisons
    assertEquals("Selection sort: Wrong number of comparisons",
        factorial(shortCheeses.length - 1), sorter.getNumberOfComparisons());
    // check the number of swaps
    assertEquals("Selection sort: Wrong number of swaps", 0, sorter.getNumberOfSwaps());
    // sort the array using TypeComparator
    sorter.selectionSort(typeC, copy);
    // check that array is sorted
    assertTrue("Selection sort: Didn't sort the array", isSorted(copy, typeC));
    // copy the medium array
    copy = Arrays.copyOf(mediumCheeses, mediumCheeses.length);
    // sort the array
    sorter.selectionSort(fatC, copy);
    final double mediumTime = sorter.getSortTime();
    assertTrue("Selection sort: short time should be < medium time", shortTime < mediumTime);
    // copy the long array
    copy = Arrays.copyOf(longCheeeses, longCheeeses.length);
    // sort the array
    sorter.selectionSort(fatC, copy);
    final double longTime = sorter.getSortTime();
    assertTrue("Selection sort: medium time should be < long time", mediumTime < longTime);
  }

  /**
   * Calculates the factorial of num.
   * @param num the integer.
   * @return the factorial of num.
   */
  private int factorial(int num) {
    if (num < 2) {
      return 1;
    }
    return num + factorial(num - 1);
  }

  /**
   * Tests to see that data is sorted based upon the comparator.
   * @param data an array of Cheese.
   * @param comp a Comparator of Cheese.
   * @return true if data is sorted, false otherwise.
   */
  private boolean isSorted(Cheese[] data, Comparator<Cheese> comp) {
    for (int i = 0; i < data.length - 1; i++) {
      if (comp.compare(data[i], data[i + 1]) > 0) {
        return false;
      }
    }
    return true;
  }
}

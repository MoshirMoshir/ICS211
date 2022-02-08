package edu.ics211.h03;

import java.util.Comparator;

/**
 * Sorts Arrays.
 * 
 * @author Alexander Moshir
 * @param <E>
 *
 */
public class ArraySorter<E> implements SortsArray<E> {
  
  private int numSwaps;
  private int numComps;
  private double sortTime;
  
  /** 
   * Creates a new ArraySorter.
   */
  public ArraySorter() {
    // initialize the member variables.
    numSwaps = 0;
    numComps = 0;
    sortTime = 0.0;
  }

  /**
   * Sorts E[] data by insertion Sorting.
   * @param compare compare E
   * @param data array of E
   */
  @Override
  public void insertionSort(Comparator<E> compare, E[] data) {
    // get the start time using System.nanoTime
    final double startTime = System.nanoTime();
    // set numSwaps and numComps to 0
    numSwaps = 0;
    numComps = 0;
    // for loop 1 to data.length
    for (int nextPos = 1; nextPos < data.length; nextPos++) {
      E nextVal = data[nextPos];
      // while nextPos > 0 && compare.compare(nextVal, data[nextPos - 1]) < 0
      while (nextPos > 0 && compare.compare(nextVal, data[nextPos - 1]) < 0) {
        // count the compare
        numComps++;
        // table[nextPos] = table[nextPos - 1]; // Shift down. count the swap
        if (compare.compare(nextVal,  data[nextPos - 1]) < 0) {
          data[nextPos] = data[nextPos - 1];
          numSwaps++;
        }
        // nextPos--; // Check next smaller element.
        nextPos--;
      }
      // if (nextPos > 0) count the compare
      if (nextPos > 0) {
        numComps++;
      }
      // if nextPos != where we started
      if (nextPos != data.length) {
        // Insert nextVal at nextPos.
        // table[nextPos] = nextVal; // count the swap
        data[nextPos] = nextVal;
        //numSwaps++;
      }
    }
    // get the end time
    // set sortTime to end - start
    double endTime = System.nanoTime();
    sortTime = endTime - startTime;
  }

  /**
   * Sorts E[] data by bubble Sorting.
   * @param compare compare E
   * @param data array of E
   */
  @Override
  public void bubbleSort(Comparator<E> compare, E[] data) {
    // get the start time using System.nanoTime
    final double startTime = System.nanoTime();
    // set numSwaps and numComps to 0
    numSwaps = 0;
    numComps = 0;
    // boolean didSwap
    // do {
    //   didSwap is false
    //     for (int j = 0; j < data.length - 1; j++) {
    //        count the compare
    //        if (c.compare(data[j], data[j + 1]) > 0 {
    //          swap(data[j], data[j + 1]);
    //          count swap set didSwap true
    //      }
    //    }
    // } while (didSwap);
    boolean didSwap;
    do {
      didSwap = false;
      for (int j = 0; j < data.length - 1; j++) {
        numComps++;
        if (compare.compare(data[j], data[j + 1]) > 0) {
          data[j] = data[j + 1];
          numSwaps++;
          didSwap = true;
        }
      }
    } while (didSwap);
    // get the end time
    // set sortTime to end - start
    double endTime = System.nanoTime();
    sortTime = endTime - startTime;
  }

  /**
   * Sorts E[] data by selection Sorting.
   * @param compare compare E
   * @param data array of E
   */
  @Override
  public void selectionSort(Comparator<E> compare, E[] data) {
    // get the start time using System.nanoTime
    final double startTime = System.nanoTime();
    // set numSwaps and numComps to 0
    numSwaps = 0;
    numComps = 0;
    // begin loop
    for (int j = 0; j < data.length - 1; j++) {
      int posMin = j;
      // set second loop for compare
      for (int next = j + 1; next < data.length; next++) {
        //count compare
        numComps++;
        // if compare(data[next], data[posMin] < 0, swap and count swap
        if (compare.compare(data[next], data[posMin]) < 0) {
          posMin = next;
          numSwaps++;
        }
      }
      //switch E value places
      E temp = data[j];
      data[j] = data[posMin];
      data[posMin] = temp;
      
    }
    // get the end time
    // set sortTime to end - start
    double endTime = System.nanoTime();
    sortTime = endTime - startTime;
  }

  /**
   * Returns the number of Swaps done in sort.
   * @return numSwaps number of swaps
   */
  @Override
  public int getNumberOfSwaps() {
    return numSwaps;
  }

  /**
   * Returns the number of compares done in sort.
   * @return numComps number of compares
   */
  @Override
  public int getNumberOfComparisons() {
    return numComps;
  }

  /**
   * Returns the time elapse during the sorting.
   * @return sortTime Time it took to sort
   */
  @Override
  public double getSortTime() {
    return sortTime;
  }

}

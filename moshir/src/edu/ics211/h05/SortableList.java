package edu.ics211.h05;

import edu.ics211.h04.ISortableList;
import edu.ics211.h04.IList211;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Represents a SortableList.
 * @author Alexander Moshir
 * @param <E> the generic type.
 */
public class SortableList<E> implements ISortableList<E>, IList211<E> {
  // Declare.
  private DLinkedNode tail;
  private int size;
  private int numSwaps;
  private int numComps;
  private double sortTime;
  
  /**
   * Represents a DLinkedNode.
   * @author Alexander Moshir
   *
   */
  private class DLinkedNode {
	  E item;
	  DLinkedNode next;
	  DLinkedNode prev;
	  
	  public DLinkedNode(E item, DLinkedNode next, DLinkedNode prev) {
	    this.item = item;
	    this.next = next;
	    this.prev = prev;
	  }
	}
  
  /**
   * Creates a new SortableList.
   *
   */
  @SuppressWarnings("unchecked")
  public SortableList() {
    // initialize the member variables.
    tail.item = null;
    tail.next = null;
    tail.prev = null;
  }
  
  
  @Override
  public void insertionSort(Comparator<E> compare) {
    // get the start time using System.nanoTime
    long startSortTime = System.nanoTime();
    // set numSwaps and numComps to 0
    numSwaps = 0;
    numComps = 0;
    // for loop 1 to data.length
    for (int nextPos = 1; nextPos < size; nextPos++) {
      E nextVal = data[nextPos];
      while (nextPos > 0 && compare.compare(nextVal, data[nextPos - 1]) < 0) {
        // count the compare
        numComps++;
        // data[nextPos] = table[nextPos - 1]; // Shift down. count the swap
        data[nextPos] = data[nextPos - 1];
        data[nextPos - 1] = nextVal;
        // nextPos-; // Check next smaller element.
        nextPos--;
      }
      // if (nextPos > 0) count the compare
      if (nextPos > 0) {
        numComps++;
      }
      // get the end time
      long endSortTime = System.nanoTime();
      // set sortTime to end - start
      sortTime = endSortTime - startSortTime;
    }
  }


  @Override
  public void bubbleSort(Comparator<E> compare) {
    // get the start time using System.nanoTime
    final long startSortTime = System.nanoTime();
    // set numSwaps and numComps to 0
    numSwaps = 0;
    numComps = 0;
    // boolean didSwap
    boolean didSwap;
    do {
      // didSwap is false
      didSwap = false;
      for (int j = 0; j < data.length - 1; j++) {
        // count the compare
        numComps++;
        if (compare.compare(data[j], data[j + 1]) > 0) {
          // swap(data[j], data[j + 1])
          E temp = data[j];
          data [j] = (data[j + 1]);
          data [j + 1] = temp;
          // count swap
          numSwaps++;
          // set didSwap true
          didSwap = true;
        }
      }
    } while (didSwap);
    // get the end time
    final long endSortTime = System.nanoTime();
    // set sortTime to end - start
    sortTime = endSortTime - startSortTime;
  }


  @Override
  public void selectionSort(Comparator<E> compare) {
    // get the start time using System.nanoTime
    final long startSortTime = System.nanoTime();
    // set numSwaps and numComps to 0
    numSwaps = 0;
    numComps = 0;
    for (int fill = 0; fill < size - 1; fill++) {
      // declare posMin
      int posMin = fill;
      for (int nextPos = fill + 1; nextPos < size; nextPos++) {
        // count the compare
        numComps++;
        if (compare.compare(data[nextPos], data[posMin]) < 0) {
          posMin = nextPos;
          // count the swaps
          numSwaps++;
        }
      }
      // swap ([fill], [posMin])
      E temp = (E) data[fill];
      data[fill] = data[posMin];
      data[posMin] = temp;
    }
    // get the end time
    final long endSortTime = System.nanoTime();
    // set sortTime to end - start`
    sortTime = endSortTime - startSortTime;
  }
  
  
  // Code from screen cast.
  @Override
  public E get(int index) {
    // check index if valid
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index);
    }
    // return item at index
    return (E) data[index];
  }

  
  // Code from screen cast.
  @Override
  public E set(int index, E element) {
    // check the index
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index);
    }
    // remember the old value
    E old = (E) data[index];
    // set the value at index to element
    data[index] = element;
    // return the old value
    return old;
  }


  @Override
  public int indexOf(Object obj) {
    // loop over the items
    for (int i = 0; i < data.length; i++) {
      // if data[i].equals(o)
      if (data[i] != null && data[i].equals(obj)) { 
        // return i
        return i; 
      }
    }
    
    // return -1
    return -1;
  }


  @Override
  public int size() {
    // return size
    return size;
  }

  
  @Override
  public boolean add(E e) {
    // add(size, e)
    add(size, e);
    return true;
  }


  @Override
  public void add(int index, E element) {
    // check index
    if (index < 0 || index > size) { // > size
      throw new IndexOutOfBoundsException(index);
    }
    // check if data is full
    if (size == data.length) {
      // reallocate
      data = Arrays.copyOf(data, data.length * 2);
    }
    // shift the items from size - 1 to index to the right/+1
    for (int i = size; i > index; i--) {
      data[i] = data[i - 1];
    }
    // insert element at index
    data[index] = element;
    // increment size
    size++;
  }

  
  // Code from screen cast.
  @Override
  public E remove(int index) {
    // check the index
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException(index);
    }
    // remember the removed value at index
    E returnValue = (E) data[index];
    // shift the items from index to size - 1 to the left /-1
    for (int i = index + 1; i < size; i++) {
      data[i - 1] = data[i];
    }
    // decrement the size
    size--;
    // return the removed value
    return returnValue;
   }
  
  @SuppressWarnings("unused")
  private void checkIndex(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
  }


  @Override
  public int getNumberOfSwaps() {
    // return numSwaps
    return numSwaps;
  }


  @Override
  public int getNumberOfComparisons() {
    // return numComps
    return numComps;
  }


  @Override
  public double getSortTime() {
    // return sortTime
    return sortTime;
  }

}

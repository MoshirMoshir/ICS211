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
      
    /**
     * Creates a DlinkedNode.
     * @param item item to be in list
     * @param next the next dlinkednode
     * @param prev the previous dlinkednode
     */
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
  
  private DLinkedNode traverse(int index) {
    //create temp node to traverse
    DLinkedNode temp = tail;
	for (int i = size - 1; i > index; i--) {
		  temp = temp.prev;
		  
	  }
  }
  
  // Code from screen cast.
  @Override
  public E get(int index) {
    // check index
	checkIndex(index);
	// traverse the nodes starting with tail to index
	DlinkedNode temp = traverse(index);
	return null;
  }

  
  // Code from screen cast.
  @Override
  public E set(int index, E element) {
    // check the index
    // traverse to index
    // remember the old value
	 set temp.item = element
// return old value
			 return null;
  }


  @Override
  public int indexOf(Object obj) {
   DLinkedNode temp = tail;
   // loop from size - 1 to 0
   // if temp.item.equals(obj)
   // return loop counter

    
    // return -1
    return -1;
  }


  @Override
  public int size() {
    // return size
    return this.size;
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
    checkIndex(index);
    // create a new DLinkedNode with element
    DLinkedNode node = new DLinkedNode(element, null, null);
    if (size == 0) {
    	tail = node;
    }
    // if index == size {
    if (index == size) {
        //	point node to list
        node.prev = tail;
        // point list to node
        tail.next = node;
        // update tail
        tail = node;
    } else {
    	// traverse to index
    	DLinkedNode temp = traverse(index);
        // point node to list
        node.prev = temp.prev;
        node.next = temp;
        // point the list to the node
        temp.prev = node;
    }
    if(node.prev != null) {
    	node.prev = node;
    }
    // increment size
    size++;
  }

  
  // Code from screen cast.
  @Override
  public E remove(int index) {
    // check the index
    checkIndex(index);
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

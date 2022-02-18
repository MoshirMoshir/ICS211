
package edu.ics211.h06;

import edu.ics211.h04.IList211;
import java.util.Iterator;

/**
 * Represents a CircularDoublyLinkedList.
 * @author Alexander Moshir
 * @param <E> placeholder type
 */
public class CircularDoublyLinkedList<E> implements IList211<E>, Iterable<E> {

  // Declare.
  private DLinkedNode tail;
  private int size;
  private int numSwaps;
  private int numComps;
  private double sortTime;

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
   * Represents a ListIterator.
   * @author Alexander Moshir
   * @param <E> placeholder type
   */
  public interface ListIterator<E> {
    /**
     * Inserts the specified element to the list. (Optional for this assignment)
     * @param e thing to be added
     */
    void add(E e);
    
    /**
     * Returns true if this list iterator has more elements 
     *  while traversing in the forward direction.
     * @return boolean
     */
    boolean hasNext(); 
    
    /**
     *  Returns true if this list iterator has more elements
     *   while traversing in the reverse direction.
     * @return boolean
     */
    boolean hasPrevious();
    
    /**
     * Returns the next Element.
     * @return E
     */
    E next();
    
    /**
     * Returns the index of the next element.
     * @return int
     */
    int nextIndex();
    
    /**
     * Returns the previous Element.
     * @return E
     */
    E previous();
    
    /**
     * Returns the index of the previous element.
     * @return int
     */
    int previousIndex();
    
    /**
     * Removes from the list the last element that was returned.
     */
    void remove();
    
    /**
     * Replaces the last element returned. (Optional for this assignment)
     * @param e thing to be set
     */
    void set(E e);
    
    
  }

  /**
   * Constructor.
   */
  public CircularDoublyLinkedList() {

  }
  
  /**
   * Constructor with array input.
   * @param items array of items
   */
  public CircularDoublyLinkedList(E[] items) {
    this();
    for (E item: items) {
      add(item);
    }
  }
  
  @Override
  public Iterator<E> iterator() {
    // TODO Auto-generated method stub
    return null;
  }

  private DLinkedNode traverse(int index) {
    //create temp node to traverse
    DLinkedNode temp = tail;
    for (int i = size - 1; i > index; i--) {
      temp = temp.prev;
    }
    return temp;
  }
  
  @Override
  public E get(int index) {
    // check index
    checkIndex(index);
    if (index == size) {
      throw new IndexOutOfBoundsException();
    }
    // traverse the nodes starting with tail to index
    DLinkedNode temp = traverse(index);
    return temp.item;
  }

  @Override
  public E set(int index, E element) {
    // check the index
    checkIndex(index);
    if (index == size) {
      throw new IndexOutOfBoundsException();
    }
    // traverse to index
    DLinkedNode temp = traverse(index);
    E old = temp.item;
    // remember the old value
    temp.item = element;
    // return old value
    return old;
  }

  @Override
  public int indexOf(Object obj) {
    DLinkedNode temp = tail;
    // loop from size - 1 to 0
    for (int i = size - 1; i >= 0; i--) {
      // if temp.item.equals(obj)
      if (temp.item.equals(obj)) {
        // return loop counter
        return i;
      }
      temp = temp.prev;
    }
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
      // point node to list
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
    if (node.prev != null) {
      node.prev.next = node;
    }
    // increment size
    size++;
  }

  @Override
  public E remove(int index) {
    // checkIndex
    checkIndex(index);
    // create a new DLinkedNode with element
    DLinkedNode temp = traverse(index);
    if (temp == null) {
      throw new IndexOutOfBoundsException();
    }
    temp.prev.next = temp.next;
    temp.next.prev = temp.prev;
    size--;
    return temp.item;
  }
  
  private void checkIndex(int index) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
  }

}

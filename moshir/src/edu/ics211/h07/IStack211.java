package edu.ics211.h07;

/**
 * Represents a IStack211.
 *
 * @author Cam Moore
 * @param <E> the type.
 */
public interface IStack211<E> {
  /**
   * Returns true if the stack is empty, false otherwise.
   * 
   * @return true if the stack is empty, false otherwise.
   */
  boolean empty();


  /**
   * Pushes the item onto the stack.
   * 
   * @param item the item.
   * @return the item.
   */
  E push(E item);


  /**
   * Returns the top of the stack without removing it.
   * 
   * @return the top of the stack without removing it.
   * @throws EmptyStackException if the stack is empty.
   */
  E peek();


  /**
   * Removes the top of the stack.
   * 
   * @return the top of the stack.
   * @throws EmptyStackException if the stack is empty.
   */
  E pop();
}

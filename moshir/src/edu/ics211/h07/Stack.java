package edu.ics211.h07;

import java.util.Arrays;
import java.util.EmptyStackException;

/**
 * Represents a Stack.
 * @author Alexander Moshir
 * @param <E> Type E
 */
public class Stack<E> implements IStack211<E> {
  
  // Holds the elements of the stack
  private E[] data;
  // Keeps track of the top of the stack
  private int top;

  /**
   * Initializes the Stack.
   */
  public Stack() {
    data = (E[]) new Object[10];
    top = 0;
  }

  /**
   * tests to see if empty.
   * @return true if it is empty.
   */
  @Override
  public boolean empty() {
    return top == 0;
  }

  /**
   * Pushes the item to the top of the stack.
   * @param item the item to be put on top of the stack
   * @return the item
   */
  @Override
  public E push(E item) {
    if (top == data.length) {
      data = Arrays.copyOf(data, data.length * 2);
    }
    data[top++] = item;
    return item;
  }

  /**
   * Looks at the top of the stack.
   * @return the top item of the stack
   * @throw EmptyStackException if the stack is empty
   */
  @Override
  public E peek() {
    if (top == 0) { 
      throw new EmptyStackException(); 
    }
    
    return data[top - 1];
  }

  /**
   * Removes the top of the stack.
   * @return the top item in the stack and removes it
   * @throw EmptyStackException if the stack is empty
   */
  @Override
  public E pop() {
    System.out.println(top);
    if (top == 0) { 
      throw new EmptyStackException(); 
    }
    return data[--top];
  }

}

package edu.ics211.h08;

import java.util.AbstractQueue;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

/**
 * PacketQueue queue of packets.
 * @author Alexander Moshir
 *
 */
public class PacketQueue extends AbstractQueue<Packet> implements Queue<Packet> {
    
  private int size;
  private Packet[] list;

  /**
   * PacketQueue initializes variables.
   */
  public PacketQueue() {
    size = 0;
    list = new Packet[10]; 
  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public Iterator<Packet> iterator() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean add(Packet e) {
    if (size == 0) {
      list[0] = e;
      size = 1;
    } else {
      list[size] = e;
      size++;
    }
    return true;
  }

  @Override
  public boolean offer(Packet e) {
    try {
      return add(e);
    } catch (ArrayIndexOutOfBoundsException ise) {
      return false;
    }
  }

  @Override
  public Packet element() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    return list[0];
  }

  @Override
  public Packet peek() {
    try {
      return element();
    } catch (NoSuchElementException nse) {
      return null;
    }
  }
  
  @Override
  public Packet remove() {
    if (size == 0) {
      throw new NoSuchElementException();
    }
    
    Packet tmp = list[0];
    
    for (int i = 0; i < size - 1; i++) {
      list[i] = list[i + 1];
    }
    size--;
    return tmp;
  }

  @Override
  public Packet poll() {
    try {
      return remove();
    } catch (NoSuchElementException nse) {
      return null;
    }
  }

}

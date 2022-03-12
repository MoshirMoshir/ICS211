package edu.ics211.h08;

/**
 * A simple Packet.
 *
 * @author esb@hawaii.edu
 *
 */
public class Packet {
  private int address;

  /**
   * Creates a new Packet.
   *
   * @param destination the destination.
   */
  public Packet(int destination) {
    address = destination; // address never changes after this assignment
  }


  /**
   * Returns the address of the destination.
   *
   * @return the address of the destination.
   */
  public int getAddress() {
    return address;
  }

  @Override
  public String toString() {
    return "packet with destination " + address;
  }

}

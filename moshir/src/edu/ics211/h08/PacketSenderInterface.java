package edu.ics211.h08;

/**
 * PacketSender Interface.
 * @author esb@hawaii.edu
 *
 */
public interface PacketSenderInterface {
  /**
   * queue number is 0..7.
   * @param queue int
   * @param p Packet
   */
  void send(int queue, Packet p);
}

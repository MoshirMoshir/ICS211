package edu.ics211.h08;

/**
 * The RouterInterface.
 * 
 * @author esb@hawaii.edu
 *
 */
public interface RouterInterface {
  // constructor (constructors cannot be part of the interface)
  // sender.send is called whenever a packet is sent from a queue
  // public Router(PacketSenderInterface sender);

  /**
   * Advances the time by one time interval, removing packets from each of the 
   * queues that are not empty and sending each by calling sender.send.
   */
  void advanceTime();


  /**
   * Returns true if the packet was queued, and false if it was dropped.
   * 
   * @param p the packet.
   * @return true if the packet was queued, and false if it was dropped.
   */
  boolean acceptPacket(Packet p);


  /**
   * Returns a list of the packets that have been dropped since the last call to this method, 
   * and clear the internal list of dropped packets.
   * 
   * @return a list of the packets that have been dropped since the last call to this method, 
   *         and clear the internal list of dropped packets.
   */
  java.util.List<Packet> getDroppedPackets();

}

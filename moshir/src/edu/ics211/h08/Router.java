package edu.ics211.h08;

import java.util.ArrayList;
import java.util.List;

/**
 * Router represents a router.
 * @author Alexander Moshir
 *
 */
public class Router implements RouterInterface {

  private PacketQueue queue;
  private List<Packet> dropped;
  PacketSenderInterface sender;
  
  /**
   * Router initializes variables.
   * @param s IDs sender
   */
  public Router(PacketSenderInterface s) {
    sender = s;
    queue = new PacketQueue();
    dropped = new ArrayList<Packet>();
    

  }

  @Override
  public void advanceTime() {
    Packet p = queue.poll();
    sender.send(p.getAddress(), p);
  }

  @Override
  public boolean acceptPacket(Packet p) {
    if (queue.offer(p)) {
      return true;
    } else {
      dropped.add(p);
      return false;
    }

  }

  @Override
  public List<Packet> getDroppedPackets() {
    List<Packet> temp = dropped;
    dropped.clear();
    return temp;
  }

}

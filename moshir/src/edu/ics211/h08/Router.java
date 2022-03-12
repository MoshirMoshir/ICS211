package edu.ics211.h08;

import java.util.List;

/**
 * Router represents a router.
 * @author Alexander Moshir
 *
 */
public class Router implements RouterInterface {

  /**
   * Initilizes Router.
   */
  public Router() {
    // TODO Auto-generated constructor stub
  }

  @Override
  public void advanceTime() {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean acceptPacket(Packet p) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public List<Packet> getDroppedPackets() {
    // TODO Auto-generated method stub
    return null;
  }

}

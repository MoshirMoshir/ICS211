package edu.ics211.h08;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * JUnit tests for the Router class.
 *
 * @author esb@hawaii.edu
 *
 */
class RouterTest {

  private Router router;
  private List<Packet> sent;
  private List<Packet> packets;

  private class Sender implements PacketSenderInterface {
    public void send(int queue, Packet p) {
      sent.add(p);
      // System.out.println ("sending packet " + p + " on queue " + queue);
    }
  }

  /**
  * Exception.
  * @throws java.lang.Exception if catches
  */
  @BeforeEach
  void setUp() throws Exception {
    router = new Router(new Sender());
    sent = new java.util.LinkedList<Packet>();
    packets = new java.util.LinkedList<Packet>();
  }

  @Test
  void test() {
    assertNotNull(router);
    assertNotNull(sent);
    // test each of the queues
    for (int q = 0; q < 7; q++) {
      // send 7 packets, all to queue q
      Packet p = new Packet(q);
      packets.add(p);
      assertNotNull(p);
      for (int i = 0; i < 7; i++) {
        assertTrue(router.acceptPacket(p));
      }
      sent.clear();          // see which packets we send
      router.advanceTime();  // send the first packet in all the queues that have packets
      // every queue 0..q-1 should have packets to send, except once we get to queue 6,
      // the first queue should have already sent all its 10 packets (because
      // for each value of q, we call router.advanceTime() twice)
      final int expectedSend = (q <= 5) ? q + 1 : q;
      assertEquals(sent.size(), expectedSend);
      if (q <= 5) {  // there should be a packet from each queue
        for (Packet checkP: packets) {
          assertTrue(sent.contains(checkP));
        }
      } else {       // at least check that the latest packet was sent
        assertTrue(sent.contains(p));
      }
      sent.clear();
      // should be 6 packets in queue q.  Send 4 more
      for (int i = 0; i < 4; i++) {
        assertTrue(router.acceptPacket(p));
      }
      // now queue q should be full.  See if the packet is dropped
      assertFalse(router.acceptPacket(p));
      router.advanceTime();  // send the first packet in every queue that has packets
      assertEquals(sent.size(), expectedSend);
      if (q <= 5) {  // there should be a packet from each queue
        for (Packet checkP: packets) {
          assertTrue(sent.contains(checkP));
        }
      } else {       // at least check that the lastest packet was sent
        assertTrue(sent.contains(p));
      }
      sent.clear();
      // should be able to add one more to queue q, then the next should be dropped
      assertTrue(router.acceptPacket(p));
      assertFalse(router.acceptPacket(p));
      // we end this loop with 10 packets on queue q, 9 on queue i - 1, etc
    }
  }

}

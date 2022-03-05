package edu.ics211.h07;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * Represents a GameOfWarTest.
 *
 * @author Cam Moore
 *
 */
class GameOfWarTest {
  private GameOfWar game;
  
  /**
   * @throws java.lang.Exception
   */
  @BeforeEach
  void setUp() throws Exception {
    game = new GameOfWar();
  }


  /**
   * Test method for {@link edu.ics211.h07.GameOfWar#GameOfWar()}.
   */
  @Test
  void testGameOfWar() {
    assertNotNull(game);
    assertNotNull(game.playerOnesCards());
    assertNotNull(game.playerTwosCards());
  }


  /**
   * Test method for {@link edu.ics211.h07.GameOfWar#initializeGame(edu.ics211.h07.Deck)}.
   */
  @Test
  void testInitializeGame() {
    Card[] cards = new Card[2];
    cards[0] = new Card(Suit.getRandomSuit(), Rank.EIGHT);
    cards[1] = new Card(Suit.getRandomSuit(), Rank.TEN);
    Deck d = new Deck(cards);
    game.initializeGame(d);
    Stack<Card> p1 = game.playerOnesCards();
    assertNotNull(p1);
    assertFalse(p1.empty());
    assertEquals(cards[0], p1.pop());
    assertTrue(p1.empty());
    Stack<Card> p2 = game.playerTwosCards();
    assertNotNull(p2);
    assertFalse(p2.empty());
    assertEquals(cards[1], p2.pop());
    assertTrue(p2.empty());
  }


  /**
   * Test method for {@link edu.ics211.h07.GameOfWar#playARound()}.
   */
  @Test
  void testPlayARound() {
    // simple one round game
    Card[] cards = new Card[2];
    cards[0] = new Card(Suit.getRandomSuit(), Rank.EIGHT);
    cards[1] = new Card(Suit.getRandomSuit(), Rank.TEN);
    Deck d = new Deck(cards);
    game.initializeGame(d);
    assertTrue(game.playARound());
    Stack<Card> p1 = game.playerOnesCards();
    assertTrue(p1.empty());
    Stack<Card> p2 = game.playerTwosCards();
    assertFalse(p2.empty());
    // simple two round game
    cards = new Card[4];
    cards[0] = new Card(Suit.getRandomSuit(), Rank.EIGHT);
    cards[1] = new Card(Suit.getRandomSuit(), Rank.TEN);
    cards[2] = new Card(Suit.getRandomSuit(), Rank.THREE);
    cards[3] = new Card(Suit.getRandomSuit(), Rank.JACK);
    d = new Deck(cards);
    game.initializeGame(d);
    assertFalse(game.playARound());
    assertTrue(game.playARound());
    p1 = game.playerOnesCards();
    p2 = game.playerTwosCards();
    assertTrue(p1.empty());
    assertFalse(p2.empty());
    // one round tie then a winner
    cards = new Card[6];
    cards[5] = new Card(Suit.CLUBS, Rank.FIVE);
    cards[4] = new Card(Suit.DIAMONDS, Rank.FIVE);
    cards[3] = new Card(Suit.getRandomSuit(), Rank.getRandomRank());
    cards[2] = new Card(Suit.getRandomSuit(), Rank.getRandomRank());
    cards[1] = new Card(Suit.HEARTS, Rank.ACE);
    cards[0] = new Card(Suit.SPADES, Rank.KING);
    d = new Deck(cards);
    game.initializeGame(d);
    assertTrue(game.playARound());
    p1 = game.playerOnesCards();
    p2 = game.playerTwosCards();
    assertTrue(p1.empty());
    assertFalse(p2.empty());
    // two round tie then winner
    cards = new Card[10];
    cards[9] = new Card(Suit.getRandomSuit(), Rank.SEVEN);
    cards[8] = new Card(Suit.getRandomSuit(), Rank.SEVEN);
    cards[7] = new Card(Suit.getRandomSuit(), Rank.getRandomRank());
    cards[6] = new Card(Suit.getRandomSuit(), Rank.getRandomRank());
    cards[5] = new Card(Suit.CLUBS, Rank.FIVE);
    cards[4] = new Card(Suit.DIAMONDS, Rank.FIVE);
    cards[3] = new Card(Suit.getRandomSuit(), Rank.getRandomRank());
    cards[2] = new Card(Suit.getRandomSuit(), Rank.getRandomRank());
    cards[1] = new Card(Suit.HEARTS, Rank.ACE);
    cards[0] = new Card(Suit.SPADES, Rank.KING);
    d = new Deck(cards);
    game.initializeGame(d);
    assertTrue(game.playARound());
    p1 = game.playerOnesCards();
    p2 = game.playerTwosCards();
    assertTrue(p1.empty());
    assertFalse(p2.empty());
  }


  /**
   * Test method for {@link edu.ics211.h07.GameOfWar#playerOnesCards()}.
   */
  @Test
  void testPlayerOnesCards() {
    Card[] cards = new Card[2];
    cards[0] = new Card(Suit.getRandomSuit(), Rank.EIGHT);
    cards[1] = new Card(Suit.getRandomSuit(), Rank.TEN);
    Deck d = new Deck(cards);
    game.initializeGame(d);
    Stack<Card> p1 = game.playerOnesCards();
    assertNotNull(p1);
    assertFalse(p1.empty());
    assertEquals(cards[0], p1.pop());
    assertTrue(p1.empty());
  }


  /**
   * Test method for {@link edu.ics211.h07.GameOfWar#playerTwosCards()}.
   */
  @Test
  void testPlayerTwosCards() {
    Card[] cards = new Card[2];
    cards[0] = new Card(Suit.getRandomSuit(), Rank.EIGHT);
    cards[1] = new Card(Suit.getRandomSuit(), Rank.TEN);
    Deck d = new Deck(cards);
    game.initializeGame(d);
    Stack<Card> p2 = game.playerTwosCards();
    assertNotNull(p2);
    assertFalse(p2.empty());
    assertEquals(cards[1], p2.pop());
    assertTrue(p2.empty());
  }
  
  @Test
  void testCombineStacks() {
    Card[] cards = new Card[6];
    cards[5] = new Card(Suit.CLUBS, Rank.FIVE);
    cards[4] = new Card(Suit.DIAMONDS, Rank.FIVE);
    cards[3] = new Card(Suit.getRandomSuit(), Rank.getRandomRank());
    cards[2] = new Card(Suit.getRandomSuit(), Rank.getRandomRank());
    cards[1] = new Card(Suit.HEARTS, Rank.ACE);
    cards[0] = new Card(Suit.SPADES, Rank.KING);
    Deck d = new Deck(cards);
    game.initializeGame(d);
    Stack<Card> top = game.playerOnesCards();
    Stack<Card> bottom = game.playerTwosCards();
    Stack<Card> combined = game.combineStacks(top, bottom);
    assertEquals(cards[4], combined.pop());
    assertEquals(cards[2], combined.pop());
    assertEquals(cards[0], combined.pop());
    assertEquals(cards[5], combined.pop());
    assertEquals(cards[3], combined.pop());
    assertEquals(cards[1], combined.pop());
  }

}

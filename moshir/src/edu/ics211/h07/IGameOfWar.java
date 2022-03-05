package edu.ics211.h07;

/**
 * Represents a IGameOfWar.
 *
 * @author Cam Moore
 *
 */
public interface IGameOfWar {
  /**
   * Initializes the game with the given deck. Each player should be dealt half the cards in the deck.
   * 
   * @param d the Deck to use.
   */
  void initializeGame(Deck d);


  /**
   * Plays one round of the game.
   * 
   * @return true if one of the players wins, false otherwise.
   */
  boolean playARound();


  /**
   * Returns player one's stack of cards. Ready for the next round.
   * 
   * @return player one's stack of cards.
   */
  Stack<Card> playerOnesCards();


  /**
   * Returns player two's stack of cards. Ready for the next round.
   * 
   * @return player two's stack of cards.
   */
  Stack<Card> playerTwosCards();


  /**
   * Returns a Stack of cards that is the combination of top and bottom. The top stack should be on top of the bottom
   * stack.
   * 
   * @param top the top stack.
   * @param bottom the bottom stack.
   * @return a Stack of cards.
   */
  Stack<Card> combineStacks(Stack<Card> top, Stack<Card> bottom);
}

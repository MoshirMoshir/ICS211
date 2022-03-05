package edu.ics211.h07;

import edu.ics211.h07.Stack;
import java.util.Arrays;

/**
 * Represents a Game of war.
 * @author Alexander Moshir
 *
 */
public class GameOfWar implements IGameOfWar {
    
  Stack<Card> playerOne = new Stack<Card>();
  Stack<Card> playerTwo = new Stack<Card>();

  /**
   * Initializes GameOfWar.
   */
  public GameOfWar() {
      // TODO Auto-generated constructor stub
  }

  /**
   * Deals the cards out to each player.
   * @param d deck to be delt
   */
  @Override
  public void initializeGame(Deck d) {
    // deals cards
    for (int i = d.size(); i > 0; i = i - 2) {
      playerOne.push(d.dealACard());
      playerTwo.push(d.dealACard());
    }

  }

  /**
   * Players a round of war.
   * @returns true if game ended
   */
  @Override
  public boolean playARound() {
    Stack<Card> temp = new Stack<Card>();
    Card one = playerOne.pop();
    Card two = playerTwo.pop();
    temp.push(one);
    temp.push(two);

    // flip two more cards each if tied
    while (one.getRank().compareTo(two.getRank()) == 0) {
      // adds two face down to pile
      temp.push(playerOne.pop());
      temp.push(playerTwo.pop());
      // prepares to compare two more after face down cards drawn
      one = playerOne.pop();
      two = playerTwo.pop();
      temp.push(one);
      temp.push(two);
    }
    
    // checks win conditions and results
    if (one.getRank().compareTo(two.getRank()) > 0) {
      combineStacks(playerOne, temp);
    }
    
    if (one.getRank().compareTo(two.getRank()) < 0) {
      combineStacks(playerTwo, temp);
    }
    
    if (playerOne.empty() || playerTwo.empty()) {
      return true;
    }
    
    return false;
  }

  /**
   * gets playerOne cards.
   * @return playerOne's cards
   */
  @Override
  public Stack<Card> playerOnesCards() {
    return playerOne;
  }

  /**
   * gets playerTwo cards.
   * @return playerTwo's cards
   */
  @Override
  public Stack<Card> playerTwosCards() {
    return playerTwo;
  }

  /**
   * Combines two stacks together in order.
   * @param top stack
   * @param bottom stack
   * @return reverse the new stack in order
   */
  @Override
  public Stack<Card> combineStacks(Stack<Card> top, Stack<Card> bottom) {
    Stack<Card> temp = new Stack<Card>();
    Stack<Card> reverse = new Stack<Card>();
      
    // adds the top cards to deck
    while (!top.empty()) {
      temp.push(top.pop());
    }
      
    // adds the bottom cards to deck
    while (!bottom.empty()) {
      temp.push(bottom.pop());
    }
      
    // reverses the order so the top is on top and bottom on bottom
    while (!temp.empty()) {
      reverse.push(temp.pop());
    }

    return reverse;
  }

}

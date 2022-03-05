package edu.ics211.h07;

/**
 * Represents a Card.
 *
 * @author Cam Moore
 *
 */
public class Card {
  private Suit suit;
  private Rank rank;

  /**
   * Creates a new Card.
   *
   * @param suit the suit.
   * @param rank the rank.
   */
  public Card(Suit suit, Rank rank) {
    super();
    this.suit = suit;
    this.rank = rank;
  }


  /**
   * Returns the suit.
   *
   * @return the suit.
   */
  public Suit getSuit() {
    return suit;
  }


  /**
   * Returns the rank.
   *
   * @return the rank.
   */
  public Rank getRank() {
    return rank;
  }


  @Override
  public String toString() {
    return rank + " of " + suit;
  }

}

package org.nik.cardsdeck;

import java.util.Arrays;

public class Card {

	// The rank of the card
	private int rank;

	// The suit of the card
	private Suit suit;

	// The count of how many cards have ever been instantiated
	// A class (static) data member (field) b/c individual cards don't have
	// their own counters.
	private static int cardCounter = 0;

	public enum Suit {
		CLUBS, DIAMONDS, HEARTS, SPADES
	};

	// Codes for Non Numeric Ranks (Can do ranks with Enums too)
	public static final int ACE = 1;
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;

	// Card default constructor
	public Card() {
		// generate random numbers and pass to the 2 arg constructors
		// (note the slight awkwardness of getting a random element of an
		// enumeration)
		this((int) (Math.random() * 13),
				Suit.values()[(int) (Math.random() * Suit.values().length)]);
	}

	// Actual Constructor
	/**
	 * Creates a card of a given rank and suit.
	 *
	 * @param initRank
	 *            the rank of the new card
	 * @param initSuit
	 *            the suit of the new card
	 */
	public Card(int rank, Suit suit) {
		this.rank = rank;
		this.suit = suit;

		cardCounter++;
	}

	/**
	 * Returns the number of cards that have been created. This is a static
	 * method because the value of the counter does not depend on any particular
	 * object -- it is recorded in a static data member.
	 * 
	 * @return the number of cards that have been created
	 */
	public static int getCounter() {
		return cardCounter;
	}

	/**
	 * Returns the rank of this card.
	 *
	 * @return the rank of this card
	 */
	public int getRank() {
		return rank;
	}

	/**
	 * Returns the suit of this card.
	 *
	 * @return the suit of this card.
	 */
	public Suit getSuit() {
		return this.suit;
	}

	/**
	 * Determines if the given card equals this one
	 */
	public boolean equals(Card c) {
		// note that although Suits are objects, == works like you want it to
		// since there is only ever one instance of any particular enumerated
		// constant (but .equals will work too)
		return (rank == c.rank && suit == c.suit);
	}

	/**
	 * Returns a string representation of this card. The returned string will
	 * have one character for the rank (two if the rank is 10) followed by one
	 * for the suit.
	 *
	 * @return a string representation of this card
	 */
	public String toString() {

		String result = "";
		switch (rank) {
		case JACK:
			result = "J";
			break;
		case QUEEN:
			result = "Q";
			break;

		case KING:
			result = "K";
			break;

		case ACE:
			result = "A";
			break;

		default:
			String.valueOf(rank);
		}
		// enumerated constants have a toString method that returns their names;
		// we want the first character for compact display of cards
		result = result + suit.toString().charAt(0);
		return result;

	}
	
	
	public static void main(String[] args){
		Card c = new Card();
		Card c2 = new Card(3, Suit.CLUBS);
		Card c3 = new Card(3, Suit.CLUBS);
		
		System.out.println(Suit.DIAMONDS.compareTo(Suit.SPADES));
		System.out.println(Suit.HEARTS.ordinal());
		
		System.out.println(c + " " + c2 + " " + c3);
		System.out.println(Card.getCounter());
		System.out.println(c2.equals(c3));
		
		System.out.println(Arrays.toString(Suit.values())); // Check this out
	}

}

package org.nik.cardsdeck;

import java.util.ArrayList;

public class Deck {

	// Private Variables/Constants

	// The list of cards in the deck
	private ArrayList<Card> cards;

	/**
	 * Creates a deck of 52 cards. The cards will be ordered according to suit
	 * with clubs on top followed by, diamonds, hearts, and spades. Within each
	 * suit the cards will be ordered from aces down to kings.
	 */
	public Deck() {
		this(1); //  call the other version of the constructor to make 1 copy of each card
		// any extra code that is needed (none here)
	}
	
	public Deck(int copies){
		cards = new ArrayList<Card>();
		
		//for each rank
		for(int r = Card.ACE; r <= Card.KING; r++)
		{
			// for each suit (Suit is declared in Card, so we access it
    		// with Card.Suit; values returns an array of elements to iterate over)
			for(Card.Suit s : Card.Suit.values())
			{
				for(int i = 0; i<copies; i++)
				{
					cards.add(new Card(r,s));
				}
			}
		}
	}
	
    /**
     * Returns a list of the cards in this deck.
     * 
     * @return a list of the cards in this deck
     */
    
    public ArrayList<Card> getCards()
    {
    	// note that we return a _copy_ of our list of cards so clients we
    	// return the list to can't mess us up by modifying the list we return
    	return new ArrayList<Card>(cards);
    }
    
    // Copy Constructor
    /**
	 * Creates a copy of the given deck.  (See also the clone method.)
	 * 
	 * @param other a deck
	 */
    public Deck(Deck other){
    	// deep as possible copy -- make a new ArrayList and a new Card
    	// for each element of the original list
    	/*
    	 
    	cards = new ArrayList<Card>();
    	for(Card c : other.cards)
    	{
    		cards.add(new Card(c.getRank(), c.getSuit()));
    	}
    	*
    	 */
    	// sort of deep copy -- make a new ArrayList but share the Cards
    	// (OK here b/c Card is immutable)
    	cards = new ArrayList<Card>(other.cards);
    }	
    
    /**
     * A static factory method.  
     * @param highCard
     * @return
     */
    public static Deck makeDeck(int highCard)
    {
    	// make an empty deck
    	Deck result = new Deck(0);

    	// add cards of selected ranks (note the repetitive code here and
    	// think about how to eliminate it...)
    	for(int r = Card.ACE; r<=highCard; r++){
    		
    		for(Card.Suit s : Card.Suit.values())
    		{
    			result.cards.add(new Card(r,s));
    		}
    	}
    	
    	return result;
    	
    }
    
    /**
     * Removes and returns the top card from this deck.
     *
     * @return the top card from this deck
     */
    public Card draw(){
    	return cards.remove(0);
    	
    }
    
    
    /**
     * Removes and returns a randomly chosen card from this deck.
     *
     * @return a randomly chosen card from this deck
     */
    public Card pickRandom()
    {
    	return null;
    }
    
    /**
     * Returns a string representation of this deck.
     *
     * @return a string representation of this deck
     */
    public String toString()
    {
    	return cards.toString();
    }
    
    
    public static void main(String[] args){
    	Deck doubleDeck = new Deck(2); // Make a deck with 2 of each card.
    	Deck smallDeck =  Deck.makeDeck(4); // make a deck of A to 4  of each suit
    	
    	System.out.println("Short : " + smallDeck);
    	System.out.println("Original : " + doubleDeck);
    	
    	// make a copy of an Existing Deck
    	Deck copy = new Deck(doubleDeck);
    	doubleDeck.draw();
    	
    	System.out.println("Modified: " + doubleDeck );
    	System.out.println("Copy : " + copy);
    }
    

}

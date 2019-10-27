package a2test;

import static org.junit.Assert.*;

import org.junit.Test;

import a2.Card;

import a2.Card;
import a2.CardImpl;

public class A2NoviceTests {

	@Test
	public void basicCardTest() {
		// Generate and confirm each kind of possible card.
		
		for (Card.Suit s : Card.Suit.values()) {
			for (int rank = 2; rank <= CardImpl.ACE; rank++) {
				Card card = new CardImpl(rank, s);
				assertEquals(rank, card.r());
				assertEquals(s, card.s());
			}
		}
	}
	
	@Test
	public void cardEqualsTest() {
		Card four_of_hearts = new CardImpl(4, Card.Suit.HEARTS);
		Card four_of_clubs = new CardImpl(4, Card.Suit.CLUBS);
		Card ace_of_hearts = new CardImpl(14, Card.Suit.HEARTS);
		Card ace_of_spades = new CardImpl(14, Card.Suit.SPADES);
		
		assertFalse(four_of_hearts.equals(four_of_clubs));
		assertFalse(four_of_hearts.equals(ace_of_hearts));
		assertFalse(four_of_hearts.equals(ace_of_spades));
		assertFalse(four_of_clubs.equals(four_of_hearts));
		assertFalse(ace_of_hearts.equals(four_of_hearts));
		assertFalse(ace_of_spades.equals(four_of_hearts));
		
		Card other_four_of_hearts = new CardImpl(4, Card.Suit.HEARTS);
		Card other_four_of_clubs = new CardImpl(4, Card.Suit.CLUBS);
		Card other_ace_of_hearts = new CardImpl(14, Card.Suit.HEARTS);
		Card other_ace_of_spades = new CardImpl(14, Card.Suit.SPADES);
		
		assertTrue(four_of_hearts.equals(other_four_of_hearts));
		assertTrue(other_four_of_hearts.equals(four_of_hearts));
		assertTrue(four_of_clubs.equals(other_four_of_clubs));
		assertTrue(other_four_of_clubs.equals(four_of_clubs));
		assertTrue(ace_of_hearts.equals(other_ace_of_hearts));
		assertTrue(other_ace_of_hearts.equals(ace_of_hearts));
		assertTrue(ace_of_spades.equals(other_ace_of_spades));
		assertTrue(other_ace_of_spades.equals(ace_of_spades));
		
	}

}

package a2test;

import static org.junit.Assert.*;

import org.junit.Test;

import a2.Card;
import a2.CardImpl;

import a2.PokerHand;
import a2.PokerHandImpl;

public class A2AdeptTests {

	static Card two_of_hearts = new CardImpl(2, Card.Suit.HEARTS);
	static Card three_of_hearts = new CardImpl(3, Card.Suit.HEARTS);
	static Card four_of_hearts = new CardImpl(4, Card.Suit.HEARTS);
	static Card five_of_hearts = new CardImpl(5, Card.Suit.HEARTS);
	static Card six_of_hearts = new CardImpl(6, Card.Suit.HEARTS);
	static Card ace_of_hearts = new CardImpl(14, Card.Suit.HEARTS);
	
	static Card two_of_spades = new CardImpl(2, Card.Suit.SPADES);
	static Card three_of_spades = new CardImpl(3, Card.Suit.SPADES);

	static Card two_of_clubs = new CardImpl(2, Card.Suit.CLUBS);
	static Card two_of_diamonds = new CardImpl(2, Card.Suit.DIAMONDS);
	
	static Card ten_of_diamonds = new CardImpl(10, Card.Suit.DIAMONDS);
	
	@Test
	public void testGetCards() {
		
		Card[] cards = {two_of_hearts, three_of_hearts, four_of_hearts, five_of_hearts, six_of_hearts};
		
		PokerHand hand = new PokerHandImpl(cards);

		Card[] cards_back = hand.getCards();
		
		assertNotNull(cards_back);
		assertEquals(5, cards_back.length);
		assertNotNull(cards_back[0]);
		assertNotNull(cards_back[1]);
		assertNotNull(cards_back[2]);
		assertNotNull(cards_back[3]);
		assertNotNull(cards_back[4]);

		for (Card c : cards) {
			boolean found = false;
			for (int i=0; i<5; i++) {
				if (cards_back[i].equals(c)) {
					found = true;
					break;
				}
			}
			if (!found) {
				fail("Did not find expected card");
			}
		}
	}
	
	@Test
	public void testGetHandValue() {
		PokerHand high_hand = new PokerHandImpl(new Card[] {two_of_hearts, ten_of_diamonds, four_of_hearts, five_of_hearts, six_of_hearts});
		PokerHand one_pair_hand = new PokerHandImpl(new Card[] {two_of_hearts, two_of_spades, four_of_hearts, five_of_hearts, six_of_hearts});
		PokerHand two_pair_hand = new PokerHandImpl(new Card[] {two_of_hearts, two_of_spades, three_of_hearts, three_of_spades, six_of_hearts});
		PokerHand three_of_a_kind_hand = new PokerHandImpl(new Card[] {two_of_hearts, two_of_spades, two_of_clubs, three_of_spades, six_of_hearts});
		PokerHand straight_hand = new PokerHandImpl(new Card[] {two_of_hearts, three_of_spades, four_of_hearts, five_of_hearts, six_of_hearts});
		PokerHand flush_hand = new PokerHandImpl(new Card[] {two_of_hearts, ace_of_hearts, four_of_hearts, five_of_hearts, six_of_hearts});
		PokerHand full_house_hand = new PokerHandImpl(new Card[] {two_of_hearts, two_of_spades, three_of_hearts, three_of_spades, two_of_clubs});
		PokerHand four_of_a_kind_hand = new PokerHandImpl(new Card[] {two_of_hearts, two_of_spades, three_of_hearts, two_of_diamonds, two_of_clubs});
		PokerHand straight_flush_hand = new PokerHandImpl(new Card[] {two_of_hearts, three_of_hearts, four_of_hearts, five_of_hearts, six_of_hearts});
		PokerHand wheel_straight_hand = new PokerHandImpl(new Card[] {ace_of_hearts, two_of_spades, three_of_spades, four_of_hearts, five_of_hearts});
		PokerHand wheel_straight_flush_hand = new PokerHandImpl(new Card[] {ace_of_hearts, two_of_hearts, three_of_hearts, four_of_hearts, five_of_hearts});
		
		assertEquals(1, high_hand.getHandTypeValue());
		assertEquals(2, one_pair_hand.getHandTypeValue());
		assertEquals(3, two_pair_hand.getHandTypeValue());
		assertEquals(4, three_of_a_kind_hand.getHandTypeValue());
		assertEquals(5, straight_hand.getHandTypeValue());
		assertEquals(6, flush_hand.getHandTypeValue());
		assertEquals(7, full_house_hand.getHandTypeValue());
		assertEquals(8, four_of_a_kind_hand.getHandTypeValue());
		assertEquals(9, straight_flush_hand.getHandTypeValue());
		assertEquals(5, wheel_straight_hand.getHandTypeValue());
		assertEquals(9, wheel_straight_flush_hand.getHandTypeValue());
		
	}
	
	@Test
	public void testGetHandRank() {
		PokerHand high_hand = new PokerHandImpl(new Card[] {two_of_hearts, ten_of_diamonds, four_of_hearts, five_of_hearts, six_of_hearts});
		PokerHand one_pair_hand = new PokerHandImpl(new Card[] {two_of_hearts, two_of_spades, four_of_hearts, five_of_hearts, six_of_hearts});
		PokerHand two_pair_hand = new PokerHandImpl(new Card[] {two_of_hearts, two_of_spades, three_of_hearts, three_of_spades, six_of_hearts});
		PokerHand three_of_a_kind_hand = new PokerHandImpl(new Card[] {two_of_hearts, two_of_spades, two_of_clubs, three_of_spades, six_of_hearts});
		PokerHand straight_hand = new PokerHandImpl(new Card[] {two_of_hearts, three_of_spades, four_of_hearts, five_of_hearts, six_of_hearts});
		PokerHand flush_hand = new PokerHandImpl(new Card[] {two_of_hearts, ace_of_hearts, four_of_hearts, five_of_hearts, six_of_hearts});
		PokerHand full_house_hand = new PokerHandImpl(new Card[] {two_of_hearts, two_of_spades, three_of_hearts, three_of_spades, two_of_clubs});
		PokerHand four_of_a_kind_hand = new PokerHandImpl(new Card[] {two_of_hearts, two_of_spades, three_of_hearts, two_of_diamonds, two_of_clubs});
		PokerHand straight_flush_hand = new PokerHandImpl(new Card[] {two_of_hearts, three_of_hearts, four_of_hearts, five_of_hearts, six_of_hearts});
		PokerHand wheel_straight_hand = new PokerHandImpl(new Card[] {ace_of_hearts, two_of_spades, three_of_spades, four_of_hearts, five_of_hearts});
		PokerHand wheel_straight_flush_hand = new PokerHandImpl(new Card[] {ace_of_hearts, two_of_hearts, three_of_hearts, four_of_hearts, five_of_hearts});
		
		assertEquals(10, high_hand.getHandRank());
		assertEquals(2, one_pair_hand.getHandRank());
		assertEquals(3, two_pair_hand.getHandRank());
		assertEquals(2, three_of_a_kind_hand.getHandRank());
		assertEquals(6, straight_hand.getHandRank());
		assertEquals(14, flush_hand.getHandRank());
		assertEquals(2, full_house_hand.getHandRank());
		assertEquals(2, four_of_a_kind_hand.getHandRank());
		assertEquals(6, straight_flush_hand.getHandRank());
		assertEquals(5, wheel_straight_hand.getHandRank());
		assertEquals(5, wheel_straight_flush_hand.getHandRank());
		
	}
	
	@Test
	public void testContains() {
		PokerHand high_hand = new PokerHandImpl(new Card[] {two_of_hearts, ten_of_diamonds, four_of_hearts, five_of_hearts, six_of_hearts});
		assertTrue(high_hand.contains(two_of_hearts));
		assertTrue(high_hand.contains(ten_of_diamonds));
		assertTrue(high_hand.contains(four_of_hearts));
		assertTrue(high_hand.contains(five_of_hearts));
		assertTrue(high_hand.contains(six_of_hearts));

		assertFalse(high_hand.contains(ace_of_hearts));
		assertFalse(high_hand.contains(three_of_hearts));
		assertFalse(high_hand.contains(three_of_spades));
		assertFalse(high_hand.contains(two_of_spades));
		assertFalse(high_hand.contains(two_of_clubs));
		assertFalse(high_hand.contains(two_of_diamonds));
	}
	
	@Test
	public void testCompareTo() {
		PokerHand high_hand = new PokerHandImpl(new Card[] {two_of_hearts, ten_of_diamonds, four_of_hearts, five_of_hearts, six_of_hearts});
		PokerHand one_pair_hand = new PokerHandImpl(new Card[] {two_of_hearts, two_of_spades, four_of_hearts, five_of_hearts, six_of_hearts});
		PokerHand two_pair_hand = new PokerHandImpl(new Card[] {two_of_hearts, two_of_spades, three_of_hearts, three_of_spades, six_of_hearts});
		PokerHand three_of_a_kind_hand = new PokerHandImpl(new Card[] {two_of_hearts, two_of_spades, two_of_clubs, three_of_spades, six_of_hearts});
		PokerHand straight_hand = new PokerHandImpl(new Card[] {two_of_hearts, three_of_spades, four_of_hearts, five_of_hearts, six_of_hearts});
		PokerHand flush_hand = new PokerHandImpl(new Card[] {two_of_hearts, ace_of_hearts, four_of_hearts, five_of_hearts, six_of_hearts});
		PokerHand full_house_hand = new PokerHandImpl(new Card[] {two_of_hearts, two_of_spades, three_of_hearts, three_of_spades, two_of_clubs});
		PokerHand four_of_a_kind_hand = new PokerHandImpl(new Card[] {two_of_hearts, two_of_spades, three_of_hearts, two_of_diamonds, two_of_clubs});
		PokerHand straight_flush_hand = new PokerHandImpl(new Card[] {two_of_hearts, three_of_hearts, four_of_hearts, five_of_hearts, six_of_hearts});
		
		assertEquals(0, high_hand.compareTo(high_hand));
		assertEquals(-1, high_hand.compareTo(one_pair_hand));
		assertEquals(-1, high_hand.compareTo(two_pair_hand));
		assertEquals(-1, high_hand.compareTo(three_of_a_kind_hand));
		assertEquals(-1, high_hand.compareTo(straight_hand));
		assertEquals(-1, high_hand.compareTo(flush_hand));
		assertEquals(-1, high_hand.compareTo(full_house_hand));
		assertEquals(-1, high_hand.compareTo(four_of_a_kind_hand));
		assertEquals(-1, high_hand.compareTo(straight_flush_hand));
		
		assertEquals(1, one_pair_hand.compareTo(high_hand));
		assertEquals(0, one_pair_hand.compareTo(one_pair_hand));
		assertEquals(-1, one_pair_hand.compareTo(two_pair_hand));
		assertEquals(-1, one_pair_hand.compareTo(three_of_a_kind_hand));
		assertEquals(-1, one_pair_hand.compareTo(straight_hand));
		assertEquals(-1, one_pair_hand.compareTo(flush_hand));
		assertEquals(-1, one_pair_hand.compareTo(full_house_hand));
		assertEquals(-1, one_pair_hand.compareTo(four_of_a_kind_hand));
		assertEquals(-1, one_pair_hand.compareTo(straight_flush_hand));

		assertEquals(1, two_pair_hand.compareTo(high_hand));
		assertEquals(1, two_pair_hand.compareTo(one_pair_hand));
		assertEquals(0, two_pair_hand.compareTo(two_pair_hand));
		assertEquals(-1, two_pair_hand.compareTo(three_of_a_kind_hand));
		assertEquals(-1, two_pair_hand.compareTo(straight_hand));
		assertEquals(-1, two_pair_hand.compareTo(flush_hand));
		assertEquals(-1, two_pair_hand.compareTo(full_house_hand));
		assertEquals(-1, two_pair_hand.compareTo(four_of_a_kind_hand));
		assertEquals(-1, two_pair_hand.compareTo(straight_flush_hand));

		assertEquals(1, three_of_a_kind_hand.compareTo(high_hand));
		assertEquals(1, three_of_a_kind_hand.compareTo(one_pair_hand));
		assertEquals(1, three_of_a_kind_hand.compareTo(two_pair_hand));
		assertEquals(0, three_of_a_kind_hand.compareTo(three_of_a_kind_hand));
		assertEquals(-1, three_of_a_kind_hand.compareTo(straight_hand));
		assertEquals(-1, three_of_a_kind_hand.compareTo(flush_hand));
		assertEquals(-1, three_of_a_kind_hand.compareTo(full_house_hand));
		assertEquals(-1, three_of_a_kind_hand.compareTo(four_of_a_kind_hand));
		assertEquals(-1, three_of_a_kind_hand.compareTo(straight_flush_hand));

		assertEquals(1, straight_hand.compareTo(high_hand));
		assertEquals(1, straight_hand.compareTo(one_pair_hand));
		assertEquals(1, straight_hand.compareTo(two_pair_hand));
		assertEquals(1, straight_hand.compareTo(three_of_a_kind_hand));
		assertEquals(0, straight_hand.compareTo(straight_hand));
		assertEquals(-1, straight_hand.compareTo(flush_hand));
		assertEquals(-1, straight_hand.compareTo(full_house_hand));
		assertEquals(-1, straight_hand.compareTo(four_of_a_kind_hand));
		assertEquals(-1, straight_hand.compareTo(straight_flush_hand));

		assertEquals(1, flush_hand.compareTo(high_hand));
		assertEquals(1, flush_hand.compareTo(one_pair_hand));
		assertEquals(1, flush_hand.compareTo(two_pair_hand));
		assertEquals(1, flush_hand.compareTo(three_of_a_kind_hand));
		assertEquals(1, flush_hand.compareTo(straight_hand));
		assertEquals(0, flush_hand.compareTo(flush_hand));
		assertEquals(-1, flush_hand.compareTo(full_house_hand));
		assertEquals(-1, flush_hand.compareTo(four_of_a_kind_hand));
		assertEquals(-1, flush_hand.compareTo(straight_flush_hand));

		assertEquals(1, full_house_hand.compareTo(high_hand));
		assertEquals(1, full_house_hand.compareTo(one_pair_hand));
		assertEquals(1, full_house_hand.compareTo(two_pair_hand));
		assertEquals(1, full_house_hand.compareTo(three_of_a_kind_hand));
		assertEquals(1, full_house_hand.compareTo(straight_hand));
		assertEquals(1, full_house_hand.compareTo(flush_hand));
		assertEquals(0, full_house_hand.compareTo(full_house_hand));
		assertEquals(-1, full_house_hand.compareTo(four_of_a_kind_hand));
		assertEquals(-1, full_house_hand.compareTo(straight_flush_hand));

		assertEquals(1, four_of_a_kind_hand.compareTo(high_hand));
		assertEquals(1, four_of_a_kind_hand.compareTo(one_pair_hand));
		assertEquals(1, four_of_a_kind_hand.compareTo(two_pair_hand));
		assertEquals(1, four_of_a_kind_hand.compareTo(three_of_a_kind_hand));
		assertEquals(1, four_of_a_kind_hand.compareTo(straight_hand));
		assertEquals(1, four_of_a_kind_hand.compareTo(flush_hand));
		assertEquals(1, four_of_a_kind_hand.compareTo(full_house_hand));
		assertEquals(0, four_of_a_kind_hand.compareTo(four_of_a_kind_hand));
		assertEquals(-1, four_of_a_kind_hand.compareTo(straight_flush_hand));

		assertEquals(1, straight_flush_hand.compareTo(high_hand));
		assertEquals(1, straight_flush_hand.compareTo(one_pair_hand));
		assertEquals(1, straight_flush_hand.compareTo(two_pair_hand));
		assertEquals(1, straight_flush_hand.compareTo(three_of_a_kind_hand));
		assertEquals(1, straight_flush_hand.compareTo(straight_hand));
		assertEquals(1, straight_flush_hand.compareTo(flush_hand));
		assertEquals(1, straight_flush_hand.compareTo(full_house_hand));
		assertEquals(1, straight_flush_hand.compareTo(four_of_a_kind_hand));
		assertEquals(0, straight_flush_hand.compareTo(straight_flush_hand));
	}	

}

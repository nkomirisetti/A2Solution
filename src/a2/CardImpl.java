package a2;

public class CardImpl implements Card {
	private static String[] strings = {null, null, "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
	
	public static final int JACK = 11;
	public static final int QUEEN = 12;
	public static final int KING = 13;
	public static final int ACE = 14;


	public int rank;
	public Card.Suit suit;

	public CardImpl(int rank, Card.Suit suit) {
		this.rank = rank;
		this.suit = suit;
	}
	
	public int r() {
		return rank;
	}

	public Suit s() {
		return suit;
	}

	public boolean equals(Card other) {
		return (rank == other.r()) && (suit == other.s());
	}
	
	public String toString() {
		return strings[r()] + " of " + Card.suitToString(s());
	}

}

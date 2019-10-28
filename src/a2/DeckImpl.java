package a2;

public class DeckImpl implements Deck {
	
	//Instance fields
	
	private Card[] newvar;			
	private int _num_left_to_deal;
	
	
	
	//Constructor
	public DeckImpl() {
		_num_left_to_deal = 52;
		newvar = new Card[_num_left_to_deal];

		int cidx = 0;
		for (Card.Suit s : Card.Suit.values()) {
			for (int rank = 2; rank <= CardImpl.ACE; rank++) {
				//System.out.println(rank);
				newvar[cidx] = new CardImpl(rank, s);
				cidx += 1;
			}
		}
		
		for (int i=0; i<newvar.length; i++) {
			int swap_idx = i + ((int) (Math.random() * (newvar.length - i)));
			Card tmp = newvar[i];
			
			newvar[i] = newvar[swap_idx];
			
			newvar[swap_idx] = tmp;
		}		
	}

	//Returns boolean
	public boolean hasHand() {
		boolean bool = false;
		if (_num_left_to_deal >= 5) {
			bool = true;
		}
		return (bool);
	}

	//Returns card
	public Card dealNextCard() {
		if (_num_left_to_deal== 0) {
			throw new RuntimeException();
		}
		Card dealtCard = newvar[nextUndealtIndex()];
		_num_left_to_deal -= 1;
		return dealtCard;
	}

	//Returns PokerHand
	public PokerHand dealHand() {
		if (hasHand() == false) {
			throw new RuntimeException("Deck does not have enough cards to deal another hand");
		}
		
		Card[] hand_cards = new Card[5];
		for (int i=0; i<hand_cards.length; i++) {
			
			hand_cards[i] = dealNextCard();
		}
		PokerHand h = new PokerHandImpl(hand_cards);
		return h;
	}	

	//Returns void
	public void findAndRemove(Card c) {
		if (_num_left_to_deal == 0) {
			return;
		}
		
		for (int i=nextUndealtIndex(); i<52; i++) {
			if (newvar[i].equals(c)) {
				Card tmp = newvar[i];
				newvar[i] = newvar[nextUndealtIndex()];
				newvar[nextUndealtIndex()] = tmp;
				dealNextCard();
				return;
			}
		}
		return;
	}
	private int nextUndealtIndex() {
		int x = 52-_num_left_to_deal;
		return x;
	}
}

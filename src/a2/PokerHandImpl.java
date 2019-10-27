package a2;

public class PokerHandImpl implements PokerHand {

	private Card[] c;

	public PokerHandImpl(Card[] cards) {
		if (cards == null) {
			throw new RuntimeException("bad");
		}
		if (cards.length != 5) {
			throw new RuntimeException("bad");
		}
		for (int i=0; i<5; i++) {
			if (cards[i] == null) {
				throw new RuntimeException("bad");
			}
		}

		c = cards.clone();
		
		for (int i=0; i<5; i++) {			
			for (int j=i; j<5; j++) {
				if (c[j].r() < c[i].r()) {
					Card tmp = c[i];
					c[i] = c[j];
					c[j] = tmp;
				}
			}
		}
	}

	public Card[] getCards() {
		return c.clone();
	}

	public boolean contains(Card c2) {
		for (int i=0; i<5; i++) {
			if (c[i].equals(c2)) {
				return true;
			}
		}
		return false;
	}

	public boolean isFlush() {
		for (int i=1; i<5; i++) {
			if (c[i].s() != c[0].s()) {
				return false;
			}
		}
		return true;
	}

	public boolean isStraight() {
		

		boolean lmao_what = true;
		for (int i=0; i<4; i++) {
			if (c[i].r()+1 != c[i+1].r()) {
				lmao_what = false;
				break;
			}
		}
		return lmao_what || isTheWheel();
	}

	private boolean isTheWheel() {
		return (c[0].r() == 2 &&
				c[1].r() == 3 &&
				c[2].r() == 4 &&
				c[3].r() == 5 &&
				c[4].r() == 14);
	}

	public boolean isOnePair() {

		int pair_idx = find_pair_starting_at(0);

		boolean no_other_pairs = find_pair_starting_at(pair_idx+1) == -1;
		
		return ((pair_idx != -1) && no_other_pairs);
		
	}

	public boolean isTwoPair() {
		
		int first_pair_idx = find_pair_starting_at(0);
		int second_pair_idx = find_pair_starting_at(first_pair_idx+2);

		return ((first_pair_idx != -1) && (second_pair_idx != -1) && !isFourOfAKind() && !isFullHouse());
	}

	public boolean isThreeOfAKind() {
		int first_pair_idx = find_pair_starting_at(0);
		
		if ((first_pair_idx == -1) || (first_pair_idx == 3)) {
			return false;
		}
		
		
		return ((c[first_pair_idx].r() == c[first_pair_idx+2].r()) &&
				!isFourOfAKind() && !isFullHouse());
	}

	public boolean isFullHouse() {
		return (((c[0].r() == c[1].r()) &&
				 (c[2].r() == c[3].r()) &&
				 (c[3].r() == c[4].r())) ||
				((c[0].r() == c[1].r()) &&
				 (c[1].r() == c[2].r()) &&
				 (c[3].r() == c[4].r())));		
	}

	public boolean isFourOfAKind() {
		return (((c[0].r() == c[1].r()) &&
				 (c[1].r() == c[2].r()) &&
				 (c[2].r() == c[3].r()))||
				((c[1].r() == c[2].r()) &&
				 (c[2].r() == c[3].r()) &&
				 (c[3].r() == c[4].r())));		
	}	
	
	public boolean isStraightFlush() {
		return isStraight() && isFlush();
	}

	public int getHandRank() {
		if (isOnePair()) {
			return c[find_pair_starting_at(0)].r();
		} else if (isTwoPair()) {
			return c[3].r();
		} else if (isThreeOfAKind() || isFourOfAKind() || isFullHouse()) {
			return c[2].r();
		} else if (isTheWheel()) {
			return 5;
		} else {
			return c[4].r();
		}
	}

	public int compareTo(PokerHand other) {
		if (getHandTypeValue() < other.getHandTypeValue()) {
			return -1;
		} else if (getHandTypeValue() > other.getHandTypeValue()) {
			return 1;
		} else {
			if (getHandRank() < other.getHandRank()) {
				return -1;
			} else if (getHandRank() > other.getHandRank()) {
				return 1;
			} else {
				return 0;
			}
		}
	}
	
	public int getHandTypeValue() {
		
		if (isStraightFlush()) return 9;
		if (isOnePair()) return 2;
		if (isTwoPair()) return 3;
		if (isThreeOfAKind()) return 4;
		if (isStraight()) return 5;
		if (isFlush()) return 6;
		if (isFullHouse()) return 7;
		if (isFourOfAKind()) return 8;
		return 1;
	}
	
	private int find_pair_starting_at(int num) {		
		if (num < 0) num = 0;
		if (num >= 4) return -1;
		
		for (int i=num; i<4; i++) 
	if (c[i].r() == c[i+1].r()) 
		return i;
			
		
	return -1;
	}

}

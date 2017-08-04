/*
  CARD CLASS - represents a card from a deck of cards. The class should be able to store a card's 
  suit and face value. A cards suit can be one of the following: Hearts, Diamonds, Spades, or Clubs. 
  A cards face vale can be Ace, Jack, Queen, King, or a value in the range of 2 through 10. 
 */


public class Card {
	public static final int SPADE = 4;
	public static final int HEART = 3;
	public static final int CLUB = 2;
	public static final int DIAMOND = 1;
	private static final String[] Suit = {"*","D","C","H","S"};
	private static final String[] Rank = { "*", "*", "2", "3", "4",
			   "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
 
    private byte cardSuit;
    private byte cardRank;
	
	Card(int suit, int rank){
		if (rank == 1){
			cardRank = 14;
		} else{
			cardRank = (byte) rank;
		}
		cardSuit = (byte) suit;
	}
	public int suit(){
		return this.cardSuit;
	}
	public String suitStr(){
		return (Suit[cardSuit]);
	}
	public int rank(){
		return this.cardRank;
	}
	public String rankStr(){
		return (Rank[cardRank]);
	}
	public String toString(){
		return Rank[cardRank] + Suit[cardSuit];
	}
}

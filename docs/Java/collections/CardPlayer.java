import java.util.*;

/*
 	This should keep a list of Card objects that have been dealt to it. This represents a hand of cards.
 	A method named getCard should accept a reference to a Card object, which is added to the list. A method 
 	named showCards displays the Card objects in the list. 
 */
public class CardPlayer {
	public List<Card> hand = new ArrayList<Card>();
	
	CardPlayer() {
	    Deck test = new Deck();
		test.shuffle();
		System.out.println("Shuffle Deck:");
		test.getDeckInfo();
		System.out.println("Get a cards for hand");
		for (int i = 0 ; i < 5; i++){
			Card testCard = test.dealCard();
			getCard(testCard);
		}
		System.out.println("Deck without cards in deck.");
		test.getDeckInfo();
		showCards();
		
	}
	
	public void getCard( Card c ) {		
		hand.add(c);	
	}
	
	public void showCards(){
		System.out.println("Cards in the hand");
		for ( int i = 0; i < hand.size(); i++){
			System.out.println(hand.get(i));
		}
	}

}

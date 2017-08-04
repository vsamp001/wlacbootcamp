/*
 	Class constructor should create a list of 52 card objects, each representing a valid card in a deck of cards. The class should 
 	have a shuffle method that randomly shuffles the Card objects in the list. It should also have a deal method that deals with 
 	a card from the deck. It does this by removing the card object from the beginning of the list and returning a reference to that 
 	object
 */
import java.util.*;

public class Deck {
	public static final int NCARDS = 52;
	public List<Card> deckOfCards = new ArrayList<>();

	// Create an ArrayList to hold Card objects. 
	Deck(){
		for (int suit = Card.DIAMOND; suit <= Card.SPADE; suit++){
			for (int rank = 1; rank <= 13; rank++){
				deckOfCards.add(new Card(suit, rank));
			}
		}
	}
	public void shuffle(){
		int i, j, k;
		int n = 1000;
		for (k = 0; k < n; k++ )
		{
			i = (int)(Math.random() * NCARDS );
			j = (int)(Math.random() * NCARDS );
			Card temp = deckOfCards.get(i);
			deckOfCards.set(i, deckOfCards.get(j));
			deckOfCards.set(j, temp);
		}
	}
	
	//It does this by removing the card object from the beginning of the list and returning a reference to that object
 	public Card dealCard() {
 		return deckOfCards.remove(0);
 	}

 public void getDeckInfo(){
	 for(int i = 0; i < deckOfCards.size() ; i++){
            System.out.println(deckOfCards.get(i));
      }
 }
}
